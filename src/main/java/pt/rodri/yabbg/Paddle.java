package pt.rodri.yabbg;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Paddle {
    private int x;           // X-coordinate of the paddle
    private int y;           // Y-coordinate of the paddle
    private int width;       // Width of the paddle
    private int height;      // Height of the paddle
    private int xSpeed;      // Speed of the paddle in the x-direction

    public Paddle(int x, int y, int width, int height, int xSpeed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.xSpeed = xSpeed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    public void moveLeft() {
        x -= xSpeed;
    }

    public void moveRight() {
        x += xSpeed;
    }

    // Keep the paddle within the screen boundaries
    private void checkBoundary(int screenWidth) {
        if (x < 0) {
            x = 0;
        } else if (x > screenWidth - width) {
            x = screenWidth - width;
        }
    }

    // Getters and Setters for the paddle's position and size
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

    // Add setSpeed method
    public void setSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    // Methods to update the paddle's position based on user input
    public void update(int screenWidth) {
        checkBoundary(screenWidth);
    }

    // Handle key events for paddle movement
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight();
        }
    }
}
