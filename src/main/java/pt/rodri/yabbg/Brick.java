package pt.rodri.yabbg;
import java.awt.Color;
import java.awt.Graphics;

public class Brick {
    private int x;          // X-coordinate of the brick
    private int y;          // Y-coordinate of the brick
    private int width;      // Width of the brick
    private int height;     // Height of the brick
    private boolean visible; // State of the brick (visible or not)

    public Brick(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.visible = true;
    }

    public void draw(Graphics g) {
        if (visible) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, width, height);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, height);
        }
    }

    // Check for collision with the ball
    public boolean collidesWithBall(int ballX, int ballY, int ballDiameter) {
        return visible && ballX + ballDiameter >= x && ballX <= x + width
                && ballY + ballDiameter >= y && ballY <= y + height;
    }

    // Hide the brick if there is a collision with the ball
    public void handleCollision() {
        visible = false;
    }

    // Getters for the brick's position and size
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
