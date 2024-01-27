package pt.rodri.yabbg;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Ball ball;
    private Paddle paddle;
    private ArrayList<Brick> bricks;
    private Timer timer;

    public GamePanel() {
        setFocusable(true);
        addKeyListener(this);

        ball = new Ball(150, 300, 20, 2, 2);
        paddle = new Paddle(120, 350, 80, 10, 5);
        bricks = createBricks();

        timer = new Timer(10, this);
        timer.start();
    }

    private ArrayList<Brick> createBricks() {
        ArrayList<Brick> brickList = new ArrayList<>();
        int brickWidth = 40;
        int brickHeight = 20;
        int brickGap = 5;
        int rows = 5;
        int cols = 10;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int brickX = j * (brickWidth + brickGap);
                int brickY = i * (brickHeight + brickGap);
                brickList.add(new Brick(brickX, brickY, brickWidth, brickHeight));
            }
        }
        return brickList;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        ball.draw(g);
        paddle.draw(g);

        for (Brick brick : bricks) {
            brick.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.update(getWidth(), getHeight());
        paddle.update(getWidth());
        checkCollisions();
        repaint();
    }

    private void checkCollisions() {
        // Check ball and paddle collision
        if (ball.getY() + ball.getDiameter() >= paddle.getY() &&
                ball.getX() + ball.getDiameter() >= paddle.getX() &&
                ball.getX() <= paddle.getX() + paddle.getWidth()) {
            ball.setYSpeed(-ball.getYSpeed());
        }

        // Check ball and brick collisions
        for (Brick brick : bricks) {
            if (brick.collidesWithBall(ball.getX(), ball.getY(), ball.getDiameter())) {
                brick.handleCollision();
                ball.setYSpeed(-ball.getYSpeed());
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        paddle.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Implement if needed
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Implement if needed
    }
}
