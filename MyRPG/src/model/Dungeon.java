package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Dungeon {

    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;

    private List<SolidObject> objects;
    private List<Enemy> enemies;

    ImageIcon imageIcon = new ImageIcon("src/resources/grass.png");
    Background background = new Background(imageIcon);

    public Dungeon() {
        createRoom1();
        createRoom2();
        createRoom3();
        createRoom4();

        createRoom1();
        createRoom2();
        createRoom3();
        createRoom4();

        createRoom1();
        createRoom2();
        createRoom3();
        createRoom4();

        createRoom1();
        createRoom2();
        createRoom3();
        createRoom4();
    }

    private void resetlists(){
        objects = new ArrayList<>();
        enemies = new ArrayList<>();
    }

    //room1
    public void createRoom1() {

        resetlists();

        objects.add(new Tree(500, 300));

        enemies.add(new Skeleton(100, 100, 100, 100));
        room1 = new Room(background, objects, enemies,
                            null, room2, room3, null);
        //se passo getRoom ora è null, perché le stanze oltre la prima non sono state inizializzate
    }

    //room2
    public void createRoom2() {

        resetlists();

        objects.add(new Tree(500, 300));
        objects.add(new Tree(200, 300));

        enemies.add(new Skeleton(100, 100, 100, 100));
        enemies.add(new Skeleton(200, 200, 100, 100));
        room2 = new Room(background, objects, enemies,
                            null, null, room4, room1);
    }

    //room3
    public void createRoom3() {

        resetlists();

        objects.add(new Tree(500, 300));
        objects.add(new Tree(200, 300));
        objects.add(new Tree(500, 100));

        enemies.add(new Skeleton(100, 100, 100, 100));
        enemies.add(new Skeleton(200, 200, 100, 100));
        enemies.add(new Skeleton(300, 300, 100, 100));
        room3 = new Room(background, objects, enemies,
                            room1, room4, null, null);
    }

    //room4
    public void createRoom4() {

        resetlists();

        objects.add(new Tree(500, 300));
        objects.add(new Tree(200, 300));
        objects.add(new Tree(500, 100));
        objects.add(new Tree(200, 100));

        enemies.add(new Skeleton(100, 100, 100, 100));
        enemies.add(new Skeleton(200, 200, 100, 100));
        enemies.add(new Skeleton(300, 300, 100, 100));
        enemies.add(new Skeleton(400, 400, 100, 100));
        room4 = new Room(background, objects, enemies,
                            room2, null, null, room3);
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
