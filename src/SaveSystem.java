
import com.badlogic.gdx.Game;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SaveSystem {

    FileInputStream loadFile;
    ObjectInputStream load;

    FileOutputStream saveFile;
    ObjectOutputStream save;
    Unlocks unlocks;

    public SaveSystem(ShapeFun game) {
        unlocks = game.unlocks;

        if (checkSaveCreated()) {
            try {
                loadFile = new FileInputStream("src/data/save/saveFile.sav");
                load = new ObjectInputStream(loadFile);

            } catch (IOException e) {
                System.out.println(e);
            }
            System.out.println("THIS IS TRUE FOR SOME REASON SMH");
        } else {
            try {
                System.out.println("TRY TRY ");
                saveFile = new FileOutputStream("src/data/save/saveFile.sav");
                save = new ObjectOutputStream(saveFile);
                save.writeObject(game.unlocks);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void load() throws IOException {
        try {
            unlocks = (Unlocks) load.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println(e);

        }

    }

    public void save() {
        try {
            save.writeObject(unlocks);
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println(checkSaveCreated());
    }

    public boolean checkSaveCreated() {
        File f = new File("src/data/save/saveFile.sav");
        return f.exists();
    }
}
