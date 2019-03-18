package nju.riverxu.ds.view;

import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.GameState;
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
    private UpgradePanel upgradePanel = null;
    private CharacterInitPanel characterInitPanel = null;

    private Game game = null;

    private MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dim Souls");
        setSize(800, 800);
        setLocation(100, 100);
        setResizable(false);


        game = Game.getInstance();
        game.addObserver(this);

        assert game.getGameState() == GameState.GAME_INITING;
        setToInitPanel();

        setVisible(true);
    }

    public void notifyEvent(EventType eventType, Object event) {
        switch (eventType) {
            case GAME_STARTING:
                System.out.println("MainFrame: GAME_STARTING");
                resetPanels();
                break;
            default:
                break;
        }
    }

    private void resetPanels() {
        System.out.println("Reset panels:" + game.getGameState());
        switch (game.getGameState()) {
            case GAME_INITING:
                System.out.println("MainFrame: Setting to GAME_INIT panel.");
                setToInitPanel();
                break;
            case CHARACTER_INITING:
                System.out.println("MainFrame: Setting to CHARACTER_INIT panel.");
                setToCharacterInitPanel();
                break;
            case UPGRADE:
                System.out.println("MainFrame: Setting to UPGRADE panel.");
                setToUpgradePanel();
                break;
            case TOUR:
                System.out.println("MainFrame: Setting to TOUR panel.");
                setToDungeonPanel();
                break;
            default:
                break;
        }
        repaint();
    }

    private void clearPanels() {
        for (Component c : getContentPane().getComponents()) {
            c.setVisible(false);
            remove(c);
        }
    }

    private void setToInitPanel() {
        gameInitPanel = new GameInitPanel();
        clearPanels();
        getContentPane().add(gameInitPanel);
        gameInitPanel.setVisible(true);
    }

    private void setToDungeonPanel() {
        tourPanel = new TourPanel();
        clearPanels();
        getContentPane().add(tourPanel);
        tourPanel.setVisible(true);
    }

    private void setToUpgradePanel() {
        upgradePanel = new UpgradePanel();
        clearPanels();
        getContentPane().add(upgradePanel);
        upgradePanel.setVisible(true);
    }

    private void setToCharacterInitPanel() {
        characterInitPanel = new CharacterInitPanel();
        clearPanels();
        getContentPane().add(characterInitPanel);
        characterInitPanel.setVisible(true);
    }
}
