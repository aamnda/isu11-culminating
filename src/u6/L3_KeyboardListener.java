package u6;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class L3_KeyboardListener extends JPanel implements KeyListener{

    public static BufferedImage character;

    // Class Variables
    // These are variables that can be accessed by ANY methods
    public static int xPos = 200;
    public static int yPos = 300;

    public L3_KeyboardListener() {
        setPreferredSize(new Dimension(500,500));
        setFocusable(true);
        addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the screen
        g.drawImage(character,xPos,yPos,null);
    }

    public static void main(String[] args) {

        // Image Importation
        try {
            character = ImageIO.read(new File("u6/assets/img.png"));
        }
        catch(Exception e) {
            System.out.println("Something wrong with the image!");
        }

        JFrame frame = new JFrame("Lesson 3");
        L3_KeyboardListener panel = new L3_KeyboardListener();
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
        
    }

    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            yPos-=20;
            repaint();
        }
        else if (e.getKeyChar() == 's') {
            yPos+=20;
            repaint(); 
        }
        else if (e.getKeyChar() == 'd') {
            xPos+=20;
            repaint();
        }
        else if (e.getKeyChar() == 'a') {
            xPos-=20;
            repaint();
        }
    }

    // Useless Methods
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
