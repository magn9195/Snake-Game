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
        this.length = 1;
        this.direction = "down";
        this.snakePos = new Point[length];
        this.snakePos[0] = new Point(this.x,this.y);
    }

    public void paintComponent(Graphics g) {
        for (Point point: this.snakePos) {
            g.setColor(Color.GREEN);
            g.fillRect(point.x, point.y, 100,100);
        }
    }

    public void moveRight() {
        if (this.x < 900) {
            this.x += 100;
            if (this.snakePos.length > 1) {
                for (int i = 1; i < this.snakePos.length; i++) {
                    this.snakePos[i] = new Point(this.snakePos[i].x + 100,this.snakePos[i].y);
                }
            }
        }
    }

    public void moveLeft() {
        if (this.x > 0) {
            this.x -= 100;
            if (this.snakePos.length > 1) {
                for (int i = 1; i < this.snakePos.length; i++) {
                    this.snakePos[i] = new Point(this.snakePos[i].x - 100,this.snakePos[i].y);
                }
            }
        }
    }

    public void moveUp() {
        if (this.y > 0) {
            this.y -= 100;
            if (this.snakePos.length > 1) {
                for (int i = 1; i < this.snakePos.length; i++) {
                    this.snakePos[i] = new Point(this.snakePos[i].x,this.snakePos[i].y - 100);
                }
            }
        }
    }

    public void moveDown() {

        if (this.y < 900) {
            this.y += 100;
            if (this.snakePos.length > 1) {
                for (int i = 1; i < this.snakePos.length; i++) {
                    this.snakePos[i] = new Point(this.snakePos[i].x,this.snakePos[i].y + 100);
                }
            }

        }
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void updatePosition() {
        switch (direction) {
            case "right" -> moveRight();
            case "left" -> moveLeft();
            case "up" -> moveUp();
            case "down" -> moveDown();
        }
        updatePositionHistory();
    }

    public int getLength() {
        return this.length;
    }

    public void grow() {
        this.length += 1;
    }

    public int getXCoord() {
        return this.x;
    }

    public int getYCoord() {
        return this.y;
    }

    private void updatePositionHistory() {
        if (this.length > this.snakePos.length) {
            Point[] tempArray = new Point[this.snakePos.length + 1];
            tempArray[0] = new Point(this.x, this.y);
            System.arraycopy(this.snakePos, 0, tempArray, 1, this.snakePos.length);
            this.snakePos = tempArray;
        } else {
            if (this.length >= 2) {
                for (int i = 1; i<this.snakePos.length; i++) {
                    snakePos[i] = snakePos[i - 1];
                }
            }
            this.snakePos[0] = new Point(this.x, this.y);
        }
    }
}