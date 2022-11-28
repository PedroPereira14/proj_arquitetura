package pt.uma.arq.entities;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Ship;
import pt.uma.arq.game.Animator;

import java.awt.*;

public class SmallShip extends Ship {
    private int x,y;

    private Rectangle boundingBox;

    private boolean collided;

    private int health;

    public SmallShip(SpriteBatch batch, int x, int y){

        this.animator=new Animator(batch,"enemy-small.png", 2, 1);
        this.x=x;
        this.y=y;
    }

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

    @Override
    public void shoot() {

    }
}
