package nju.riverxu.ds.view;

import nju.riverxu.ds.controller.GameController;
import nju.riverxu.ds.model.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameInitPanel extends JPanel {

    private Game game = null;
    private GameController controller = null;

    private JList options = null;

    public GameInitPanel() {
        game = Game.getInstance();
        controller = game.getGameController();

        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(0, 0));

        JLabel label = new JLabel("Dim Souls");
        add(label, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
        options = new JList();
        scrollPane.setViewportView(options);
        options.setListData(controller.getAvailableOptions());
        options.addListSelectionListener(controller);

        setVisible(true);
    }


}
