package pt.uma.arq.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;

import java.awt.*;

public class Laser {
    private Animator animator;

    private int x,y;

    private int damage;

    private Rectangle boundingBox;

    private boolean collided;

    public Laser(SpriteBatch batch){ this.animator=new Animator(batch,"laser.png", 2, 2);}

    public void create(){
        animator.create();
    }
    public void 

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void Hit(){
        if (collided){
            //health-=damage;
        }
    }

    public void render(){
        this.animator.render(this.x,this.y);
    }
}
