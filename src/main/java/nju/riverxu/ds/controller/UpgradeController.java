package nju.riverxu.ds.controller;

import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.UpgradeManager;
import nju.riverxu.ds.model.data.InitialHero;
import nju.riverxu.ds.model.item.ItemUpgradeInfo;
import nju.riverxu.ds.model.spirit.hero.StatusType;
import nju.riverxu.ds.model.tour.TourId;
import nju.riverxu.ds.view.UpgradePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 移动物品之类的太麻烦了，现在不做了
 */
public class UpgradeController implements MouseListener {

    private Game game = null;
    private UpgradeManager upgradeManager = null;

    public UpgradeController() {
        game = Game.getInstance();
        upgradeManager = game.getStatusManager().getUpgradeManager();
    }

    private Object prevSelected = null;

    public void mouseClicked(MouseEvent e) {
        JList list = (JList) e.getSource();
        Object selected = list.getSelectedValue();


        if (prevSelected == selected) {
            if (selected instanceof StatusType) {
                System.out.println("UpgradeController: upgrading " + selected);
                upgradeManager.upgradeAttr((StatusType) selected);
            } else if (selected instanceof ItemUpgradeInfo) {
                System.out.println("UpgradeController: upgrading " + selected);
                upgradeManager.upgradeItem(((ItemUpgradeInfo) selected).getItem());
            } else if (selected instanceof TourId) {
                System.out.println("UpgradeController: starting tour "+selected);
                game.startTour((TourId) selected);
            } else {
                System.out.println("UpgradeController: received invalid type-" + selected.getClass().getName());
            }
        }
        prevSelected = selected;

        //TODO use logger to give advice?
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
