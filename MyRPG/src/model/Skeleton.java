package model;

import javax.swing.*;

public class Skeleton extends Enemy{

    ImageIcon skeleton = new ImageIcon("src/resources/skeleton.png");

    public Skeleton(int x, int y) {
        super(x, y);
        loadImage();
        setDimensions();
    }

    @Override
    public void loadImage(){
        setImage(skeleton.getImage());
    }

    @Override
    public void setDimensions(){
        setWidth(getImage().getWidth(null));
        setHeight(getImage().getHeight(null));
    }

    @Override
    public void move(PC pc) {
        getPcPosition(pc);

        if(getCanMove()) {
            setX(getX()+getDx());
            setY(getY()+getDy());
        }
    }
}
