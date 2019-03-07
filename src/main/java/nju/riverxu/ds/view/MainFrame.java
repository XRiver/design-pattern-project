package nju.riverxu.ds.view;

import nju.riverxu.ds.controller.HeroController;
import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.GameStatus;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements Observer {

    private static MainFrame instance = new MainFrame();

    public static MainFrame getInstance() {
        return instance;
    }

    private GameInitPanel gameInitPanel = null;
    private DungeonPanel dungeonPanel = null;
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
        gameInitPanel = new GameInitPanel();
        add(gameInitPanel);

        setVisible(true);
        // addKeyListener(new HeroController());
    }

    public void notifyEvent(EventType eventType, Object event) {
        switch (eventType) {
            case GAME_STARTING:
                setTitle("GAME IS ON");
                //TODO query game state and show corresponding panels.
                break;
            default:
                break;
        }
    }
}
