package u6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


public class L5_MouseListener extends JPanel implements MouseListener {

    // Class Variables
    // Images
    public static BufferedImage l5start;
    public static BufferedImage l5game;
    public static BufferedImage l5pause;
    public static BufferedImage l5go;

    // Game State Variable
    // GS 0: start screen
    // GS 1: game state
    // GS 2: pause screen
    // GS 3: game over screen
    public static int gamestate = 0;

    public L5_MouseListener() {
        // JPanel Default Settings
        setPreferredSize(new Dimension(300,600));
        setFocusable(true);
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gamestate==0) {
            g.drawImage(l5start,0,0,null);
        }
        else if (gamestate==1) {
            g.drawImage(l5game,0,0,null);
        }
        else if (gamestate==2) {
            g.drawImage(l5pause,0,0,null);
        }
        else if (gamestate==3) {
            g.drawImage(l5go,0,0,null);
        }
    }

    public static void main(String[] args) {
        // Image Importation
        try {
            l5start = ImageIO.read(new File("u6/assets/l5start.png"));
            l5game = ImageIO.read(new File("u6/assets/l5game.png"));
            l5pause = ImageIO.read(new File("u6/assets/l5pause.png"));
            l5go = ImageIO.read(new File("u6/assets/l5go.png"));
        }
        catch(Exception e) {
            System.out.println("Something wrong with the image!");
        }

        JFrame frame = new JFrame("Lesson 5");
        L5_MouseListener panel = new L5_MouseListener();
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }

    public void mousePressed(MouseEvent e) {
        if (gamestate == 0) {
            if (e.getX()<=200 && e.getX()>=100 && e.getY()>=500 && e.getY()<=550){
                gamestate=1;
                repaint();
            }
        }
        else if (gamestate == 1) {
            if (e.getX()<=200 && e.getX()>=100 && e.getY()>=500 && e.getY()<=550) {
                gamestate = 3;
                repaint( );
            }
        }
        else if (gamestate == 3) {
            gamestate = 0;
            repaint();
        }
    }

    public void mouseEntered(MouseEvent e) {
        if (gamestate == 2) {
            gamestate = 1;
            repaint();
        }
    }

    public void mouseExited(MouseEvent e) {
        if (gamestate == 1){
            gamestate = 2;
            repaint();
        }
    }

    // Useless methods
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    
}
