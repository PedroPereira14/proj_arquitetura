package pt.uma.arq.entities;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Ship;
import pt.uma.arq.game.Animator;

import java.awt.*;
import java.util.ArrayList;

public class SmallShip extends Ship {


    public SmallShip(SpriteBatch batch, int x, int y){
        super(batch,"enemy-small.png", 2, 1,x,y,"Small");
        this.create();
    }


    public void render(){
        this.animator.render(this.x,this.y);
        if(boundingBox != null){
            this.boundingBox.setLocation(x,y);
        }
        if(laserList != null) {
            for (Laser ll: laserList) {
                if(ll.getIsEnemy()){
                    ll.renderSmall();
                }
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
        Laser enemyLaser;
        enemyLaser = new Laser(batch, this.x, this.y - 10,true,"laserEnemy-bolts.png");
        laserList.add(enemyLaser);
    }
}
