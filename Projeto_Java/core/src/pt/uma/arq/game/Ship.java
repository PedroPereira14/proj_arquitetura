package pt.uma.arq.game;
import pt.uma.arq.game.Animator;

public abstract class Ship {
    public Animator animator;

    private int x,y;

    private int health;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract void shoot();

}
