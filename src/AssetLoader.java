
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JTTorres15
 */
public class AssetLoader {

    static AssetManager manager;
    static Sound jump1, jump2, jump3, hurt;
    static Music song1; 

    public AssetLoader() {
    }

    public static void load() {
        manager = new AssetManager();

        manager.load("data/sfx/Jump.wav", Sound.class);
        manager.load("data/sfx/Jump2.wav", Sound.class);
        manager.load("data/sfx/Jump3.wav", Sound.class);
        manager.load("data/sfx/Hit_Hurt.wav", Sound.class);
        manager.load("data/sfx/song1.wav", Music.class);


        manager.update();
        manager.finishLoading();
        jump1 = manager.get("data/sfx/Jump.wav", Sound.class);
        jump2 = manager.get("data/sfx/Jump2.wav", Sound.class);
        jump3 = manager.get("data/sfx/Jump3.wav", Sound.class);
        hurt = manager.get("data/sfx/Hit_Hurt.wav", Sound.class);
        song1 = manager.get("data/sfx/song1.wav", Music.class);
        song1.setLooping(true);


    } //end load

    public static void dispose() {
        jump1.dispose();
        jump2.dispose();
        jump3.dispose();
        hurt.dispose();
        song1.dispose();

        manager.dispose();
    } //end dispose
}
