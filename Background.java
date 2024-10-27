import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i <= 1000; i+=100) {
            g.drawLine(i,0,i,1000);
            g.drawLine(0,i,1000,i);
        }
    }
}
