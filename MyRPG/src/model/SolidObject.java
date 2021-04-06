package model;

import java.awt.*;

public class SolidObject extends Sprite{
    private int width;
    private int height;

    public SolidObject(int x, int y) {
        //, int width, int height
        super(x, y);
        //this.width = width;
        //this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), width, height);
    }
}
