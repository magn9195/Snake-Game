import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Apple extends JPanel {
    private Point appleCoord;
    private Random random;

    public Apple() {
        this.random = new Random();
        this.appleCoord = new Point(this.random.nextInt(11 - 1) * 100, this.random.nextInt(11 - 1) * 100);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(this.appleCoord.x, this.appleCoord.y, 100, 100);
    }

    public Point getCoords() {
        return this.appleCoord;
    }

    public void updatePosition() {
        this.appleCoord = new Point(this.random.nextInt(11 - 1) * 100, this.random.nextInt(11 - 1) * 100);
    }

    public Point getAppleCoord() {
        return this.appleCoord;
    }
}
