import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Snake extends JPanel {
    private int x;
    private int y;
    private String direction;
    Point[] snakePos;
    private int length;

    public Snake() {
        this.x = 500;
        this.y = 500;
        this.snakePos = new Point[length];
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

    private void updatePosition() {
        switch (direction) {
            case "right" -> moveRight();
            case "left" -> moveLeft();
            case "up" -> moveUp();
            case "down" -> moveDown();
        }
    }

    //
    private void updatePositionHistory() {
        if (this.length > this.snakePos.length) {
            Point[] tempArray = new Point[this.snakePos.length + 1];
            tempArray[0] = new Point(this.x, this.y);
            for (int i = 1; i <= tempArray.length; i++) {
                tempArray[i] = this.snakePos[i - 1];
            }
            this.snakePos = tempArray;
        } else {
            for (int i = 1; i <= this.snakePos.length; i++) {
                this.snakePos[i] = this.snakePos[i - 1];
            }
            this.snakePos[0] = new Point(this.x, this.y);
        }
    }

}
