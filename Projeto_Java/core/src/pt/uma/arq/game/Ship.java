package pt.uma.arq.game;
import pt.uma.arq.game.Animator;

public abstract class Ship {
    public Animator animator;

    protected int x,y;

    protected int health;

    public void create(){
        animator.create();
    }

    public void render(){
        this.animator.render(this.x,this.y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract void shoot();

}
