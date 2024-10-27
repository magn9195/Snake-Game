import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame extends JPanel implements KeyListener {
    private final int height;
    private final int width;
    private boolean keyPressed;
    private JFrame frame;
    private Snake snake;
    private Apple apple;
    private Background background;
    private JPanel mainPanel;


    public SnakeGame() {
        this.height = 1040;
        this.width = 1015;
        this.frame = new JFrame("Snake Game");
        this.keyPressed = false;
        this.frame.addKeyListener(this);
        this.snake = new Snake();
        this.apple = new Apple();
        this.background = new Background();
        this.mainPanel = new JPanel(new BorderLayout());
    }

    public void run() {
        this.frame.setSize(this.width, this.height);
        this.frame.setResizable(false);
        //this.frame.setBackground(Color.MAGENTA);
        this.frame.getContentPane().setBackground(Color.BLUE);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainPanel.setSize(this.width,this.height);
        this.mainPanel.setLayout(new OverlayLayout(this.mainPanel));
        this.mainPanel.add(this.snake);
        this.mainPanel.add(this.apple);
        this.mainPanel.add(this.background);
        //this.mainPanel.setBackground(Color.GREEN);
        this.frame.setContentPane(mainPanel);
        this.frame.setVisible(true);
    }

    public void paintRepaint() {
        this.mainPanel.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !this.keyPressed) {
            this.snake.moveRight();
            this.keyPressed = true;
            paintRepaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && !this.keyPressed) {
            this.snake.moveLeft();
            this.keyPressed = true;
            paintRepaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && !this.keyPressed) {
            this.snake.moveDown();
            this.keyPressed = true;
            paintRepaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP && !this.keyPressed) {
            this.snake.moveUp();
            this.keyPressed = true;
            paintRepaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.keyPressed = false;
    }
}
