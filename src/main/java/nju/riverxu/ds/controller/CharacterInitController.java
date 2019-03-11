package nju.riverxu.ds.controller;

import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.data.InitialHero;
import nju.riverxu.ds.view.CharacterInitPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CharacterInitController implements ListSelectionListener {

    private Game game = null;

    public CharacterInitController() {
        game = Game.getInstance();
    }

    public InitialHero[] getAvailableOptions() {
        return null;//TODO
    }

    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) {
            // This is bad. But how to use ListSelectionEvent?
            JList list = (JList) e.getSource();
            String selected = (String) list.getSelectedValue();


        }
    }
}
