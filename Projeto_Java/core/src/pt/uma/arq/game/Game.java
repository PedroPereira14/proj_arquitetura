package pt.uma.arq.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.Fleet;
import pt.uma.arq.entities.Laser;
import pt.uma.arq.entities.PlayerShip;
import pt.uma.arq.entities.SmallShip;

public class Game extends ApplicationAdapter {
    private SpriteBatch batch;

    private BackgroundManagement backgroundManagement;
    private BitmapFont font;

    private PlayerShip player;


    private Fleet ships;



    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(600, 800);
        batch = new SpriteBatch();
        ships = new Fleet(batch);
        player = new PlayerShip(batch,300,100);
        ships.create();
        player.create();
        font = new BitmapFont(Gdx.files.internal("gamefont.fnt"),
                Gdx.files.internal("gamefont.png"), false);
        backgroundManagement = new BackgroundManagement(batch);
    }

    @Override
    public void render() {
        batch.begin();
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        backgroundManagement.render();
        font.draw(batch,"Score: "+ player.getScore(),300,100);
        font.draw(batch,"Health:" + player.getHealth(),300,50);
        player.render();
        ships.render();
        ships.handleCollisions(player);
        if (player.getScore() == 350){
            font.draw(batch,"You win",250,500);
        }
        else if(player.getHealth() == 0){
            font.draw(batch,"You Lose",250,500);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}