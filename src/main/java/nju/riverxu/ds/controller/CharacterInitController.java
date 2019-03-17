package nju.riverxu.ds.controller;

import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.data.CharacterInitializeManager;
import nju.riverxu.ds.model.data.InitialHero;
import nju.riverxu.ds.view.CharacterInitPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CharacterInitController implements MouseListener {

    private Game game = null;
    private CharacterInitializeManager manager = null;

    private CharacterInitPanel panel = null;

    public CharacterInitController(CharacterInitPanel panel) {
        game = Game.getInstance();
        manager = game.getManagerFactory().makeCharacterInitializeManager();
        this.panel = panel;
    }

    public InitialHero[] getAvailableOptions() {
        return manager.getTypes();
    }



    private InitialHero prevSelected = null;

    public void mouseClicked(MouseEvent e) {
        JList list = (JList) e.getSource();
        InitialHero selected = (InitialHero) list.getSelectedValue();

        if(prevSelected == selected) {
            System.out.println("CharacterInitController: Double click on "+prevSelected);
            manager.useType(selected);
            game.startGame(true);
        }
        prevSelected = selected;
        panel.setDescriptionLabel(selected.getDescription());
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
