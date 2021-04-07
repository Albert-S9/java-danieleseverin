package view;

import controller.Game;
import model.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.List;

public class Room extends JPanel{

    private Game game;
    private Background background;
    private PC pc;
    private List<SolidObject> objects;
    private List<Enemy> enemies;

    private Door doorUp;
    private Door doorDown;
    private Door doorLeft;
    private Door doorRight;

    public Room(Game game, Background background, PC pc, List<SolidObject> objects, List<Enemy> enemies,
                Room roomUp, Room roomDown, Room roomLeft, Room roomRight) {
        this.game = game;
        this.background = background;
        this.pc = pc;
        this.objects = objects;
        System.out.println("Elementi objects: " + objects.size());
        this.enemies = enemies;
        System.out.println("Elementi enemies: " + enemies.size());

        initDoors(roomUp, roomDown, roomLeft, roomRight);

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
    }

    private void initDoors(Room roomUp, Room roomDown, Room roomLeft, Room roomRight){
        if(roomUp != null){
            doorUp = new Door(400, 0, "up", roomUp);
        }
        if(roomDown != null){
            doorDown = new Door(400, 0, "down", roomDown);
        }
        if(roomLeft != null){
            doorLeft = new Door(400, 0, "left", roomLeft);
        }
        if(roomRight != null){
            doorRight = new Door(400, 0, "right", roomRight);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        drawBackground(g);
        drawDoors(g);
        drawPC(g);
        drawEnemies(g);
        drawDamageEffect(g);
        drawObjects(g);
        drawSpells(g);
        drawSword(g);

        g.drawString("HP:  " + pc.getHp(), 300, 15);
    }

    private void drawBackground(Graphics g) {
        g.drawImage(background.getImage(), background.getX(), background.getY(), this);
    }

    private void drawDoors(Graphics g) {
        if(doorUp != null){
            g.drawImage(doorUp.getImage(), doorUp.getX(), doorUp.getY(), this);
        }
        if(doorDown != null){
            g.drawImage(doorDown.getImage(), doorDown.getX(), doorDown.getY(), this);
        }
        if(doorLeft != null){
            g.drawImage(doorLeft.getImage(), doorLeft.getX(), doorLeft.getY(), this);
        }
        if(doorRight != null){
            g.drawImage(doorRight.getImage(), doorRight.getX(), doorRight.getY(), this);
        }
    }

    private void drawPC(Graphics g){
        g.drawImage(pc.getImage(), pc.getX(), pc.getY(), this);
    }

    private void drawObjects(Graphics g){
        for (SolidObject obj : objects){
            g.drawImage(obj.getImage(), obj.getX(), obj.getY(), this);
        }
    }

    private void drawEnemies(Graphics g){
        for (Enemy obj : enemies){
            g.drawImage(obj.getImage(), obj.getX(), obj.getY(), this);
        }
    }

    private void drawDamageEffect(Graphics g){
        DamageEffect de = pc.getDamageEffect();
        if (de != null && de.isVisible())
            g.drawImage(de.getImage(), de.getX(), de.getY(), this);

        for (Enemy enemy : enemies) {
            DamageEffect da = enemy.getDamageEffect();
            if (da != null && da.isVisible())
                g.drawImage(da.getImage(), da.getX(), da.getY(), this);
        }
    }

    private void drawSpells(Graphics g){
        List<Spell> sp = pc.getSpells();
        for (Spell spell : sp) {
            if (spell.isVisible()) {
                g.drawImage(spell.getImage(), spell.getX(),
                        spell.getY(), this);
            }
        }
    }

    private void drawSword(Graphics g){
        Sword sword = pc.getSword();
        if (pc.isAttacking())
            g.drawImage(sword.getImage(), sword.getX(),
                    sword.getY(), this);
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            game.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            game.keyPressed(e);
        }
    }
}
