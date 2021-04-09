package model;

import java.util.List;

public class Room {

    private Background background;
    private List<SolidObject> objects;
    private List<Enemy> enemies;

    private Door doorUp;
    private Door doorDown;
    private Door doorLeft;
    private Door doorRight;

    public Room(Background background, List<SolidObject> objects, List<Enemy> enemies,
                Room roomUp, Room roomDown, Room roomLeft, Room roomRight) {

        this.background = background;
        this.objects = objects;
        this.enemies = enemies;

        initDoors(roomUp, roomDown, roomLeft, roomRight);
    }

    private void initDoors(Room roomUp, Room roomDown, Room roomLeft, Room roomRight) {
        if (roomUp != null) {
            doorUp = new Door(400, 20, "up", roomUp);
        }
        if (roomDown != null) {
            doorDown = new Door(400, 450, "down", roomDown);
        }
        if (roomLeft != null) {
            doorLeft = new Door(20, 250, "left", roomLeft);
        }
        if (roomRight != null) {
            System.out.println("prova");
            doorRight = new Door(700, 250, "right", roomRight);
            System.out.println("room right");
        }
    }

    public Background getBackground() {
        return background;
    }

    public List<SolidObject> getObjects() {
        return objects;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public Door getDoorUp() {
        return doorUp;
    }

    public Door getDoorDown() {
        return doorDown;
    }

    public Door getDoorLeft() {
        return doorLeft;
    }

    public Door getDoorRight() {
        return doorRight;
    }
}