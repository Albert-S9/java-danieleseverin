package controller;

import model.*;
import view.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame implements ActionListener {

    private Room room1;
    private PC pc;
    private List<SolidObject> objects = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();

    private static final int width = 800;
    private static final int height = 500;

    private Timer timer;
    private final int DELAY = 10;

    public Game(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("My RPG");
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(true);

        //creo prima stanza
        //creo background
        ImageIcon imageIcon = new ImageIcon("src/resources/grass.png");
        Background background = new Background(imageIcon);

        //creo pc
        pc = new PC(5, 5, "down", 100, 100);

        //creo lista di oggetti
        objects.add(new Tree(100,100));
        objects.add(new Tree(300,300));

        //creo lista di nemici
        enemies.add(new Skeleton(200,200, 100, 100));
        enemies.add(new Skeleton(400,200, 100, 100));

        //inizializzo la stanza
        room1 = new Room(this, background, pc, objects, enemies);
        add(room1);

        setVisible(true);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            teleport();
        }

        if (key == KeyEvent.VK_Z) {
            pc.fire();
        }

        if (key == KeyEvent.VK_X) {
            pc.attack();
            pc.setAttacking(true);
        }

        if (key == KeyEvent.VK_LEFT) {
            pc.setDx(-2);
            pc.setDy(0);
            pc.setDirection("left");
            pc.loadImage();
        }

        if (key == KeyEvent.VK_RIGHT) {
            pc.setDx(2);
            pc.setDy(0);
            pc.setDirection("right");
            pc.loadImage();
        }

        if (key == KeyEvent.VK_UP) {
            pc.setDy(-2);
            pc.setDx(0);
            pc.setDirection("up");
            pc.loadImage();
        }

        if (key == KeyEvent.VK_DOWN) {
            pc.setDy(2);
            pc.setDx(0);
            pc.setDirection("down");
            pc.loadImage();
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_X) {
            pc.setAttacking(false);
            pc.setSword(null);
        }

        if (key == KeyEvent.VK_LEFT) {
            pc.setDx(0);
        }

        if (key == KeyEvent.VK_RIGHT) {
            pc.setDx(0);
        }

        if (key == KeyEvent.VK_UP) {
            pc.setDy(0);
        }

        if (key == KeyEvent.VK_DOWN) {
            pc.setDy(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameCycle();
    }

    private void gameCycle(){
        move();
        updateDamageEffect();
        checkCollisions();
        repaint();
        updateSpells();
    }

    private void move(){
        pc.move();

        for (Enemy enemy : enemies) {
            enemy.move(pc);
        }
    }

    private void updateDamageEffect(){
        if(pc.getDamageEffect() != null)
            pc.setDamageEffectNotVisible();

        for (Enemy enemy : enemies) {
            if(enemy.getDamageEffect() != null)
                enemy.setDamageEffectNotVisible();
        }
    }

    private void checkCollisions(){
        collisionsPcObjects();
        collisionsEnemiesObjects();
        collisionsPCEnemies();
        collisionsSpellEnemies();
        collisionSwordEnemies();
    }

    private void collisionsPcObjects(){ //se pc interseca con oggetto inanimato
        Rectangle r1 = pc.getBounds();

        for(SolidObject obj : objects) {
            Rectangle r2 = obj.getBounds();

            if(r1.intersects(r2)){
                blockPcMovement();
            }
        }
    }

    private void collisionsEnemiesObjects(){ //se nemico interseca con oggetto inanimato
        for(Enemy enemy : enemies) {
            Rectangle r1 = enemy.getBounds();

            for (SolidObject obj : objects) {
                Rectangle r2 = obj.getBounds();

                if (r2.intersects(r1)) {
                    blockEnemyMovement(enemy);
                }
            }
        }
    }

    private void collisionsPCEnemies(){ //se pc interseca con nemico
        Rectangle r1 = pc.getBounds();

        for(Enemy enemy : enemies) {
            Rectangle r3 = enemy.getBounds();

            if(r1.intersects(r3)){
                blockPcMovement();
                blockEnemyMovement(enemy);
                pc.getDamaged(enemy);
            }
        }
    }

    private void collisionsSpellEnemies(){ //se nemico interseca con spell
        List<Spell> sp = pc.getSpells();
        for(Enemy enemy : enemies) {
            Rectangle r3 = enemy.getBounds();

            for (Spell spell : sp) {
                Rectangle r4 = spell.getBounds();

                if (r4.intersects(r3)) {
                    blockEnemyMovement(enemy);
                    spell.setVisible(false);
                    enemy.getDamaged(pc);
                }
            }
        }
    }

    private void collisionSwordEnemies() { //se nemico interseca con sword
        if (pc.getSword() != null) {
            Sword sword = pc.getSword();
            Rectangle r1 = sword.getBounds();
            for (Enemy enemy : enemies) {
                Rectangle r2 = enemy.getBounds();
                if (r1.intersects(r2)) {
                    blockEnemyMovement(enemy);
                    enemy.getDamaged(pc);
                }
            }
        }
    }

    private void blockPcMovement(){
        if(pc.getDx()>0) {pc.setX((pc.getX())-2); }
        if(pc.getDx()<0) {pc.setX((pc.getX())+2); }
        if(pc.getDy()>0) {pc.setY((pc.getY())-2); }
        if(pc.getDy()<0) {pc.setY((pc.getY())+2); }
    }

    private void blockEnemyMovement(Enemy enemy){

            if (enemy.getDx() > 0) {
                enemy.setX((enemy.getX()) - 2);
            }
            if (enemy.getDx() < 0) {
                enemy.setX((enemy.getX()) + 2);
            }
            if (enemy.getDy() > 0) {
                enemy.setY((enemy.getY()) - 2);
            }
            if (enemy.getDy() < 0) {
                enemy.setY((enemy.getY()) + 2);
            }
            circumnavigaOstacolo();
    }

    //to do
    public void circumnavigaOstacolo(){}

    private void updateSpells() {

        List<Spell> sp = pc.getSpells();

        for (int i = 0; i < sp.size(); i++) {

            Spell s = sp.get(i);

            if (s.isVisible()) {
                s.move();
            } else {
                sp.remove(i);
            }
        }
    }

    private void teleport(){
        //creo seconda stanza
        //creo background
        ImageIcon imageIcon = new ImageIcon("src/resources/ground.png");
        Background background = new Background(imageIcon);

        //creo pc
        pc = new PC(5, 5, "down", 100, 100);

        //creo lista di oggetti
        //objects.add(new Tree(100,100));
        objects.add(new Tree(350,350));

        //creo lista di nemici
        //enemies.add(new Skeleton(200,200, 100, 100));
        enemies.add(new Skeleton(200,200, 100, 100));

        //inizializzo la stanza
        Room room2 = new Room(this, background, pc, objects, enemies);
        add(room2);
        room1.setVisible(false);

        setVisible(true);
    }

    public static void main(String[] args) {

        Game game = new Game();
    }
}
