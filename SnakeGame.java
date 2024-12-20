import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame extends JPanel implements KeyListener {
    private boolean gameRunning;
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
        this.gameRunning = true;
    }

    public void run() throws InterruptedException {
        setupScreen();
        runGame();
    }

    public void paintRepaint() {
        this.mainPanel.repaint();
    }

    public void runGame() throws InterruptedException {
        setUpSnake();
        while (gameRunning && snake.getLength() < 100) {
            paintRepaint();
            if (this.snake.getSnakeCoord().equals(this.apple.getAppleCoord())) {
                this.snake.snakeGrow();
                this.apple.updatePosition();
                int i = 0;
                while (i < this.snake.getSnakePos().size()) {
                    if (this.snake.getSnakePos().get(i) == this.apple.getCoords()) {
                        this.apple.updatePosition();
                        i = 0;
                    }
                    i++;
                }
            }
            this.snake.updatePosition();
            if (this.snake.detectCollision()) {
                break;
            }
            Thread.sleep(500);
        }
    }

    public void setUpSnake() {
        this.mainPanel.add(this.snake);
        this.mainPanel.add(this.apple);
        this.mainPanel.add(this.background);
    }

    public void setupScreen() {
        this.frame.setSize(this.width, this.height);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainPanel.setSize(this.width,this.height);
        this.mainPanel.setLayout(new OverlayLayout(this.mainPanel));
        this.frame.setContentPane(mainPanel);
        this.frame.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !this.keyPressed && !this.snake.getDirection().equals("left")) {
            this.snake.setDirection("right");
            this.keyPressed = true;
            paintRepaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && !this.keyPressed && !this.snake.getDirection().equals("right")) {
            this.snake.setDirection("left");
            this.keyPressed = true;
            paintRepaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && !this.keyPressed && !this.snake.getDirection().equals("up")) {
            this.snake.setDirection("down");
            this.keyPressed = true;
            paintRepaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP && !this.keyPressed && !this.snake.getDirection().equals("down")) {
            this.snake.setDirection("up");
            this.keyPressed = true;
            paintRepaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.keyPressed = false;
    }
}
