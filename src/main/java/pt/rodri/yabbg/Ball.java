package pt.rodri.yabbg;
import java.awt.*;

public class Ball {
    private int x;          // X-coordinate of the ball
    private int y;          // Y-coordinate of the ball
    private int diameter;   // Diameter of the ball
    private int xSpeed;     // Speed of the ball in the x-direction
    private int ySpeed;     // Speed of the ball in the y-direction

    public Ball(int x, int y, int diameter, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter, diameter);
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;
    }

    // Collision detection with the walls
    public void checkWallCollision(int screenWidth, int screenHeight) {
        if (x <= 0 || x >= screenWidth - diameter) {
            xSpeed = -xSpeed;
        }

        if (y <= 0 || y >= screenHeight - diameter) {
            ySpeed = -ySpeed;
        }
    }

    // Getters and Setters for the ball's position and diameter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }
    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    // Add setXSpeed method
    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    // Add setYSpeed method
    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }


    // Methods to update the ball's position and check for collisions
    public void update(int screenWidth, int screenHeight) {
        move();
        checkWallCollision(screenWidth, screenHeight);
    }
}
