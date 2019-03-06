package nju.riverxu.ds.view;

import nju.riverxu.ds.controller.HeroController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dim Souls");
        setVisible(true);
        setSize(800,800);
        setLocation(100,100);

        addKeyListener(new HeroController());
    }

}
