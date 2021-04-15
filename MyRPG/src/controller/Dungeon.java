package controller;

import model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dungeon {

    private ArrayList<Room> rooms;

    List<SolidObject> objects = new ArrayList<>();
    List<Enemy> enemies = new ArrayList<>();

    ImageIcon imageIcon = new ImageIcon("src/resources/grass.png");
    Background background = new Background(imageIcon);
    Random rand = new Random();

    public Dungeon() {

        rooms = new ArrayList<>();
        createRooms();
    }

    public void createRooms() {

        int nRooms = rand.nextInt(5)+5; //il n di stanze è compreso tra 5 e 9

        int criticalPath = nRooms / 2; //il critical path è il numero di stanze tra quella iniziale e quella finale (comprese)
        if(criticalPath < 3)
            criticalPath = 3;

        int tokenRooms = nRooms - criticalPath;

        //creazione stanze
        for(int i=0; i<nRooms; i++){
            objects = new ArrayList<>();
            enemies = new ArrayList<>();

            int nEnemies = rand.nextInt(6);
            for(int j=0; j<nEnemies; j++)
                enemies.add(new Skeleton(rand.nextInt(700)+50, rand.nextInt(400)+50, 100, 100));
            if(i == criticalPath-1)
                enemies.add(new Boss(350, 200, 1000, 1000));

            rooms.add(new Room(background, objects, enemies));
        }

        //collegamento stanze
        for(int i=0; i<rooms.size()-1; i++){
            int dir = rand.nextInt(4);
            DoorPosition doorPosition = DoorPosition.UP;
            boolean test = true;

            if(i < criticalPath-1) {
            while(test){
                switch (dir) {
                    case 0:
                    default:
                        doorPosition = DoorPosition.UP;
                        if (rooms.get(i).getDoorUp() == null)
                            test = false;
                        else
                            dir = rand.nextInt(4);
                        break;
                    case 1:
                        doorPosition = DoorPosition.RIGHT;
                        if (rooms.get(i).getDoorRight() == null)
                            test = false;
                        else
                            dir = rand.nextInt(4);
                        break;
                    case 2:
                        doorPosition = DoorPosition.DOWN;
                        if (rooms.get(i).getDoorDown() == null)
                            test = false;
                        else
                            dir = rand.nextInt(4);
                        break;
                    case 3:
                        doorPosition = DoorPosition.LEFT;
                        if (rooms.get(i).getDoorLeft() == null)
                            test = false;
                        else
                            dir = rand.nextInt(4);
                        break;
                }
            }

                //crea porta per la prossima stanza
                //se si tratta della stanza finale non crea potre
                    rooms.get(i).initDoor(rooms.get(i + 1), doorPosition);

                    //crea porta nella prossima stanza per la stanza corrente
                    switch (dir) {
                        case 0:
                        default:
                            doorPosition = DoorPosition.DOWN;
                            break;
                        case 1:
                            doorPosition = DoorPosition.LEFT;
                            break;
                        case 2:
                            doorPosition = DoorPosition.UP;
                            break;
                        case 3:
                            doorPosition = DoorPosition.RIGHT;
                            break;
                    }
                    rooms.get(i + 1).initDoor(rooms.get(i), doorPosition);
                }

                if(i > criticalPath-1) {
                    boolean test2 = true;
                    int connectingRoom = -1;

                    while(test2) {
                        connectingRoom = rand.nextInt(rooms.size());
                        if (connectingRoom != criticalPath - 1) //non collega ulteriori stanze alla stanza finale
                            test2 = false;
                    }

                        test = true;
                        dir = rand.nextInt(4);
                        while(test){
                            switch (dir) {
                                case 0:
                                default:
                                    doorPosition = DoorPosition.UP;
                                    if (rooms.get(i).getDoorUp() == null && rooms.get(connectingRoom).getDoorDown() == null)
                                        test = false;
                                    else
                                        dir = rand.nextInt(4);
                                    break;
                                case 1:
                                    doorPosition = DoorPosition.RIGHT;
                                    if (rooms.get(i).getDoorRight() == null && rooms.get(connectingRoom).getDoorLeft() == null)
                                        test = false;
                                    else
                                        dir = rand.nextInt(4);
                                    break;
                                case 2:
                                    doorPosition = DoorPosition.DOWN;
                                    if (rooms.get(i).getDoorDown() == null && rooms.get(connectingRoom).getDoorUp() == null)
                                        test = false;
                                    else
                                        dir = rand.nextInt(4);
                                    break;
                                case 3:
                                    doorPosition = DoorPosition.LEFT;
                                    if (rooms.get(i).getDoorLeft() == null && rooms.get(connectingRoom).getDoorRight() == null)
                                        test = false;
                                    else
                                        dir = rand.nextInt(4);
                                    break;
                            }
                        }
                        rooms.get(i).initDoor(rooms.get(connectingRoom), doorPosition);

                        //crea porta nella prossima stanza per la stanza corrente
                        switch (dir) {
                            case 0:
                            default:
                                doorPosition = DoorPosition.DOWN;
                                break;
                            case 1:
                                doorPosition = DoorPosition.LEFT;
                                break;
                            case 2:
                                doorPosition = DoorPosition.UP;
                                break;
                            case 3:
                                doorPosition = DoorPosition.RIGHT;
                                break;
                        }
                        rooms.get(connectingRoom).initDoor(rooms.get(i), doorPosition);

                }
        }

        /*
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

        //load rooms
        Room room0 = rooms.get(0);
        Room room1 = rooms.get(1);
        Room room2 = rooms.get(2);
        Room room3 = rooms.get(3);

        //doors
        room0.initDoor(room1, DoorPosition.RIGHT);
        room0.initDoor(room2, DoorPosition.DOWN);

        room1.initDoor(room0, DoorPosition.LEFT);
        room1.initDoor(room3, DoorPosition.DOWN);

        room2.initDoor(room0, DoorPosition.UP);
        room2.initDoor(room3, DoorPosition.RIGHT);

        room3.initDoor(room1, DoorPosition.UP);
        room3.initDoor(room2, DoorPosition.LEFT);
         */
    }

    public Room getRoom(int index) {
        return rooms.get(index);
    }
}
