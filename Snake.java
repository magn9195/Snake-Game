import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;

public class Snake extends JPanel {
    private int x;
    private int y;

    public Snake() {
        this.x = 500;
        this.y = 500;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(this.x,this.y,100,100);
    }

    public void moveRight() {
        if (this.x < 900) {
            this.x += 100;

        }
    }

    public void moveLeft() {
        if (this.x > 0) {
            this.x -= 100;
        }
    }

    public void moveUp() {
        if (this.y > 0) {
            this.y -= 100;
        }
    }

    public void moveDown() {
        if (this.y < 900) {
            this.y += 100;
        }
    }

    //public void updateSnakePos() {
    //    this.coords[0].setLocation(this.x,this.y);
    //}
}
