package u6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class L8_JumpingMotion extends JPanel implements KeyListener, MouseListener, Runnable {

    // Class Variables
    public static BufferedImage[] stateImages = new BufferedImage[3];
    public static BufferedImage[] trex = new BufferedImage[3];

    // Game State Variable
    // GS0: start screen
    // GS1: In Game state
    // GS2: Game Over Screen
    public static int gameState = 0;

    // Game Stats for T-Rex
    public static int posX = 100;
    public static int posY = 335;
    public static boolean isJumping = false;
    public static int spriteNo = 0;
    public static int gravity = 5;
    public static int velocity = -35;
    public static int frameController = 0;

    public L8_JumpingMotion() {
        // JPanel Default Settings
        setPreferredSize(new Dimension(500,500));
        // add MouseListener and KeyListener
        this.setFocusable(true);
        addMouseListener(this);
        addKeyListener(this);
        // Adding timer
        Thread t = new Thread(this);
        t.start();
    }

    // paintCOmponent is being called EVERY 0.02 seconds (50 FPS)
    // due to our DYNAMIC approach
    public void paintComponent(Graphics g) {
        // Draw T-Rex Running
        super.paintComponent(g); // Clear the screen

        g.drawImage(stateImages[gameState],0,0,null);

        if (!isJumping) {
            if (gameState == 1) {
                // Draw T-Rex
                g.drawImage(trex[spriteNo],posX,posY,null);
                frameController += 1;
                if (frameController == 5) {
                    spriteNo = (spriteNo + 1) % 2;
                    frameController = 0;
                }
            }
        }
        else if (isJumping) {
            g.drawImage(trex[2],posX,posY,null);
            posY+=velocity;
            velocity+=gravity;
            if (posY > 335) {
                isJumping = false;
                posY=335;
                velocity = -35;
                gravity = 5;
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        if (gameState == 0) {
            if (e.getX()>=150 && e.getX()<=350 && e.getY()>=400 && e.getY()<=450) gameState = 1;
        }
        else if (gameState == 2) {
            gameState = 0;
        }
    }

    public void keyPressed(KeyEvent e) {
        // I need a way to transition to the 
        // game over state, and we'll use the 'g'
        // way to do that
        if (gameState == 1) {
            if (e.getKeyChar() == 'g') {
                gameState = 2;
            }
            // If the user presses the spacebar during the 
            // game, we hve to make T-Rex jump
            if (e.getKeyChar() == ' ') {
                isJumping = true;
            }
        }
    }

    public static void main(String[] args) {

        // Image Importation
        try {
            stateImages[0] = ImageIO.read(new File("u6/assets/l8start.png"));
            stateImages[1] = ImageIO.read(new File("u6/assets/l8bg.png"));
            stateImages[2] = ImageIO.read(new File("u6/assets/l8gameover.png"));

            trex[0] = ImageIO.read(new File("u6/assets/trexleft.png"));
            trex[1] = ImageIO.read(new File("u6/assets/trexright.png"));
            trex[2] = ImageIO.read(new File("u6/assets/trexjump.png"));
        }

        catch(Exception e) {
            System.out.println("Something wrong with the image!");
        }

        JFrame frame = new JFrame("L8 - Jumping Motion");
        L8_JumpingMotion panel = new L8_JumpingMotion();
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
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
    public void keyReleased(KeyEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    
}
