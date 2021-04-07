package model;

import controller.Game;
import view.Room;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Dungeon {

    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;

    private Game game;
    private PC pc;
    private List<SolidObject> objects = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();;

    ImageIcon imageIcon = new ImageIcon("src/resources/grass.png");
    Background background = new Background(imageIcon);

    public Dungeon(Game game, PC pc) {
        this.game = game;
        this.pc = pc;
        createRoom1(pc);
        createRoom2(pc);
        createRoom3(pc);
        createRoom4(pc);

        //enemies e oggetti si sommano a ogni metodo, si aggiungono sempre alla stessa lista?
        //ora ho messo clear() ma non cambia nulla
    }

    //room1
    public void createRoom1(PC pc) {
        objects.clear();
        objects.add(new Tree(500, 400));

        enemies.clear();
        enemies.add(new Skeleton(100, 100, 100, 100));
        room1 = new Room(game, background, pc, objects, enemies,
                            null, getRoom2(), getRoom3(), null);
        //se passo getRoom ora è null, perché le stanze oltre la prima non sono state inizializzate
    }

    //room2
    public void createRoom2(PC pc) {
        objects.clear();
        objects.add(new Tree(500, 300));
        objects.add(new Tree(200, 300));

        enemies.clear();
        enemies.add(new Skeleton(100, 100, 100, 100));
        enemies.add(new Skeleton(200, 200, 100, 100));
        room2 = new Room(game, background, pc, objects, enemies,
                            null, null, getRoom4(), getRoom1());
    }

    //room3
    public void createRoom3(PC pc) {
        objects.clear();
        objects.add(new Tree(500, 300));
        objects.add(new Tree(200, 300));
        objects.add(new Tree(500, 100));

        enemies.clear();
        enemies.add(new Skeleton(100, 100, 100, 100));
        enemies.add(new Skeleton(200, 200, 100, 100));
        enemies.add(new Skeleton(300, 300, 100, 100));
        room3 = new Room(game, background, pc, objects, enemies,
                            getRoom1(), getRoom4(), null, null);
    }

    //room4
    public void createRoom4(PC pc) {
        objects.clear();
        objects.add(new Tree(500, 300));
        objects.add(new Tree(200, 300));
        objects.add(new Tree(500, 100));
        objects.add(new Tree(200, 100));

        enemies.clear();
        enemies.add(new Skeleton(100, 100, 100, 100));
        enemies.add(new Skeleton(200, 200, 100, 100));
        enemies.add(new Skeleton(300, 300, 100, 100));
        enemies.add(new Skeleton(400, 400, 100, 100));
        room4 = new Room(game, background, pc, objects, enemies,
                            getRoom2(), null, null, getRoom3());
    }

    public Room getRoom1() {
        return room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public Room getRoom3() {
        return room3;
    }

    public Room getRoom4() {
        return room4;
    }
}
