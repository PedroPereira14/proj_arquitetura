package pt.uma.arq.entities;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pt.uma.arq.game.Animator;
import pt.uma.arq.game.Ship;
import com.badlogic.gdx.utils.Timer;

import java.util.Iterator;
import java.util.Random;

import java.util.ArrayList;

public class Fleet {
    private Animator animator;
    private ArrayList<Ship> ships;
    private SpriteBatch batch;
    Timer timer;


    public Fleet(SpriteBatch batch) {
        this.batch = batch;
        this.ships = new ArrayList<Ship>();
        timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                shootRandomly();
            }
        }, 1, 2, -1);


    }

    public void shootRandomly() {
        Random r = new Random();
        int index = r.nextInt(ships.size());
        ships.get(index).shoot();
    }



    public void create() {
        int ssx = 100;
        int msx = 30;
        int lsx = 50;
        for (int j = 0; j < 10; j++) {
            Ship s = new SmallShip(batch, ssx, 500);
            s.create();
            ships.add(s);
            ssx += 40;
        }
        for (int j = 0; j < 10; j++) {
            Ship m = new MediumShip(batch, msx, 600);
            m.create();
            ships.add(m);
            msx += 55;
        }
        for (int j = 0; j < 10; j++) {
            Ship l = new LargeShip(batch, lsx, 700);
            l.create();
            ships.add(l);
            lsx += 50;
        }


    }

    public void render() {
        for (Ship s : ships) {
            s.render();
        }
    }

    public void handleCollisions(PlayerShip playerShip) {
        Iterator<Ship> iterator = ships.iterator();
        while (iterator.hasNext()) {
            Ship ship = iterator.next();
            for (Laser l : playerShip.getLaserList()) {

                if (l.getBoundingBox().intersects(ship.getBoundingBox())) {
                    iterator.remove();
                    l.setCollided(false);
                    if (ship.getType() == "Small"){
                        playerShip.setScore(playerShip.getScore()+5);
                    }
                    else if (ship.getType() == "Medium"){
                        playerShip.setScore(playerShip.getScore()+10);
                    }
                    else {
                        playerShip.setScore(playerShip.getScore()+20);
                    }
                }

            }

        }
    }

}