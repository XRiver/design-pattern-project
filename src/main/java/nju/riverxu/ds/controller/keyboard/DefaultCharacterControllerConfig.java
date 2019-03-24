package nju.riverxu.ds.controller.keyboard;

import nju.riverxu.ds.model.spirit.hero.ActionSlot;
import nju.riverxu.ds.model.spirit.Direction;
import nju.riverxu.ds.model.spirit.hero.OperatedCharacter;

import java.awt.event.KeyEvent;

/**
 * 移动：wasd
 * 右手/左手： j/k
 * 互动： L
 * 技能： uiop[
 * 道具：nm,./
 */
public class DefaultCharacterControllerConfig implements CharacterControllerConfig {

    private OperatedCharacter c = null;

    public DefaultCharacterControllerConfig(OperatedCharacter c) {
        this.c = c;
    }


    public void keyTyped(KeyEvent e) {
        System.out.println("DefaultCharacterControllerConfig: Typed " + e.getKeyChar());
        if (e.getKeyCode() == KeyEvent.VK_L) {
            c.interact();
        }
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("DefaultCharacterControllerConfig: Pressed " + e.getKeyChar());
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                c.startMove(Direction.NORTH);
                break;
            case KeyEvent.VK_S:
                c.startMove(Direction.SOUTH);
                break;
            case KeyEvent.VK_A:
                c.startMove(Direction.WEST);
                break;
            case KeyEvent.VK_D:
                c.startMove(Direction.EAST);
                break;
            case KeyEvent.VK_J:
                c.startUse(ActionSlot.RIGHT_HAND);
                break;
            case KeyEvent.VK_K:
                c.startUse(ActionSlot.LEFT_HAND);
                break;
            case KeyEvent.VK_U:
                c.startUse(ActionSlot.SKILL_1);
                break;
            case KeyEvent.VK_I:
                c.startUse(ActionSlot.SKILL_2);
                break;
            case KeyEvent.VK_O:
                c.startUse(ActionSlot.SKILL_3);
                break;
            case KeyEvent.VK_P:
                c.startUse(ActionSlot.SKILL_4);
                break;
            case KeyEvent.VK_LEFT_PARENTHESIS:
                c.startUse(ActionSlot.SKILL_5);
                break;
            case KeyEvent.VK_N:
                c.startUse(ActionSlot.CONS_1);
                break;
            case KeyEvent.VK_M:
                c.startUse(ActionSlot.CONS_2);
                break;
            case KeyEvent.VK_COMMA:
                c.startUse(ActionSlot.CONS_3);
                break;
            case KeyEvent.VK_PERIOD:
                c.startUse(ActionSlot.CONS_4);
                break;
            case KeyEvent.VK_SLASH:
                c.startUse(ActionSlot.CONS_5);
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("DefaultCharacterControllerConfig: Released " + e.getKeyChar());
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                c.stopMove(Direction.NORTH);
                break;
            case KeyEvent.VK_S:
                c.stopMove(Direction.SOUTH);
                break;
            case KeyEvent.VK_A:
                c.stopMove(Direction.WEST);
                break;
            case KeyEvent.VK_D:
                c.stopMove(Direction.EAST);
                break;
            case KeyEvent.VK_J:
                c.stopUse(ActionSlot.RIGHT_HAND);
                break;
            case KeyEvent.VK_K:
                c.stopUse(ActionSlot.LEFT_HAND);
                break;
            case KeyEvent.VK_U:
                c.stopUse(ActionSlot.SKILL_1);
                break;
            case KeyEvent.VK_I:
                c.stopUse(ActionSlot.SKILL_2);
                break;
            case KeyEvent.VK_O:
                c.stopUse(ActionSlot.SKILL_3);
                break;
            case KeyEvent.VK_P:
                c.stopUse(ActionSlot.SKILL_4);
                break;
            case KeyEvent.VK_LEFT_PARENTHESIS:
                c.stopUse(ActionSlot.SKILL_5);
                break;
            case KeyEvent.VK_N:
                c.stopUse(ActionSlot.CONS_1);
                break;
            case KeyEvent.VK_M:
                c.stopUse(ActionSlot.CONS_2);
                break;
            case KeyEvent.VK_COMMA:
                c.stopUse(ActionSlot.CONS_3);
                break;
            case KeyEvent.VK_PERIOD:
                c.stopUse(ActionSlot.CONS_4);
                break;
            case KeyEvent.VK_SLASH:
                c.stopUse(ActionSlot.CONS_5);
                break;
        }
    }
}
