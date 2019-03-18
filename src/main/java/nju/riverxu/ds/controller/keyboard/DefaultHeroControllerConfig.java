package nju.riverxu.ds.controller.keyboard;

import nju.riverxu.ds.model.spirit.hero.Hero;

import java.awt.event.KeyEvent;

public class DefaultHeroControllerConfig implements HeroControllerConfig {

    private Hero hero = null;
    public DefaultHeroControllerConfig(Hero hero) {
        this.hero = hero;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}
