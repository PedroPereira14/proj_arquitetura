package pt.uma.arq.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;
import pt.uma.arq.game.Ship;

import java.awt.*;
import java.util.ArrayList;

public class PlayerShip extends Ship {
    private int health, score;

    private Sound sound1,sound2,sound3;
    private int PlayerSpeed = 4;

    public PlayerShip(SpriteBatch batch, int x, int y){
        super(batch,"ship.png", 5, 2,x,y,"Player");
        this.health = 100;
        this.score = 0;
        this.create();
        this.boundingBox = new Rectangle(x, y, animator.getWidth(), animator.getHeight());
        this.sound1 = Gdx.audio.newSound(Gdx.files.internal("playerShotSound.wav"));
        this.sound2 = Gdx.audio.newSound(Gdx.files.internal("Explosion(CAVALO).mp3"));
        this.sound3 = Gdx.audio.newSound(Gdx.files.internal("EnemyLaserCollision(EleGosta).mp3"));
    }

    public void Movement () {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && x>=20) {
            this.x -= PlayerSpeed;
            this.boundingBox.setLocation(x, y);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && x<=560){
            this.x += PlayerSpeed;
            this.boundingBox.setLocation(x, y);
        }
    }



    public void render(){
        Movement();
        shoot();
        this.animator.render(this.x,this.y);
        if(laserList != null) {
            for (Laser ll: laserList) {
                if(ll.getCollided() || ll.getY() > 800) {
                    ll.renderPlayer();
                }
            }
            }
       }


    public Sound getSound2() {
        return sound2;
    }

    public Sound getSound3() {
        return sound3;
    }

    public ArrayList<Laser> getLaserList() {
        return laserList;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    @Override
    public void shoot() {
        Laser laser;
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            laser = new Laser(batch, this.x, this.y + 20, false,"laser-bolts.png");
            laserList.add(laser);
            sound1.play(0.3f);
        }
        //laser.create();

    }


}
