package pt.uma.arq.entities;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;
import pt.uma.arq.game.Ship;

import java.awt.*;

public class MediumShip extends Ship {
    private int x,y;

    private Rectangle boundingBox;

    private boolean collided;

    private int health;

    public MediumShip(SpriteBatch batch){
        this.animator=new Animator(batch,"enemy-medium.png", 2, 1);
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
