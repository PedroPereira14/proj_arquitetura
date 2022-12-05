package pt.uma.arq.game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.Laser;
import pt.uma.arq.entities.LaserEnemy;
import pt.uma.arq.game.Animator;

import java.awt.*;
import java.util.ArrayList;

public abstract class Ship {
    public Animator animator;

    private SpriteBatch batch;


    protected ArrayList<LaserEnemy> enemyLaserList = new ArrayList<LaserEnemy>();

    protected Rectangle boundingBox;

    protected int x,y;

    protected int health;

    public void create(){
        animator.create();
        boundingBox = new Rectangle(x,y,animator.getWidth(),animator.getHeight());
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
