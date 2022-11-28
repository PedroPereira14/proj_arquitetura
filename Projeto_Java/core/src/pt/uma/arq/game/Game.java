package pt.uma.arq.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.PlayerShip;
import pt.uma.arq.entities.SmallShip;

public class Game extends ApplicationAdapter {
    private SpriteBatch batch;

    private BackgroundManagement backgroundManagement;
    private BitmapFont font;

    private PlayerShip player;
    private SmallShip smallShip;


    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(600, 800);
        batch = new SpriteBatch();
        player = new PlayerShip(batch);
        smallShip = new SmallShip(batch);
        player.create();
        player.setX(300);
        player.setY(100);
        smallShip.create();
        smallShip.setX(200);
        smallShip.setY(400);
        font = new BitmapFont(Gdx.files.internal("gamefont.fnt"),
                Gdx.files.internal("gamefont.png"), false);
        backgroundManagement = new BackgroundManagement(batch);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        backgroundManagement.render();
        player.render();
        smallShip.render();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}