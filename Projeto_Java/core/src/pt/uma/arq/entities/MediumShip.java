package pt.uma.arq.entities;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;
import pt.uma.arq.game.Ship;

import java.awt.*;

public class MediumShip extends Ship {

    private SpriteBatch batch;
    private int x,y;

    private Rectangle boundingBox;

    private boolean collided;

    private int health;

    public MediumShip(SpriteBatch batch,int x, int y){
        this.batch = batch;
        this.animator=new Animator(batch,"enemy-medium.png", 2, 1);
        this.x = x;
        this.y = y;
    }

    public void create(){
        animator.create();
    }

    public void render(){
        this.animator.render(this.x,this.y);
        if(enemyLaserList != null) {
            for (LaserEnemy ll: enemyLaserList) {
                ll.renderMedium();
            }
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    @Override
    public void shoot() {
        LaserEnemy enemyLaser;
        enemyLaser = new LaserEnemy(batch, this.x, this.y - 10);
        enemyLaserList.add(enemyLaser);
    }
}
