package nju.riverxu.ds.view;

import nju.riverxu.ds.model.spirit.hero.Hero;
import nju.riverxu.ds.model.spirit.mob.Mob;
import nju.riverxu.ds.model.tour.Dungeon;
import nju.riverxu.ds.model.tour.Location;
import nju.riverxu.ds.model.tour.map.DungeonMapSize;
import nju.riverxu.ds.model.tour.map.Exit;
import nju.riverxu.ds.model.tour.map.MapElement;
import nju.riverxu.ds.model.tour.map.Wall;
import nju.riverxu.ds.util.EventType;
import nju.riverxu.ds.util.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class DungeonPanel extends JPanel implements Observer {
    private Dungeon dungeon = null;

    public DungeonPanel(Dungeon dungeon) {
        this.dungeon = dungeon;
        dungeon.addObserver(this);
        System.out.println("DungeonPanel: inited with "+dungeon);

        DungeonMapSize size = dungeon.getMap().getSize();
        setSize(size.getX(),size.getX());
        setLayout(null);

        initStaticElements();
        initDynamicElements();

        setVisible(true);
    }

    private void initStaticElements(){
        Iterator<MapElement> staticElementsIter = dungeon.getMap().getStaticElementsIter();
        DungeonMapSize maxSize = dungeon.getMap().getSize();
        while (staticElementsIter.hasNext()) {
            MapElement next = staticElementsIter.next();
            if(next instanceof Wall) {
                Wall w = (Wall) next;
                WallComponent wc = new WallComponent(w.getPt1(),w.getPt2());
                wc.setSize(maxSize.getX(),maxSize.getY()); // 糟糕的实践，但是易于使用
                add(wc);
            } else if(next instanceof Exit) {
                Exit e = (Exit) next;
                ExitComponent ec = new ExitComponent(e);
                ec.setSize(maxSize.getX(),maxSize.getY()); // 同上
                add(ec);
            }
        }
    }

    private HeroComponent heroComponent;
    private MobComponent[] mobComponents;

    private void initDynamicElements() {
        DungeonMapSize maxSize = dungeon.getMap().getSize();

        heroComponent = new HeroComponent(dungeon.getHero());
        heroComponent.setSize(maxSize.getX(),maxSize.getY());
        heroComponent.refresh(dungeon.getHeroLocation());
        add(heroComponent);

        Set<Mob> mobs = dungeon.getMobs();
        mobComponents = new MobComponent[mobs.size()];
        int ptr = 0;
        for (Mob mob : mobs) {
            MobComponent mobComponent = new MobComponent(mob);
            mobComponent.setSize(maxSize.getX(),maxSize.getY());
            mobComponent.refresh(dungeon.getMobLocation(mob));

            mobComponents[ptr] = mobComponent;
            ptr += 1;

            add(mobComponent);
        }
    }

    private void resetDynamicElements() {
        if(heroComponent!=null) {
            heroComponent.refresh(dungeon.getHeroLocation());
            for (MobComponent mobComponent : mobComponents) {
                mobComponent.refresh(dungeon.getMobLocation(mobComponent.getMob()));
            }
        }

    }


    public void notifyEvent(EventType eventType, Object event) {
        switch (eventType) {
            case DUNGEON_UI_REFRESH:
                resetDynamicElements();
                repaint(0,0,600,600);
                break;
            default:
                break;
        }
    }

    public void deactivate() {
        dungeon.removeObserver(this); // Will not refresh anymore.
    }


    class WallComponent extends JLabel {
        public WallComponent(Location from, Location to) {
            super();
            setLocation(0,0);
            x1 = (int) from.getX();
            y1 = (int) from.getY();
            x2 = (int) to.getX();
            y2 = (int) to.getY();
        }
        private int x1,y1,x2,y2;

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.BLACK);
            g.drawLine(x1,y1,x2,y2);
        }
    }

    class ExitComponent extends JLabel {
        public ExitComponent(Exit e) {
            super();
            width = 10;
            x1 = (int) e.getLocation().getX();
            y1 = (int) e.getLocation().getY();

            x1 -= width / 2;
            y1 -= width / 2;

        }
        private int x1,y1;
        private int width;

        @Override
        public void paintComponent(Graphics g) {
            g.fillRect(x1,y1,width,width);
        }
    }

    class HeroComponent extends JLabel {

        private Hero hero;
        private char[] blocking = {'B'};
        private int centerX, centerY;
        private int radius, diameter;
        public HeroComponent(Hero hero) {
            this.hero = hero;
            radius = (int)hero.getRadius();
            diameter = radius+radius;
            setVisible(true);
        }

        public void refresh(Location location) {
            centerX = (int) location.getX();
            centerY = (int) location.getY();
        }

        @Override
        public void paintComponent(Graphics g) {
            int radius = (int) hero.getRadius();
            int diameter = radius+radius;
            g.fillOval(centerX-radius,centerY-radius, diameter,diameter);
            if(hero.isLeftHandBlocking()) {
                g.drawChars(blocking,0,1,centerX,centerY-diameter);
            }
        }
    }

    class MobComponent extends JLabel {
        private Mob mob;
        private int x,y;
        private int radius, diameter;
        public MobComponent(Mob mob) {
            this.mob = mob;
            radius = (int)mob.getRadius();
            diameter = radius+radius;
        }

        public void refresh(Location location) {
            x = (int) location.getX();
            y = (int) location.getY();
        }

        @Override
        protected void paintComponent(Graphics g) {
            if(mob.isActive()) {
                g.fillOval(x-radius,y-radius,diameter,diameter);
            }
        }

        public Mob getMob() {return mob;}

    }

}
