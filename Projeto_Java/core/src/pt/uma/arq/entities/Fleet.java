package pt.uma.arq.entities;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.SmallShip;
import pt.uma.arq.entities.MediumShip;
import pt.uma.arq.entities.LargeShip;
import pt.uma.arq.entities.PlayerShip;
import pt.uma.arq.game.Animator;
import pt.uma.arq.game.Ship;

import java.util.ArrayList;

public class Fleet {
    private Animator animator;
    private ArrayList<Ship> ships;
    private SpriteBatch batch;
    protected ArrayList<Laser> enemyLaserList = new ArrayList<Laser>();

    private int x,y;

    public Fleet(SpriteBatch batch){
        this.batch = batch;
        this.ships = new ArrayList<Ship>();
    }

    public void shootRandomly(){
        Laser laser;
        laser = new Laser(batch, this.x, this.y + 20);
        enemyLaserList.add(laser);
    }

    public void create(){
        int ssx = 100;
        int msx = 50;
        int lsx = 50;
        for (int j= 0; j<10; j++){
            Ship s = new SmallShip(batch,ssx ,500);
            s.create();
            ships.add(s);
            ssx +=40;
        }
        for (int j= 0; j<10; j++){
            Ship m = new MediumShip(batch,msx ,600);
            m.create();
            ships.add(m);
            msx += 50;
        }
        for (int j= 0; j<10; j++){
            Ship l = new LargeShip(batch,lsx,700);
            l.create();
            ships.add(l);
            lsx +=50;
        }


    }

    public void render(){
        for (Ship s: ships) {
            s.render();
        }
    }

}
