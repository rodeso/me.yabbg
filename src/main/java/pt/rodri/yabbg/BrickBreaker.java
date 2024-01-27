package pt.rodri.yabbg;
import javax.swing.JFrame;

public class BrickBreaker {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Brick Breaker Game");
        frame.setSize(400, 400);  // Set your preferred size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and add the game panel
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        // Set the frame visible
        frame.setVisible(true);

        // Focus the game panel to enable keyboard input
        gamePanel.requestFocus();
    }
}

