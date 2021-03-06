package nju.riverxu.ds.view;

import nju.riverxu.ds.Main;
import nju.riverxu.ds.controller.TourController;
import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.GameState;
import nju.riverxu.ds.model.TourManager;
import nju.riverxu.ds.model.tour.Dungeon;
import nju.riverxu.ds.model.tour.Tour;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * 用来显示一次冒险，可能会中间替换显示地图的DungeonPanel
 * 应该监听TourManager/Tour，免于重复创建DungeonPanel；当Tour里面的Dungeon变换，this应当收到通知，动态替换DungeonPanel
 */
public class TourPanel extends JPanel implements Observer {

    private TourManager tourManager = null;
    private Tour tour = null;

    private DungeonPanel dungeonPanel = null;
    private LogPanel logPanel = null;

    private TourController controller = null;

    private MainFrame mf = MainFrame.getInstance();

    public TourPanel() {
        Game game = Game.getInstance();
        tourManager = game.getTourManager();

        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(0, 0));


        assert game.getGameState()== GameState.TOUR;
        tour = tourManager.getCurrentTour();
        // Listen to events that dungeon changes.
        tour.addObserver(this);

        dungeonPanel = new DungeonPanel(tour.getCurrent());
        add(dungeonPanel, BorderLayout.CENTER);

        logPanel = new LogPanel();
        add(logPanel, BorderLayout.SOUTH);

        controller = tourManager.getTourController();
        assert controller != null;

        mf.addKeyListener(controller);

        //logPanel.area.addKeyListener(controller);
        //dungeonPanel.addKeyListener();
        setVisible(true);
        mf.requestFocus();
    }


    public void notifyEvent(EventType eventType, Object event) {
        switch (eventType) {
            case TOUR_END:
                assert event == tour;
                tour.removeObserver(this);
                mf.removeKeyListener(controller);
                System.out.println("TourPanel: Removing TourPanel from TourManager's observer list.");
                break;
            case DUNGEON_SWITCHED:
                switchDungeon((Dungeon) event);
                break;
            default:
                break;
        }
    }

    private void switchDungeon(Dungeon d) {
        remove(dungeonPanel);
        dungeonPanel = new DungeonPanel(d);
        //dungeonPanel.addKeyListener(tourManager.getTourController());
        add(dungeonPanel);
    }
}
