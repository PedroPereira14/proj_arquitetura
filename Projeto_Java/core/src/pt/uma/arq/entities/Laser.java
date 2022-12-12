package pt.uma.arq.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Laser {

    private boolean isEnemy;
    private Animator animator;
    private int x,y;
    private Rectangle boundingBox;

    protected SpriteBatch batch;
    private boolean collided=true;


    public Laser(SpriteBatch batch, int x, int y, boolean isEnemy, String path){
        this.isEnemy = isEnemy;
        this.batch = batch;
        this.animator= new Animator(batch,path, 2, 2);
        this.animator.create();
        this.x = x;
        this.y = y;
        this.boundingBox = new Rectangle(x,y,animator.getWidth(),animator.getHeight());
    }


    public boolean getIsEnemy() {
        return isEnemy;
    }

    public boolean getCollided() {
        return collided;
    }

    public void setCollided(boolean collided) {
        this.collided = collided;
    }
    public int getY() {
        return y;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void renderPlayer(){
        this.y +=5;
        this.boundingBox.setLocation(x,y);
        this.animator.render(this.x,this.y);

    }
    public void renderSmall(){
        this.y -=5;
        this.boundingBox.setLocation(x,y);
        this.animator.render(this.x,this.y);
    }

    public void renderMedium(){
        this.y -=5;
        this.x -=1;
        this.boundingBox.setLocation(x,y);
        this.animator.render(this.x,this.y);
    }

    public void renderLarge(){
        this.y -=5;
        this.x +=1;
        this.boundingBox.setLocation(x,y);
        this.animator.render(this.x,this.y);
    }



}
