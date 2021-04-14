package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dungeon {

    private ArrayList<Room> rooms;

    ImageIcon imageIcon = new ImageIcon("src/resources/grass.png");
    Background background = new Background(imageIcon);
    Random rand = new Random();

    public Dungeon() {

        rooms = new ArrayList<>();
        createRooms();
    }

    public void createRooms() {

        int nRooms = rand.nextInt(5)+5;
        int token_doors = nRooms;

        List<SolidObject> objects = new ArrayList<>();
        List<Enemy> enemies = new ArrayList<>();

        for (int i=0; i<nRooms; i++) {

            //aggiungi nemici
            int nEnemy = rand.nextInt(6);
            for(int j=0; j<nEnemy; j++){
                enemies.add(new Skeleton(rand.nextInt(700)+50, rand.nextInt(400)+50, 100, 100));
            }

            int nDoors = rand.nextInt(2) + 1;
            if (token_doors >= nDoors)
                token_doors -= nDoors;
            else
                nDoors = token_doors;

            rooms.add(new Room(background, objects, enemies, nDoors));
        }

        //genera i collegamenti tra le stanze
        for (int i=0; i<nRooms; i++){

            //controlla se una stanza si collega alla stanza corrente
            //se si, crea una porta nella direzione opposta

            for (int j=0; j<nRooms; j++){
               if(rooms.get(j).getDoorUp().getNextRoom() == rooms.get(i)){
                   rooms.get(i).initDoor(rooms.get(j).getDoorUp().getNextRoom(), DoorPosition.DOWN);
               }
                if(rooms.get(j).getDoorRight().getNextRoom() == rooms.get(i)){
                    rooms.get(i).initDoor(rooms.get(j).getDoorRight().getNextRoom(), DoorPosition.LEFT);
                }
                if(rooms.get(j).getDoorDown().getNextRoom() == rooms.get(i)){
                    rooms.get(i).initDoor(rooms.get(j).getDoorDown().getNextRoom(), DoorPosition.UP);
                }
                if(rooms.get(j).getDoorLeft().getNextRoom() == rooms.get(i)){
                    rooms.get(i).initDoor(rooms.get(j).getDoorLeft().getNextRoom(), DoorPosition.RIGHT);
                }
            }

            //cicla per nDoors volte creando ogni volta una porta in una direzione casuale
            //controlla se nella direzione generata casualmente esiste già una porta
            //se si, ripeti la generazione
            for (int j=0; j<rooms.get(j).getDoors(); j++){
                int dir = rand.nextInt(4);

                if(dir==0){
                    if(rooms.get(i).getDoorUp() == null)
                        rooms.get(i).initDoor(rooms.get(i+j+1), DoorPosition.UP);
                    else
                        dir += 1; //oppure richiama ricorsivamente questo metodo (da creare)
                                    // però così resetta il contatore
                }
                if(dir==1){
                    if(rooms.get(i).getDoorRight() == null)
                        rooms.get(i).initDoor(rooms.get(i+j+1), DoorPosition.RIGHT);
                    else
                        dir += 1;
                }
                if(dir==2){
                    if(rooms.get(i).getDoorDown() == null)
                        rooms.get(i).initDoor(rooms.get(i+j+1), DoorPosition.DOWN);
                    else
                        dir += 1;
                }
                if(dir==3){
                    if(rooms.get(i).getDoorLeft() == null)
                        rooms.get(i).initDoor(rooms.get(i+j+1), DoorPosition.LEFT);
                    else
                        dir += 1;
                }
            }


            //room0.initDoor(room1, DoorPosition.RIGHT);
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
