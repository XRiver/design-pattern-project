package nju.riverxu.ds.view;

import nju.riverxu.ds.controller.CharacterInitController;
import nju.riverxu.ds.controller.GameController;
import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.data.CharacterInitializeManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CharacterInitPanel extends JPanel {

    private Game game = null;

    private JLabel hintLabel = null;
    private JLabel descriptionLabel = null;
    private JList optionsList = null;


    public CharacterInitPanel() {
        game = Game.getInstance();

        CharacterInitializeManager initializeManager = game.getManagerFactory().makeCharacterInitializeManager();

        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(0, 0));

        hintLabel = new JLabel("请选择创建的角色种类：（再次点击条目或单击列表空白处以确认）");
        add(hintLabel, BorderLayout.NORTH);

        CharacterInitController controller = new CharacterInitController(this);

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
        optionsList = new JList();
        scrollPane.setViewportView(optionsList);
        optionsList.setListData(controller.getAvailableOptions());
        optionsList.addMouseListener(controller);

        descriptionLabel = new JLabel("选择一种角色以确认其特性。");
        add(descriptionLabel, BorderLayout.SOUTH);

    }

    public void setDescriptionLabel(String text) {
        descriptionLabel.setText(text);
    }
}
