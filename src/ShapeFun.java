
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JTTorres15
 */
public class ShapeFun extends Game {

    MainMenuScreen menuScreen;
    GameScreen gameScreen;
    FPSLogger fps;
    int DEVICE_WIDTH;
    int DEVICE_HEIGHT;
    public InputHandler input;
    boolean debug = true;
    
    

    @Override
    public void create() {
        DEVICE_WIDTH = Gdx.graphics.getWidth();
        DEVICE_HEIGHT = Gdx.graphics.getHeight();
        fps = new FPSLogger();
        menuScreen = new MainMenuScreen(this);
        gameScreen = new GameScreen(this);
        setScreen(menuScreen);
        input = new InputHandler();
                Gdx.input.setInputProcessor(input);

    }

    @Override
    public void render() {
        super.render();
        fps.log();
        input.update();
    }
}
