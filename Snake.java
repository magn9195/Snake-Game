import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Snake extends JPanel {
    private Point snakeCoord;
    private String direction;
    private LinkedList<Point> snakePos;

    public Snake() {
        this.snakeCoord = new Point(500, 500);
        this.direction = "down";
        this.snakePos = new LinkedList<>();
        this.snakePos.add(this.snakeCoord);
    }

    public void paintComponent(Graphics g) {
        for (Point point: this.snakePos) {
            g.setColor(Color.GREEN);
            g.fillRect(point.x, point.y, 100,100);
        }
    }

    public void moveRight() {
        if (this.snakeCoord.x < 900) {
            this.snakeCoord.x += 100;
        }
    }

    public void moveLeft() {
        if (this.snakeCoord.x > 0) {
            this.snakeCoord.x -= 100;
        }
    }

    public void moveUp() {
        if (this.snakeCoord.y > 0) {
            this.snakeCoord.y -= 100;
        }
    }

    public void moveDown() {
        if (this.snakeCoord.y < 900) {
            this.snakeCoord.y += 100;
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
        return this.snakePos.size();
    }

    public Point getSnakeCoord() {
        return this.snakeCoord;
    }

    private void updatePositionHistory() {
        this.snakePos.addFirst(new Point(this.snakeCoord));
        this.snakePos.removeLast();
    }

    public LinkedList<Point> getSnakePos() {
        return this.snakePos;
    }

    public boolean detectCollision() {
        if (this.snakePos.size() > 1) {
            Set<Point> tempSet = new HashSet<>(this.snakePos);
            return tempSet.size() < this.snakePos.size();
        }
        return false;
    }

    public void snakeGrow() {
        this.snakePos.addLast(new Point(this.snakeCoord));
    }
}