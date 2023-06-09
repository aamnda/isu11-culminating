package u6;

// Importations
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class L9_CollisionDetection extends JPanel implements KeyListener, Runnable {
    public static BufferedImage ninja;
    public static BufferedImage skull;

    public static boolean wPressed = false;
    public static boolean aPressed = false;
    public static boolean sPressed = false;
    public static boolean dPressed = false;

    // Ninja Game Stats
    public static int ninjaX = 20;
    public static int ninjaY = 20;

    // Skull Game Stats
    public static int skull1X = 225;
    public static int skull1Y = 225;

    public L9_CollisionDetection() {
        setPreferredSize(new Dimension(500, 500));

        this.setFocusable(true);
        addKeyListener(this);

        Thread t = new Thread(this);
        t.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (wPressed) {
            ninjaY -= 5;
        }
        if (aPressed) {
            ninjaX -= 5;
        }
        if (sPressed) {
            ninjaY += 5;
        }
        if (dPressed) {
            ninjaX += 5;
        }

        // Check for Collision Detection
        // If ninja hits the skull, reset ninja back to
        // original position at (20, 20)

        // NOT Colliding - (x2 < l) || (x1 > r) || (y1 > d) || (y2 < u)
        // therefore, Colliding - !(x2 < l || x1 > r || y1 > d || y2 < u)

        if (!(ninjaX + 50 < skull1X || ninjaX > skull1X + 50 ||
                ninjaY > skull1Y + 50 || ninjaY + 50 < skull1Y)) {
            ninjaX = 20;
            ninjaY = 20;
        }

        g.drawImage(ninja, ninjaX, ninjaY, null);

        g.drawImage(skull, skull1X, skull1Y, null);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            wPressed = true;
        } else if (e.getKeyChar() == 'a') {
            aPressed = true;
        } else if (e.getKeyChar() == 's') {
            sPressed = true;
        } else if (e.getKeyChar() == 'd') {
            dPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            wPressed = false;
        } else if (e.getKeyChar() == 's') {
            sPressed = false;
        } else if (e.getKeyChar() == 'd') {
            dPressed = false;
        } else if (e.getKeyChar() == 'a') {
            aPressed = false;
        }
    }

    public static void main(String[] args) {
        try {
            ninja = ImageIO.read(new File("u6/assets/l9ninja.jpeg"));
            skull = ImageIO.read(new File("u6/assets/l9skull.png"));
        } catch (Exception e) {
            System.out.println("Something wrong with the image!");
        }

        JFrame frame = new JFrame("Lesson 9 - Collision Detection");
        L9_CollisionDetection panel = new L9_CollisionDetection();
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }

    public void run() {
        // 50 FPS
        while (true) {
            repaint();
            try {
                Thread.sleep(20);
            } catch (Exception e) {
            }
        }
    }

    // Useless Methods
    public void keyTyped(KeyEvent e) {
    }
}
