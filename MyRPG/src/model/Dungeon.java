package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Dungeon {

    private ArrayList<Room> rooms;

    ImageIcon imageIcon = new ImageIcon("src/resources/grass.png");
    Background background = new Background(imageIcon);

    public Dungeon() {

        rooms = new ArrayList<>();
        createRooms();
    }

    public void createRooms() {

        // ROOM 0
        List<SolidObject> objects = new ArrayList<>();
        List<Enemy> enemies = new ArrayList<>();

        rooms.add(new Room(background, objects, enemies));


        // ROOM 1
        objects = new ArrayList<>();
        enemies = new ArrayList<>();

        objects.add(new Tree(500, 300));
        enemies.add(new Skeleton(200, 200, 100, 100));
        rooms.add(new Room(background, objects, enemies));


        // ROOM 2
        objects = new ArrayList<>();
        enemies = new ArrayList<>();


        objects.add(new Tree(200, 300));
        objects.add(new Tree(500, 100));

        enemies.add(new Skeleton(200, 200, 100, 100));
        enemies.add(new Skeleton(300, 300, 100, 100));
        rooms.add(new Room(background, objects, enemies));


        // ROOM 3
        objects = new ArrayList<>();
        enemies = new ArrayList<>();

        objects.add(new Tree(200, 300));
        objects.add(new Tree(500, 100));
        objects.add(new Tree(200, 100));

        enemies.add(new Skeleton(200, 200, 100, 100));
        enemies.add(new Skeleton(300, 300, 100, 100));
        enemies.add(new Skeleton(400, 400, 100, 100));
        rooms.add(new Room(background, objects, enemies));


        Room room0 = rooms.get(0);
        Room room1 = rooms.get(1);
        Room room2 = rooms.get(2);
        Room room3 = rooms.get(3);

        room0.initDoor(room1, DoorPosition.RIGHT);
        room0.initDoor(room2, DoorPosition.DOWN);

        room1.initDoor(room0, DoorPosition.LEFT);
        room1.initDoor(room3, DoorPosition.DOWN);

        room2.initDoor(room0, DoorPosition.UP);
        room2.initDoor(room3, DoorPosition.RIGHT);

        room3.initDoor(room1, DoorPosition.UP);
        room3.initDoor(room2, DoorPosition.LEFT);
    }

    public Room getRoom(int index) {
        return rooms.get(index);
    }
}
