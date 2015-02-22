
import com.badlogic.gdx.Input.Keys;
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
public class Protagonist {

    ShapeFun game;
    Rectangle bounds;
    float jumpValue = 10;
    float velocity = 0;
    int maxVelocity = 12;
    Vector2 acceleration;
    Vector2 friction_gravity;
    Vector2 position;
    int groundLevel;

    public Protagonist(ShapeFun game, int groundLevel) {
        this.game = game;
        position = new Vector2(122, 124);
        acceleration = new Vector2(0, 0);
        int state = 0;
        this.groundLevel = groundLevel;
        friction_gravity = new Vector2(0, -3f);
        bounds = new Rectangle(position.x, position.y, 40, 50);

    }

    public void update(float deltaTime) {
        if (game.input.keyPressed == Keys.SPACE && velocity == 0) {
            jump();
            System.out.println("Jump aru");
        }
        calculatePhysics(deltaTime);
        System.out.println("velocity = " + velocity + "");
        bounds.x = position.x;
        bounds.y = position.y;

    }

    public void jump() {
        if (velocity == 0) {
            acceleration.y = jumpValue;
        }


        if (velocity < 10) {
            velocity = 10;
        }

    }

    public void crouch() {
    }

    public void calculatePhysics(float deltaTime) {
        acceleration.y += friction_gravity.y;
        velocity += acceleration.y * deltaTime;

        if (velocity >= maxVelocity) {
            acceleration.y = 0;
            velocity = maxVelocity;
        }
        position.y += velocity;

        if (position.y < groundLevel) {
            position.y = groundLevel;
            setZeros();
        }



    }

    private void setZeros() {
        acceleration.y = 0;
        velocity = 0;
    }

    public ShapeFun getGame() {
        return game;
    }

    public void setGame(ShapeFun game) {
        this.game = game;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.acceleration = acceleration;
    }

    public Vector2 getFriction_gravity() {
        return friction_gravity;
    }

    public void setFriction_gravity(Vector2 friction_gravity) {
        this.friction_gravity = friction_gravity;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public int getGroundLevel() {
        return groundLevel;
    }

    public void setGroundLevel(int groundLevel) {
        this.groundLevel = groundLevel;
    }
}