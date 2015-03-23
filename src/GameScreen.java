


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
    int count =0;
    int increment = 0;
    int genX = 0;
    int genY = 0;
    int genWidth = 0;
    int genHeight = 0;
    int genSpeed = 0;
    boolean GODMODE = false;

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
            update(f);
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

            for (int i = 0; i < obst.length; i++) {
                shape.rect(obst[i].position.x, obst[i].position.y, obst[i].bounds.width, obst[i].bounds.height);
            }

            shape.end();

//            shape.begin(ShapeRenderer.ShapeType.Filled);
//
//            shape.rect(obst[0].position.x, obst[0].position.y, obst[0].bounds.width, obst[0].bounds.height);
//
//            shape.end();
            batcher.begin();
            font.drawWrapped(batcher, "Score: " + score + "", game.DEVICE_WIDTH - 200, game.DEVICE_HEIGHT - 50, 100);

            if (game.debug == true) {
                font.drawWrapped(batcher, "Velocity: " + squareBoy.velocity + "", game.DEVICE_WIDTH - 200, game.DEVICE_HEIGHT - 25, 200);
                font.drawWrapped(batcher, "DeltaTime: " + f + "", game.DEVICE_WIDTH - 200, game.DEVICE_HEIGHT - 70, 200);

            }
            batcher.end();
        } //end of if statement Game RUNNING

        if (GameState == GAME_OVER) {
            timer += f;
            Gdx.gl.glClearColor(1, 1, 1, 1);//set Background Color White
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            cam.update();
            batcher.setProjectionMatrix(cam.combined);

            batcher.begin();
            font.drawWrapped(batcher, "Game Over. Score = " + score + "", game.DEVICE_WIDTH - 200, game.DEVICE_HEIGHT - 50, 100);
            batcher.end();
//            System.out.println(timer);
            if (timer > 2) {
                timer = 0;
                GameState = RUNNING;
                game.setScreen(game.menuScreen);
                reset();
            }//end timer if statement
        } //end if GAME OVER
    } //end render method

//game logic is here
    private void update(float deltaTime) {
        squareBoy.update(deltaTime);
        obst[0].update(deltaTime);
        if (obst[0].position.x < -100) {
            obst[0].position.x = 750;
        }

        if (checkCollision() && !GODMODE) {
            AssetLoader.hurt.play();
            GameState = GAME_OVER;
        }
    } //end update

    //TO DO handle checks for the array of obstacles
    private boolean checkCollision() {
        if (CollisionTester.overlapRectangles(obst[0].bounds, squareBoy.bounds)) {
            return true;
        }

        return false;
    }

    private void updateAlgorithim() {
        for (int i = 0; i < obst.length; i++) {
//                shape.rect(obst[i].position.x, obst[i].position.y, obst[i].bounds.width, obst[i].bounds.height);
            if (obst[i].position.x < -300) {
                
                
            }
        }
        
        //to do max position 
        //the first object that cross the boundary is added past the max position
        //for each consequtive object add a random distance between objects that are past -300

    }

    private void reset() {
        squareBoy.reset();
        obst[0].reset();
        score = 0;
    } //end reset

    @Override
    public void resize(int i, int i1) {
    } //end resize

    @Override
    public void show() {
        AssetLoader.song1.play();
        
    } //end show

    @Override
    public void hide() {
        AssetLoader.song1.pause();
    }// end hide

    @Override
    public void pause() {
    } //end pause

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
