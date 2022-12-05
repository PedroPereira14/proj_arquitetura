package pt.uma.arq.entities;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.SmallShip;
import pt.uma.arq.entities.MediumShip;
import pt.uma.arq.entities.LargeShip;
import pt.uma.arq.entities.PlayerShip;
import pt.uma.arq.game.Animator;
import pt.uma.arq.game.Ship;
import com.badlogic.gdx.utils.Timer;
import java.util.Random;

import java.util.ArrayList;

public class Fleet {
    private Animator animator;
    private ArrayList<Ship> ships;
    private SpriteBatch batch;
//    protected ArrayList<LaserEnemy> enemyLaserList = new ArrayList<LaserEnemy>();

    private int x,y;

    Timer timer;

    public Fleet(SpriteBatch batch){
        this.batch = batch;
        this.ships = new ArrayList<Ship>();
        timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                System.out.println("Timer");
                shootRandomly();
            }
        },1,2,-1);
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

    public void shootRandomly(){
        Random r = new Random();
        int index = r.nextInt(ships.size());
        ships.get(index).shoot();
    }

    public void render(){
        for (Ship s: ships) {
            s.render();
        }
    }

}
