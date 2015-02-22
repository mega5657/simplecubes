
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JTTorres15
 */
public class ShapeDesktop {

    public static void main(String[] args) {
        LwjglApplicationConfiguration config;
        config = new LwjglApplicationConfiguration();
        config.title = "WIP";
        config.resizable = false;
        config.height = 400;
        config.width = 600;
        new LwjglApplication(new ShapeFun(), config);

    }
}
