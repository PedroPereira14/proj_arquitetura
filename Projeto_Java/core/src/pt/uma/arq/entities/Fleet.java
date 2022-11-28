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


    public Fleet(SpriteBatch batch){
        this.batch = batch;
        this.ships = new ArrayList<Ship>();
    }

    public void create(){
        int ssx = 120;
        int msx = 100;
        for (int j= 0; j<10; j++){
            Ship s = new SmallShip(batch,ssx ,600);
            s.create();
            ships.add(s);
            ssx +=30;
        }
        for (int j= 0; j<10; j++){
            Ship m = new MediumShip(batch,msx ,700);
            m.create();
            ships.add(m);
            msx +=50;
        }


    }

    public void render(){
        for (Ship s: ships) {
            s.render();
        }
    }

}
