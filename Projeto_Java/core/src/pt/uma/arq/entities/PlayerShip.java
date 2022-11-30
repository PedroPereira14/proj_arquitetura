package pt.uma.arq.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;
import pt.uma.arq.game.Ship;

public class PlayerShip extends Ship {
    private SpriteBatch batch;


    private int PlayerSpeed = 4;
    public PlayerShip(SpriteBatch batch){
        this.batch = batch;
        this.animator=new Animator(batch,"ship.png", 5, 2);
    }

    public void create(){
        animator.create();
    }



    public void Movement () {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && x>=20)
            this.x -= PlayerSpeed;

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && x<=560)
            this.x += PlayerSpeed;
        //perguntar Segunda ao Prof como associar o movimento a animaçao
    }



    public void render(){
        Movement();
        shoot();
        this.animator.render(this.x,this.y);
        if(laserList != null) {
            for (Laser ll: laserList) {
                ll.render();
            }
        }


    }

    @Override
    public void shoot() {
        Laser laser;
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            laser = new Laser(batch, this.x, this.y + 20);
            laserList.add(laser);
        }
        //laser.create();

    }


}
