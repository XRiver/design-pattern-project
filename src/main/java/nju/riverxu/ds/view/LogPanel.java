package nju.riverxu.ds.view;

import javax.swing.*;

class LogPanel extends JPanel {
    public JTextArea area;
    public LogPanel() {
        area = new JTextArea();
        area.setLineWrap(true);
        area.setRows(2);
        add(area);
    }
}
