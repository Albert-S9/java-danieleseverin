package model;

public abstract class Creature extends SolidObject{
    private int dx = 0;
    private int dy = 0;
    private String direction;
    //private DamageEffect damageEffect;
    private int MAX_HP;
    private int hp;
    public int damage;
    private boolean canMove = true;

    public Creature(int x, int y) {
        //String direction, int MAX_HP, int hp, int damage
        super(x, y);
       /*
        this.direction = direction;
        this.MAX_HP = MAX_HP;
        this.hp = hp;
        this.damage = damage;
        */
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public boolean getCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public abstract void loadImage();

    public abstract void setDimensions();
}
