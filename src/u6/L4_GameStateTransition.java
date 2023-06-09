package u6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class L4_GameStateTransition extends JPanel implements KeyListener{

    // Class Variables
    // Images
    public static BufferedImage credits;
    public static BufferedImage menu;
    public static BufferedImage game;
    public static BufferedImage win;
    public static BufferedImage lose;

    // Game  State Variable
    // GS 0: menu screen
    // GS 1: credit screen
    // GS 2: game state
    // GS 3: win screen
    // GS 4: lose screen
    public static int gamestate= 0;

    public L4_GameStateTransition() {
        setPreferredSize(new Dimension(500,500));

        // For KeyListener
        setFocusable(true); 
        addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gamestate == 0) {
            g.drawImage(menu,0,0,null);
        }
        else if (gamestate == 1) {
            g.drawImage(credits,0,0,null);
        }
        else if (gamestate == 2) {
            g.drawImage(game,0,0,null);
        }
        else if (gamestate == 3) {
            g.drawImage(win,0,0,null);
        }
        else if (gamestate == 4) {
            g.drawImage(lose,0,0,null);
        }
    }

    public static void main(String[] args) {

        try {
            menu = ImageIO.read(new File("u6/assets/menu.png"));
            credits = ImageIO.read(new File("u6/assets/credits.png"));
            game = ImageIO.read(new File("u6/assets/game.png"));
            win = ImageIO.read(new File("u6/assets/win.png"));
            lose = ImageIO.read(new File("u6/assets/lose.png"));
        }
        catch(Exception e) {
            System.out.println("Something wrong with the image!");
        }

        JFrame frame = new JFrame("Lesson 4");
        L4_GameStateTransition panel = new L4_GameStateTransition();
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
        
    }

    public void keyPressed(KeyEvent e) {
        if(gamestate == 0) {
            if (e.getKeyChar()=='s') {
                gamestate = 2;
                repaint();
            }
            else if (e.getKeyChar()=='c') {
                gamestate=1;
                repaint();
            }
        }
        else if (gamestate == 1) {
            if (e.getKeyChar()==' ') {
                gamestate=0;
                repaint();
            }
        }
        else if (gamestate == 2) {
            if (e.getKeyChar()=='w') {
                gamestate=3;
                repaint();
            }
            else if (e.getKeyChar()=='g') {
                gamestate=4;
                repaint();
            }
        }
        else if (gamestate == 3) {
            if (e.getKeyChar()==' ') {
                gamestate=0;
                repaint();
            }
        }
        else if (gamestate == 4) {
            if (e.getKeyChar()==' ') {
                gamestate=0;
                repaint();
            }
        }
    }

    // useless
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
