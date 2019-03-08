package nju.riverxu.ds.view;

import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.GameStatus;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observer;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Observer {

    private static MainFrame instance = new MainFrame();

    public static MainFrame getInstance() {
        return instance;
    }

    private GameInitPanel gameInitPanel = null;
    private TourPanel tourPanel = null;
    private LogPanel logPanel = null;
    private UpgradePanel upgradePanel = null;

    private Game game = null;

    private MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dim Souls");
        setSize(800, 800);
        setLocation(100, 100);


        game = Game.getInstance();
        game.addObserver(this);

        assert game.getGameStatus() == GameStatus.INITING;
        setToInitPanel();

        setVisible(true);
        // addKeyListener(new HeroController());
    }

    public void notifyEvent(EventType eventType, Object event) {
        switch (eventType) {
            case GAME_STARTING:
                setTitle("GAME IS ON");
                assert game.getGameStatus() != GameStatus.INITING;
                resetPanels();
                break;
            default:
                break;
        }
    }

    private void resetPanels() {
        switch (game.getGameStatus()) {
            case INITING:
                setToInitPanel();
                break;
            case UPGRADE:
                setToUpgradePanel();
                break;
            case TOUR:
                setToDungeonPanel();
                break;
            default:
                break;
        }
    }

    private void clearPanels() {
        for (Component c: getComponents()) {
            c.setVisible(false);
            remove(c);
        }
    }

    private void setToInitPanel() {
        gameInitPanel = new GameInitPanel();
        clearPanels();

        add(gameInitPanel);
    }

    private void setToDungeonPanel() {
        tourPanel = new TourPanel();
        add(tourPanel);
        //TODO
    }

    private void setToUpgradePanel() {
        //TODO
    }
}
