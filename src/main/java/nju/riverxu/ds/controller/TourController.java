package nju.riverxu.ds.controller;

import nju.riverxu.ds.controller.keyboard.DefaultHeroControllerConfig;
import nju.riverxu.ds.controller.keyboard.HeroControllerConfig;
import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.GameState;
import nju.riverxu.ds.model.tour.Tour;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 负责处理冒险过程中各种键盘输入；包括ESC之类的全局操作
 */
public class TourController implements KeyListener {

    /**
     * 负责处理对英雄的操作
     */
    private HeroControllerConfig conf = null;

    private Game game = null;
    private Tour tour = null;

    public TourController(Tour tour) {
        game = Game.getInstance();
        assert game.getGameState()== GameState.TOUR;

        this.tour = tour;

        conf = new DefaultHeroControllerConfig(tour.getHero());
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
