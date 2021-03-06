package nju.riverxu.ds.view;

import nju.riverxu.ds.controller.UpgradeController;
import nju.riverxu.ds.model.Game;
import nju.riverxu.ds.model.GameState;
import nju.riverxu.ds.model.StatusManager;
import nju.riverxu.ds.model.UpgradeManager;
import nju.riverxu.ds.model.spirit.hero.UpgradeInfo;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UpgradePanel extends JPanel implements Observer {
    // 人物信息panel与log panel
    // 可升级属性
    // 可升级武器、护甲
    // 已经解锁的下一次Tour列表（开始冒险）
    private Game game = null;

    private StatusManager statusManager = null;
    private UpgradeManager upgradeManager = null;
    private UpgradeController controller = null;

    private JLabel hintLabel = null;

    private JList attrUpgradeList = null;
    private JList itemUpgradeList = null;

    private JTextArea statusText = null;


    public UpgradePanel() {
        add(new JLabel("UPGRADE"));

        game = Game.getInstance();
        assert game.getGameState() == GameState.UPGRADE;

        statusManager = game.getStatusManager();
        upgradeManager = statusManager.getUpgradeManager();
        upgradeManager.addObserver(this);

        controller = new UpgradeController();


        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(0, 0));

        hintLabel = new JLabel("请选择欲升级的项目：（再次点击条目或单击列表空白处以确认）");
        add(hintLabel, BorderLayout.NORTH);

        //UpgradeInfo upgradeInfo = upgradeManager.getUpgradeInfo();

        JScrollPane attrScrollPane = new JScrollPane();
        add(attrScrollPane, BorderLayout.WEST);
        attrScrollPane.setMinimumSize(new Dimension(50, 100));
        attrUpgradeList = new JList();
        attrScrollPane.setViewportView(attrUpgradeList);
        //attrUpgradeList.setListData(upgradeInfo.getUpgradableStatus());
        attrUpgradeList.addMouseListener(controller);

        JScrollPane itemScrollPane = new JScrollPane();
        add(itemScrollPane, BorderLayout.EAST);
        itemScrollPane.setMinimumSize(new Dimension(100, 100));
        itemUpgradeList = new JList();
        itemScrollPane.setViewportView(itemUpgradeList);
        //itemUpgradeList.setListData(upgradeInfo.getItemUpgradeInfos());
        itemUpgradeList.addMouseListener(controller);

//        JPanel logPanel = new LogPanel();
//        add(logPanel,BorderLayout.EAST);


        statusText = new JTextArea("当前英雄状态为：" + upgradeManager.getHeroStatus());
        statusText.setLineWrap(true);
        add(statusText, BorderLayout.CENTER);

        refreshContent();


    }

    private void prepareForTour() {
        hintLabel.setText("请选择欲升级的项目或选择下一场冒险：（再次点击条目或单击列表空白处以确认）");
    }

    public void refreshContent() {
        UpgradeInfo upgradeInfo = upgradeManager.getUpgradeInfo();

        if (upgradeInfo.getUpgradableStatus().length > 0) {
            attrUpgradeList.setListData(upgradeInfo.getUpgradableStatus());
        } else {
            attrUpgradeList.setListData(statusManager.getUnlockedTourIds());
            prepareForTour();
        }

        if (upgradeInfo.getItemUpgradeInfos().length > 0) {
            itemUpgradeList.setListData(upgradeInfo.getItemUpgradeInfos());
        } else {
            itemUpgradeList.setListData(statusManager.getUnlockedTourIds());
            prepareForTour();
        }


        statusText.setText("当前英雄状态为：" + upgradeManager.getHeroStatus());
    }

    public void notifyEvent(EventType eventType, Object event) {
        if (eventType == EventType.UPGRADE_SUCCESS) {
            refreshContent();
        }
    }
}
