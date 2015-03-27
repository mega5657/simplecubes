
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JTTorres15
 */
public class MainMenuScreen implements Screen {

    ShapeRenderer shape;
    ShapeFun game;
    OrthographicCamera cam;
    SpriteBatch batcher;
    BitmapFont font;
    BitmapFont smallerFont;
    Rectangle startBounds;
    Rectangle upgradeBounds;
    Rectangle optionBounds;

    public MainMenuScreen(ShapeFun game) {
        this.game = game;
        batcher = new SpriteBatch();
        cam = new OrthographicCamera(600, 400);
        cam.position.set(600 / 2, 400 / 2, 0);
        font = new BitmapFont();
        smallerFont = new BitmapFont();
        font.setColor(Color.BLACK);
        font.setScale(3);
        shape = new ShapeRenderer();
        shape.setColor(Color.GREEN);
        startBounds = new Rectangle(145, 205, 315, 60);
        upgradeBounds = new Rectangle(145, 100, 250, 60);
        optionBounds = new Rectangle(0, 0, 0, 0);

    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(1, 1, 1, 1);//set Background COlor White
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        batcher.setProjectionMatrix(cam.combined);

        batcher.begin();
        batcher.enableBlending();
        font.draw(batcher, "Simple Runner", game.DEVICE_WIDTH / 2 - 145, game.DEVICE_HEIGHT / 2 + 59);

        batcher.end();

        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.rect(startBounds.x, startBounds.y, startBounds.width, startBounds.height);
        shape.end();

        update();

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

    private void update() {
        if (game.input.getTouchPosX() > 0) {
            if (CollisionTester.pointInRectangle(startBounds, game.input.touchPos) || game.input.keyPressed == Input.Keys.SPACE) {
                game.setScreen(game.gameScreen);
            } //end if startbounds
        } //end if game.input.getTouchPosX

        if (game.input.getTouchPosX() > 0) {
            if (CollisionTester.pointInRectangle(upgradeBounds, game.input.touchPos)) {
                game.setScreen(game.upgradeScreen);
            } //end upgradeBounds
        } //end if game.input.getTouchPosX

        if (game.input.getTouchPosX() > 0) {
            if (CollisionTester.pointInRectangle(optionBounds, game.input.touchPos)) {
                game.setScreen(game.optionScreen);
            } //end optionBounds
        } //end if game.input.getTouchPosX

    }
}
