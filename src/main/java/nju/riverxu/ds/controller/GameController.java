package nju.riverxu.ds.controller;

import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.view.MainFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GameController implements ListSelectionListener {

    private Game game = null;

    public GameController() {
        game = Game.getInstance();
    }

    public String[] getAvailableOptions() {
        if (game.canContinueFromSave()) {
            return new String[]{
                    "继续游戏",
                    "开始新游戏",
                    "查看说明",
                    "退出"
            };
        } else {
            return new String[]{
                    "开始新游戏",
                    "查看说明",
                    "退出"
            };
        }
    }

    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) {
            // This is bad. But how to use ListSelectionEvent?
            JList list = (JList) e.getSource();
            String selected = (String) list.getSelectedValue();

            if("继续游戏".equals(selected)) {
                System.out.println("GameController: Starting old game.");
                game.startGame(true);
            } else if ("开始新游戏".equals(selected)) {
                System.out.println("GameController: Starting new game");
                game.startGame(false);
            } else if ("查看说明".equals(selected)) {
                System.out.println("GameController: Show tutorial--Not implemented yet");
            } else if ("退出".equals(selected)) {
                System.out.println("GameController: Exiting");
                System.exit(0);
            }
        }
    }
}
