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
                Room roomUp, Room roomRight, Room roomDown, Room roomLeft) {

        this.background = background;
        this.objects = objects;
        this.enemies = enemies;

        initDoors(roomUp, roomRight, roomDown, roomLeft);
    }

    private void initDoors(Room roomUp,  Room roomRight, Room roomDown, Room roomLeft) {
        if (roomUp != null) {
            doorUp = new Door(350, 0, "up", roomUp);
        }
        if (roomRight != null) {
            doorRight = new Door(750, 200, "right", roomRight);
        }
        if (roomDown != null) {
            doorDown = new Door(350, 420, "down", roomDown);
        }
        if (roomLeft != null) {
            doorLeft = new Door(0, 200, "left", roomLeft);
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