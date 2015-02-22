
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JTTorres15
 */
public class GameScreen implements Screen {

    ShapeFun game;
    SpriteBatch batcher;
    ShapeRenderer shape;
    Protagonist squareBoy;
    OrthographicCamera cam;
    BitmapFont font;
    Obstacle[] obst;
    int groundLevel = 124;
    Random r;
    int GameState = 0;
    final int RUNNING = 0, PAUSE = 1, GAME_OVER = 2;
    int choice = 0;
    int score = 0;
    float timer = 0;
    int difficulty = 0;
    int displacement = 0;
    int genX = 0;
    int genY = 0;
    int genWidth = 0;
    int genHeight = 0;
    int genSpeed = 0;

    public GameScreen(ShapeFun game) {
        r = new Random();
        this.game = game;

        cam = new OrthographicCamera(600, 400);
        cam.position.set(600 / 2, 400 / 2, 0);

        batcher = new SpriteBatch();
        shape = new ShapeRenderer();
        squareBoy = new Protagonist(game, groundLevel);
        obst = new Obstacle[5];
        for (int i = 0; i < 5; i++) {
            obst[i] = new Obstacle(700, groundLevel, 50, 70, 25);
        }

        font = new BitmapFont();
        font.setColor(Color.BLACK);

        shape.setColor(Color.BLACK);
        obst[0].setParameters(400, groundLevel, 50, 60, 300);


    }

    @Override
    public void render(float f) {
        if (GameState == RUNNING) {
            timer += f;
            if (timer >= .1) {
                score++;
                timer = 0;
            }

            Gdx.gl.glClearColor(1, 1, 1, 1);//set Background Color White
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            cam.update();
            batcher.setProjectionMatrix(cam.combined);

            batcher.begin();
            batcher.end();

            shape.begin(ShapeRenderer.ShapeType.Filled);
            shape.rect(squareBoy.position.x, squareBoy.position.y, 40, 50);
            shape.end();

            shape.begin(ShapeRenderer.ShapeType.Filled);

            shape.rect(obst[0].position.x, obst[0].position.y, obst[0].bounds.width, obst[0].bounds.height);

            shape.end();

            batcher.begin();
            font.drawWrapped(batcher, "Score: " + score + "", game.DEVICE_WIDTH - 200, game.DEVICE_HEIGHT - 50, 100);


            if (game.debug == true) {
            }
            batcher.end();
            update(f);
        }

        if (GameState == GAME_OVER) {
            timer += f;
            Gdx.gl.glClearColor(1, 1, 1, 1);//set Background Color White
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            cam.update();
            batcher.setProjectionMatrix(cam.combined);

            batcher.begin();
            font.drawWrapped(batcher, "Game Over. Score = " + score + "", game.DEVICE_WIDTH - 200, game.DEVICE_HEIGHT - 50, 100);
            batcher.end();
            System.out.println(timer);
            if (timer > 2) {
                timer = 0;
                GameState = RUNNING;
                game.setScreen(game.menuScreen);
                reset();
            }
        }
    }

//game logic is here
    private void update(float deltaTime) {
        squareBoy.update(deltaTime);
        obst[0].update(deltaTime);
        if (obst[0].position.x < -700) {
            obst[0].position.x = 500;
        }

        if (checkCollision()) {
            AssetLoader.hurt.play();
            GameState = GAME_OVER;
            
        }
    }

    //TO DO handle checks for the array of obstacles
    private boolean checkCollision() {
        if (overlapRectangles(obst[0].bounds, squareBoy.bounds)) {
            return true;
        }

        return false;
    }

    private boolean overlapRectangles(Rectangle r1, Rectangle r2) {
        if (r1.x < r2.x + r2.width && r1.x + r1.width > r2.x && r1.y < r2.y + r2.height && r1.y + r1.height > r2.y) {
            return true;
        } else {
            return false;
        }
    }

    private void reset() {
       
    }

    @Override
    public void resize(int i, int i1) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}