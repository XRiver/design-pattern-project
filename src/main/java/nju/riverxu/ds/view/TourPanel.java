package nju.riverxu.ds.view;

import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.GameStatus;
import nju.riverxu.ds.model.TourManager;
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

    public TourPanel() {
        Game game = Game.getInstance();
        tourManager = game.getTourManager();

        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(0, 0));


        assert game.getGameStatus()== GameStatus.TOUR;
        tour = tourManager.getCurrentTour();
        //TODO init DungeonPanel, LogPanel and add them to this


        logPanel = new LogPanel();

        add(dungeonPanel, BorderLayout.CENTER);
        add(logPanel, BorderLayout.EAST);

        // Listen to events that dungeon changes.
        tourManager.addObserver(this);

        setVisible(true);
    }


    public void notifyEvent(EventType eventType, Object event) {
        switch (eventType) {
            case TOUR_END:
                tourManager.removeObserver(this);
                System.out.println("Removing TourPanel from TourManager's observer list.");
                break;
            //TODO
            default:
                break;
        }
    }
}
