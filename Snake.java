import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Snake extends JPanel {
    private int x;
    private int y;
    private String direction;
    private LinkedList<Point> snakePos;
    private int length;

    public Snake() {
        this.x = 500;
        this.y = 500;
        this.length = 1;
        this.direction = "down";
        this.snakePos = new LinkedList<>();
        this.snakePos.add(new Point(this.x, this.y));
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

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return this.direction;
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

    public int getXCoord() {
        return this.x;
    }

    public int getYCoord() {
        return this.y;
    }

    private void updatePositionHistory() {
        this.snakePos.addFirst(new Point(this.x,this.y));
        this.snakePos.removeLast();
    }

    public LinkedList<Point> getSnakePos() {
        return this.snakePos;
    }

    public void snakeGrow() {
        this.snakePos.addLast(new Point(this.x,this.y));
    }
}