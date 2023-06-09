package u6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class forFun extends JPanel implements KeyListener, MouseListener, Runnable {

    // Global Variables
    public static int none = 0;

    public forFun() {
        setPreferredSize(new Dimension(700,400));
        
        this.setFocusable(true);
        addMouseListener(this);
        addKeyListener(this);

        // Timer
        Thread t = new Thread(this);
        t.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public static void main(String[] args) {

        try {
            
        }
        catch (Exception e) {
            System.out.println("Something wrong with the image!");
        }

        JFrame frame = new JFrame("Just For Fun");
        forFun panel = new forFun();
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }
    
    // MouseListener methods
    public void mousePressed(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }

    // KeyListener methods
    public void keyPressed(KeyEvent e) {
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
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
}
