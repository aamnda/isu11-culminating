package u6;

import java.awt.*;
// import java.awt.event.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class L7_SpriteAnimation extends JPanel implements Runnable{

    // Class variables
    public static BufferedImage[] pikachu = new BufferedImage[4];
    public static int spriteNo = 0;

    // A frame controller is used to (often times) slow down
    // an animation. Especially if you do not want to change 
    // the animation every frame
    public static int frameController = 0; 
    public static int xPos = 200;
    public static int yPos = 300;

    public L7_SpriteAnimation() {
        setPreferredSize(new Dimension(500,500));
        setFocusable(true);
        Thread t = new Thread(this);
        t.start();
    }

    // paintCOmponent is being called EVERY 0.02 seconds (50 FPS)
    // due to our DYNAMIC approach
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the screen
        frameController++;
        g.drawImage(pikachu[spriteNo],xPos,yPos,null);
        
        if (frameController==4) {
            spriteNo = (spriteNo + 1)%4;
            frameController = 0;
        }
    }

    public static void main(String[] args) {

        // Image Importation
        try {
            pikachu[0] = ImageIO.read(new File("u6/assets/pikachu0.png"));
            pikachu[1] = ImageIO.read(new File("u6/assets/pikachu1.png"));
            pikachu[2] = ImageIO.read(new File("u6/assets/pikachu2.png"));
            pikachu[3] = ImageIO.read(new File("u6/assets/pikachu3.png"));
        }
        catch(Exception e) {
            System.out.println("Something wrong with the image!");
        }

        JFrame frame = new JFrame("L7 - Sprite Animation");
        L7_SpriteAnimation panel = new L7_SpriteAnimation();
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
    
}
