
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JTTorres15
 */
public class Obstacle {

    Vector2 position = new Vector2(0, 0);
    Rectangle bounds = new Rectangle(0, 0, 20, 30);
    float velocity = 0;
    float deltaTime = 0;

    public Obstacle(int positionX, int positionY, int width, int height, float speed) {
        velocity = speed;
        position.x = positionX;
        position.y = positionY;
        bounds.x = position.x;
        bounds.y = position.y;

    }

    public void update(float deltaTime) {
        position.x -= velocity * deltaTime;
        bounds.x = position.x;


    }

    public void setParameters(int x, int y, int width, int height, int speed) {
        position.x = x;
        position.y = y;
        bounds.x = x;
        bounds.y = y;
        bounds.width = width;
        bounds.height = height;
        velocity = speed;
    }
}
