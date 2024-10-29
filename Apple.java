import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Apple extends JPanel {
    private int x;
    private int y;
    private Random random;

    public Apple() {
        this.random = new Random();
        this.x = this.random.nextInt(11 - 1) * 100;
        this.y = this.random.nextInt(11 - 1) * 100;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, 100, 100);
    }

    public Point getCoords() {
        return new Point(this.x,this.y);
    }

    public void updatePosition() {
        this.x = this.random.nextInt(11 - 1) * 100;
        this.y = this.random.nextInt(11 - 1) * 100;
    }

    public int getXCoord() {
        return this.x;
    }

    public int getYCoord() {
        return this.y;
    }

}
