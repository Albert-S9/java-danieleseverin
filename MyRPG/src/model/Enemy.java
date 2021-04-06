package model;

public abstract class Enemy extends Creature{
    public Enemy(int x, int y) {
        super(x, y);
    }

    public abstract void move(PC pc);

    public void getPcPosition(PC pc){

        if(getX() > pc.getX()) {
            setDx(-1);
            setDy(0);
        }
        if(getX() < pc.getX()) {
            setDx(1);
            setDy(0);
        }
        if(getY() > pc.getY()) {
            setDx(0);
            setDy(-1);
        }
            if (getY() < pc.getY()) {
                setDx(0);
                setDy(1);
            }
        }
}
