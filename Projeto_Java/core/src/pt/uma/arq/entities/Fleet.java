package pt.uma.arq.entities;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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

    private ArrayList<Laser> laserList = new ArrayList<Laser>();


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
        }, 1, 0.5f, -1);


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
                    playerShip.getSound2().play(0.1f);
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

    public void handleCollisionsEnemy(PlayerShip playerShip) {
        for (Ship ship: ships){
            for (Laser l: ship.getLaserList()){
                System.out.println(l.getBoundingBox());
                if (l.getBoundingBox().intersects(playerShip.getBoundingBox())){
                    playerShip.getSound3().play(0.2f);
                    if (ship.getType() == "Small"){
                        playerShip.setHealth(playerShip.getHealth()-5);
                    }
                    else if (ship.getType() == "Medium"){
                        playerShip.setHealth(playerShip.getHealth()-10);
                    }
                    else {
                        playerShip.setHealth(playerShip.getHealth()-20);
                    }
                    for (Laser ll : ship.getLaserList()) {
                        ll.getBoundingBox().setBounds(0, 0, 0, 0);
                    }
                }
            }
        }
    }

}