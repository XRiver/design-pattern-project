package nju.riverxu.ds.controller;

import nju.riverxu.ds.controller.keyboard.DefaultHeroControllerConfig;
import nju.riverxu.ds.controller.keyboard.HeroControllerConfig;
import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TourController implements KeyListener {

    private HeroControllerConfig conf = null;
    private Game game = null;
    public TourController() {
        game = Game.getInstance();
        assert game.getGameState()== GameState.TOUR;

        conf = new DefaultHeroControllerConfig(game.getTourManager().getCurrentTour().getHero());
    }

    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
            //TODO Try exit tour? Maybe...
        } else {
            conf.keyTyped(e);
        }
    }

    public void keyPressed(KeyEvent e) {
        conf.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        conf.keyPressed(e);
    }

    public HeroControllerConfig getConf() {
        return conf;
    }

    public void setConf(HeroControllerConfig conf) {
        this.conf = conf;
    }
}
