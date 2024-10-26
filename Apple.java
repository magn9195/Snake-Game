import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Apple extends JPanel {
    private int x;
    private int y;
    private Random random;

    public Apple() {
        this.x = 0;
        this.y = 0;
        this.random = new Random();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, 100, 100);
    }

    public void updatePosition() {
        this.x = this.random.nextInt(11 - 1) * 100;
        this.y = this.random.nextInt(11 - 1) * 100;
    }

}
