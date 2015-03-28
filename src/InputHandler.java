
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JTTorres15
 */
public class InputHandler implements InputProcessor {

    Vector3 touchPos;
    int keyPressed = -1234;

    public InputHandler() {
        touchPos = new Vector3(0, 0, 0);
    }

    @Override
    public boolean keyDown(int i) {
        keyPressed = i;
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        keyPressed = -1234;
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        System.out.println("X, Y: " + i + ", " + (Gdx.graphics.getHeight() - i1) + " ");
        return false;
    }

    @Override
    public boolean touchUp(int x, int y, int i2, int i3) {
        touchPos.x = x;
        touchPos.y = Gdx.graphics.getHeight() - y;
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }

    public float getTouchPosX() {
        return touchPos.x;
    }

    public float getTouchPosY() {
        return touchPos.y;
    }

    public void update() {
        touchPos.x = 0;
        touchPos.y = 0;

    }
}
