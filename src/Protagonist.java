
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
    //velocity in the y direction
    float velocity = 0;
    int maxVelocity = 10;
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

    //all input happens here
    public void update(float deltaTime) {
        if (game.input.keyPressed == Keys.SPACE && velocity == 0) {
            jump();
            System.out.println("Jump aru");
        } //end keyPressed = keys.space
        calculatePhysics(deltaTime);
//        System.out.println("velocity = " + velocity + "");
        bounds.x = position.x;
        bounds.y = position.y;

    }//end update

    public void jump() {

        //only jumps if velocity is 0 
        if (velocity == 0) {
            acceleration.y = jumpValue;
        }

        //if velocity is greater than current maxVelocity then fix that 
        if (velocity < 10) {
            velocity = 10;
        } //end if statement

    } //end jump

    public void crouch() {
    }

    public void calculatePhysics(float deltaTime) {
        acceleration.y += friction_gravity.y;
        velocity += acceleration.y * deltaTime;

        if (velocity >= maxVelocity) {
            acceleration.y = 0;
            velocity = maxVelocity;
        } //end velocity >= maxVelocity
        position.y += velocity;

        if (position.y < groundLevel) {
            position.y = groundLevel;
            setZeros();
        } //end if position.y < groundLevel



    } //end calculate physics

    public void setZeros() {
        acceleration.y = 0;
        velocity = 0;
        position.y = groundLevel;

    } //end reset

    public void reset() {
        acceleration.y = 0;
        velocity = 0;
    }//end reset

    public ShapeFun getGame() {
        return game;
    } //end getGame

    public void setGame(ShapeFun game) {
        this.game = game;
    } //end setGame

    public Rectangle getBounds() {
        return bounds;
    } //end getBounds

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    } //setBounds

    public float getVelocity() {
        return velocity;
    } //end getVelocity

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    } //end setVelocity

    public Vector2 getAcceleration() {
        return acceleration;
    } //end getAcceleration

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