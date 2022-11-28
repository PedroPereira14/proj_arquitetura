package pt.uma.arq.entities;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;
import pt.uma.arq.game.Ship;

public class PlayerShip extends Ship {
    Laser laser;

    Ship playerShip = new Ship(300, 100, 100) {

        @Override
        public void shoot() {

        }
    };
    private int PlayerSpeed = 4;
    public PlayerShip(SpriteBatch batch){
        this.animator=new Animator(batch,"ship.png", 5, 2);
    }

    public void create(){
        animator.create();
    }



    public void Movement () {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && x>=20)
            x -= PlayerSpeed;
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && x<=560)
            x += PlayerSpeed;
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
                laser = new Laser(this.x, this.y+5);

        //perguntar Segunda ao Prof como associar o movimento a animaçao
    }




    public void render(){
        Movement();
        this.animator.render(this.x,this.y);

    }

    @Override
    public void shoot() {
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
            this.animator.create();
        //perguntar Segunda ao Prof da Bala
    }


}
