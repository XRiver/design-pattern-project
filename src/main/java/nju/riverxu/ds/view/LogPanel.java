package nju.riverxu.ds.view;

import javax.swing.*;

class LogPanel extends JPanel {
    private JLabel area;
    public LogPanel() {
        area = new JLabel();
        area.setText("本来想要做一个监听战斗日志与升级日志的Panel来提示玩家，" +
                "不过由于只有我自己会用这个系统，所以就不做了，改在stdout打印一点信息。");
        add(area);
    }
}
