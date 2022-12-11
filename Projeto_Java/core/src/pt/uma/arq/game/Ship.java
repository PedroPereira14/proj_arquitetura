package pt.uma.arq.game;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.Laser;

import java.awt.*;
import java.util.ArrayList;

public abstract class Ship {

    protected int x,y;
    public Animator animator;

    private String type;

    protected SpriteBatch batch;

    protected ArrayList<Laser> laserList = new ArrayList<Laser>();

    protected Rectangle boundingBox;

    public Ship(SpriteBatch batch, String path, int columns, int rows, int x, int y, String type) {
        this.type = type;
        this.x=x;
        this.y=y;
        this.animator= new Animator(batch, path, columns, rows);
        this.batch = batch;
    }



    public void create(){
        animator.create();
        boundingBox = new Rectangle(x,y,animator.getWidth(),animator.getHeight());
    }


    public void render(){
        this.animator.render(this.x,this.y);
        this.boundingBox.setLocation(x,y);
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Laser> getLaserList() {
        return laserList;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public abstract void shoot();


    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
