package pt.uma.arq.entities;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;
import java.awt.*;

public class LaserEnemy {
    private Animator animator;

    private int x,y;

    private int damage;

    private Rectangle boundingBox;

    private boolean collided;

    public LaserEnemy(SpriteBatch batch, int x, int y){
        this.animator=new Animator(batch,"laserEnemy-bolts.png", 2, 2);
        animator.create();
        this.x = x;
        this.y = y;
    }
    public void create(){
        animator.create();
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void Hit(){
        if (collided){
            //health-=damage;
        }
    }

    public void renderSmall(){
        this.y -=5;
        this.animator.render(this.x,this.y);
    }

    public void renderMedium(){
        this.y -=5;
        this.x -=2;
        this.animator.render(this.x,this.y);
    }

    public void renderLarge(){
        this.y -=5;
        this.x +=2;
        this.animator.render(this.x,this.y);
    }


}
