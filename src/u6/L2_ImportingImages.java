package u6;
import java.awt.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class L2_ImportingImages extends JPanel {

    // Class Variables
    // These are variables that can be accessed by ANY methods
    public static BufferedImage background;

    public L2_ImportingImages() {
        setPreferredSize(new Dimension(700,360));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the screen
        g.drawImage(background,0,0,null);
    }

    public static void main(String[] args) {

        // Image Importation
        try {
            background = ImageIO.read(new File("u6/assets/background.jpg"));
        }
        catch(Exception e) {
            System.out.println("Something wrong with the image!");
        }

        JFrame frame = new JFrame("Lesson 2");
        L2_ImportingImages panel = new L2_ImportingImages();
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
        
    }
}
