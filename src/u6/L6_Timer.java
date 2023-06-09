package u6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

// In lesson 3, we've created a program where
// we can control an object on the screen using the WASD keys

// However, the movement is NOT smooth. This is due to the fact
// that the program was created using a STATIc approach
// In this lesson, we're going to edit the same program, but using
// a DYNAMIC approach. This requires us to introduce a timer.
// also known as a thread

public class L6_Timer extends JPanel implements KeyListener, Runnable {

    public static BufferedImage character;

    // Class Variables
    // These are variables that can be accessed by ANY methods
    public static int xPos = 200;
    public static int yPos = 300;
    public static boolean wPressed = false;
    public static boolean aPressed = false;
    public static boolean sPressed = false;
    public static boolean dPressed = false;

    public L6_Timer() {
        setPreferredSize(new Dimension(500,500));
        setFocusable(true);
        addKeyListener(this);
        Thread t = new Thread(this);
        t.start();
    }

    // paintCOmponent is being called EVERY 0.02 seconds
    // due to our DYNAMIC approach
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the screen
        if (wPressed) yPos-=10;
        if (sPressed) yPos+=10;
        if (aPressed) xPos-=10;
        if (dPressed) xPos+=10;
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

        JFrame frame = new JFrame("Lesson 6 - Timer");
        L6_Timer panel = new L6_Timer();
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            wPressed = true;
        }
        else if (e.getKeyChar() == 's') {
            sPressed = true;
        }
        else if (e.getKeyChar() == 'd') {
            dPressed = true;
        }
        else if (e.getKeyChar() == 'a') {
            aPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            wPressed = false;
        }
        else if (e.getKeyChar() == 's') {
            sPressed = false;
        }
        else if (e.getKeyChar() == 'd') {
            dPressed = false;
        }
        else if (e.getKeyChar() == 'a') {
            aPressed = false;
        }
    }

    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(20);
            }
            catch (Exception e) {}
        }
    }

    // Useless Methods
    public void keyTyped(KeyEvent e) {}

}
