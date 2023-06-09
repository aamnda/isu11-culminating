package u6;

import java.awt.*;
import javax.swing.*;

public class L1_IntroToGraphics extends JPanel {

    // Change JPanel Settings
    public L1_IntroToGraphics() {
        // JPanel Default Settings
        setPreferredSize(new Dimension(600,480));
        setBackground(new Color(0,0,0));
    }

    public void paintComponent(Graphics g) { // no static
        super.paintComponent(g); // Clear screen
        
        g.setColor(new Color(100,50,100));
        g.drawLine(50,60,400,125);
       
        g.setColor(new Color(117,151,130));
        g.fillRect(40,240,260,120);

        g.setColor(new Color(64,81,222));
        g.fillOval(380,125,40,354);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Lesson 1");
        L1_IntroToGraphics panel = new L1_IntroToGraphics();
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();      

    }

}
