
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import java.io.IOException;

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
    UpgradeScreen upgradeScreen;
    OptionScreen optionScreen;
    ShopScreen shopScreen;

    FPSLogger fps;
    int DEVICE_WIDTH;
    int DEVICE_HEIGHT;
    public InputHandler input;
    boolean debug = true;
    AssetLoader manager;

    SaveSystem saveSystem;
    Unlocks unlocks;

    @Override
    public void create() {
        DEVICE_WIDTH = Gdx.graphics.getWidth();
        DEVICE_HEIGHT = Gdx.graphics.getHeight();
        fps = new FPSLogger();

        saveSystem = new SaveSystem(this);
        unlocks = new Unlocks();
        
      
        menuScreen = new MainMenuScreen(this);
        gameScreen = new GameScreen(this);
        shopScreen = new ShopScreen(this);
        setScreen(menuScreen);
        input = new InputHandler();
        Gdx.input.setInputProcessor(input);
        AssetLoader.load();
    }

    @Override
    public void render() {
        super.render();
        fps.log();
        input.update();

    }
}
