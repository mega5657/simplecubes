
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
    Vector2 initPosition = new Vector2(0, 0);
    Rectangle bounds = new Rectangle(0, 0, 20, 30);
    Vector2 velocity = new Vector2(0, 0);
    float deltaTime = 0;

    public Obstacle(int positionX, int positionY, int width, int height, float speed) {
        velocity.x = speed;
        position.x = positionX;
        position.y = positionY;
        initPosition.x = positionX;
        initPosition.y = positionY;
        bounds.x = position.x;
        bounds.y = position.y;

    }

    public void update(float deltaTime) {
        position.x -= velocity.x * deltaTime;
        bounds.x = position.x;


    }

    public void setParameters(int x, int y, int width, int height, int speed) {
        position.x = x;
        position.y = y;
        bounds.x = x;
        bounds.y = y;
        bounds.width = width;
        bounds.height = height;
        velocity.x = speed;
        initPosition.x = x;
        initPosition.y = y;
    }

    public void reset() {
        position.x = initPosition.x;
        position.y = initPosition.y;
        velocity.y = 0;

    }
}
