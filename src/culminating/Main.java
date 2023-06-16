package culminating;

// RULES: USED WAD OR ARROW KEYS TO NAVIGATE UPWARDS IN THE INFINITE VERTICAL PLATFORMER
// ***** YOU CANNOT LAND BACK ON THE SAME PLATFORM AFTER JUMPING! 

// score for 2 players is dependent on BOTH PLAYERS! both players 
// must reach that score for it to be accumulated!


// importations
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Main extends JPanel implements KeyListener, Runnable {

    // Global Variables
    public static Random rand = new Random();

    public static int state = 0; // 0 - Menu
                                 // 1 - Credits
                                 // 2 - Rules
                                 // 3 - # of Players Selection
                                 // 4 - In-Game
                                 // 5 - Pause
                                 // 6 - Game Over

    // Sprite number variables
    public static int idleSpriteNo = 0;
    public static int runSpriteNo = 0;
    public static int waterSpriteNo = 0;

    public static int frameController = 0;
    public static int timer = 0;

    // background
    public static int bgyPos = -700;
    public static int moveUpFactor = 1;

    // land varaibles
    public static int landx;
    public static int landy;
    public static int[] landxCoords = new int[10];
    public static int[] landyCoords = { -150, -100, -50, 0, 50, 100, 150, 175, 200, 250 };

    //water variable
    public static int wavey = 200;

    // character platform indexs
    public static int dogPlatformIndex = -1;
    public static int catPlatformIndex = -1;

    // collision variiables
    public static boolean dogOnPlatform = false;
    public static boolean catOnPlatform = false;

    // dog positions
    public static int dogxPos = 320;
    public static int dogyPos = 240;
    public static int dogyPosOld = 240;

    // cat positions
    public static int catxPos = 360;
    public static int catyPos = 240;
    public static int catyPosOld = 240;

    // used for jumping (initial value doesn't matter)
    public static int dogOriginalyPos = 240;
    public static int catOriginalyPos = 240;

    // arrow positions
    public static int menuArrowxPos = 255;
    public static int menuArrowyPos = 80;

    public static int selectArrowxPos = 230;
    public static int selectArrowyPos = 80;

    public static int arrowState = 1;

    // twoPlayers
    public static boolean twoPlayers;

    // key listener
    public static boolean upPressed = false;
    public static boolean leftPressed = false;
    public static boolean rightPressed = false;

    public static boolean wPressed = false;
    public static boolean aPressed = false;
    public static boolean dPressed = false;

    public static boolean dogJumping = false;
    public static boolean catJumping = false;

    public static boolean dogLookLeft = false;
    public static boolean catLookLeft = false;

    // jumping variables
    public static int dogGravity = 3;
    public static int dogVelocity = -27;
    public static int catGravity = 3;
    public static int catVelocity = -27;

    public static int catFallGravity = 3;
    public static int catFallVelocity = 0;

    // score
    public static int score = 0;
    public static int score1 = 0;
    public static int score2 = 0;

    // Buffered Images
    public static BufferedImage[] stateImages = new BufferedImage[7];

    public static BufferedImage land;

    public static BufferedImage[] dogIdle = new BufferedImage[4];
    public static BufferedImage[] dogIdlel = new BufferedImage[4];
    public static BufferedImage[] dogRun = new BufferedImage[6];
    public static BufferedImage[] dogRunl = new BufferedImage[6];

    public static BufferedImage[] catIdle = new BufferedImage[4];
    public static BufferedImage[] catIdlel = new BufferedImage[4];
    public static BufferedImage[] catRun = new BufferedImage[6];
    public static BufferedImage[] catRunl = new BufferedImage[6];

    public static BufferedImage[] water = new BufferedImage[3];

    public static BufferedImage arrow;

    // import audio
    public static String music = "culminating/assets/music.wav";
    public static String gameOver = "culminating/assets/gameOver.wav";
    public static String soundEffect2 = "culminating/assets/soundEffect2.wav";


    // method that gets the highscore through text file streaming
    public static int getNewHighScore(int score, String txtFileName) {
        try {
            Scanner inputFile = new Scanner(new File("culminating/" + txtFileName));
            int highscore = Integer.parseInt(inputFile.next());

            inputFile.close();
            PrintWriter outputFile;

            if (score > highscore) {
                highscore = score;
                outputFile = new PrintWriter(new FileWriter("culminating/" + txtFileName));
                outputFile.print(highscore);
                outputFile.close();
            }
            return highscore;
        } catch (Exception e) {
            return 0;
        }
    }

    // platform(s) generation
    public Main() {
        // JPanel default settings
        setPreferredSize(new Dimension(700, 360));

        // Add KeyListener
        this.setFocusable(true);
        addKeyListener(this);

        // Timer
        Thread t = new Thread(this);
        t.start();
    }

    // Graphics
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Clears the screen
        g.drawImage(stateImages[state], 0, 0, null);

        Font font = new Font("Press Start 2P", Font.PLAIN, 25);
        g.setFont(font);
        g.setColor(Color.WHITE);
        

        if (state == 0 || state == 3) {

            // VARIABLE RESET (for pause -> menu -> game)
            dogxPos = 320;
            dogyPos = catyPos = dogyPosOld = catyPosOld = 240;
            catxPos = 360;
            bgyPos = -700;
            moveUpFactor = 2;
            wavey = 200;

            rightPressed = leftPressed = dogJumping = wPressed = aPressed = dPressed = catJumping = twoPlayers = dogOnPlatform = catOnPlatform = false;
            dogGravity = catVelocity = 3;
            dogVelocity = catVelocity = -27;

            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0)
                    landx = rand.nextInt(300, 600);
                else if (i % 2 != 0)
                    landx = rand.nextInt(0, 300);
                landxCoords[i] = landx;
            }
            score = 0;

            landyCoords[0] = -150;
            landyCoords[1] = -100;
            landyCoords[2] = -50;
            landyCoords[3] = 0;
            landyCoords[4] = 50;
            landyCoords[5] = 100;
            landyCoords[6] = 150;
            landyCoords[7] = 175;
            landyCoords[8] = 200;
            landyCoords[9] = 250;

            frameController++;
            g.drawImage(dogIdle[idleSpriteNo], 320, 240, null);

            if (frameController == 4) {
                idleSpriteNo = (idleSpriteNo + 1) % 4;
                frameController = 0;
            }
            if (state == 0)
                g.drawImage(arrow, menuArrowxPos, menuArrowyPos, null);
            else
                g.drawImage(arrow, selectArrowxPos, selectArrowyPos, null);
        }

        // inGame
        if (state == 4) {

            dogyPosOld = dogyPos;
            catyPosOld = catyPos;

            g.drawImage(stateImages[state], 0, bgyPos, null); // sky

            // if dog or cat is on platform, the game will begin: the background 
            // will start rising and so will the water.

            if (dogOnPlatform || catOnPlatform) {
                if (bgyPos < 0) { // used to accumulate y pos of land and bg
                    // System.out.println(bgyPos);
                    // bgyPos += bgMoveUpFactor;
                    // bgMoveUpFactor += 0.005;
                    bgyPos += moveUpFactor;

                    dogyPos += moveUpFactor;
                    catyPos += moveUpFactor;

                    for (int i = 0; i < 10; i++) {
                        landyCoords[i] += moveUpFactor;
                    }

                    dogOriginalyPos += moveUpFactor; // for jumping back on platform
                    catOriginalyPos += moveUpFactor;

                    if (!twoPlayers) {
                        while (dogyPos + 30 < 0) {
                            // bgyPos += bgMoveUpFactor;
                            // bgMoveUpFactor += 0.005;
                            bgyPos += moveUpFactor;

                            dogyPos += moveUpFactor;
                            catyPos += moveUpFactor;

                            for (int i = 0; i < 10; i++) {
                                landyCoords[i] += moveUpFactor;
                            }

                            dogOriginalyPos += moveUpFactor; // for jumping back on platform
                            catOriginalyPos += moveUpFactor;
                        }
                    }

                    if (wavey > 140) {
                        wavey -= 2;
                    } else
                        wavey = 140;

                } else {
                    bgyPos = -245;
                    timer += 1;
                    if (timer % 5 == 0)
                        moveUpFactor += 1;
                }
            }

            frameController++;

            if (frameController == 4) { // for sprites
                idleSpriteNo = (idleSpriteNo + 1) % 4;
                runSpriteNo = (runSpriteNo + 1) % 6;
                waterSpriteNo = (waterSpriteNo + 1) % 3;
                frameController = 0;
            }

            
            // Generating new platforms
            for (int i = 0; i < 10; i++) {
                if (landyCoords[i] > 360) { // generate new blocks if old one disappears
                    if (i % 2 == 0)
                        landx = rand.nextInt(300, 600);
                    else if (i % 2 != 0)
                        landx = rand.nextInt(0, 300);

                    landxCoords[i] = landx;
                    landyCoords[i] = -10;
                }

                g.drawImage(land, landxCoords[i], landyCoords[i], null); // print platforms
            }

            // display score
            g.drawString(Integer.toString(score), 20, 50);

            // one player movement, collision detection and sprites
            if (!twoPlayers) {
                // for movement
                if (dogJumping || rightPressed || leftPressed) {
                    if (rightPressed) {
                        dogLookLeft = false;
                        dogxPos += 10;

                        // fall off platform
                        if (dogOnPlatform && !dogJumping) {
                            if (dogxPos > landxCoords[dogPlatformIndex] + 60) {
                                dogJumping = true;

                                dogVelocity = 0;
                                dogGravity = 3;

                                dogOriginalyPos = 500;
                            }
                        }

                    }

                    if (leftPressed) {
                        dogxPos -= 10;
                        dogLookLeft = true;

                        // IF DOG WLAKS OFF PLATFORM
                        if (dogOnPlatform && !dogJumping) {
                            if (dogxPos <= landxCoords[dogPlatformIndex] - 30) {
                                dogJumping = true;

                                dogVelocity = 0;
                                dogGravity = 3;

                                dogOriginalyPos = 500;
                            }
                        }
                    }

                    if (dogLookLeft) {
                        if (dogJumping) {
                            g.drawImage(dogIdlel[idleSpriteNo], dogxPos, dogyPos, null);
                            dogyPos += dogVelocity;
                            dogVelocity += dogGravity;

                            if (dogOnPlatform) {
                                dogOriginalyPos = 500;
                                dogJumping = true;
                            }

                            // COLLISION (it works! :))
                            if (dogVelocity >= 0) { // if jumping down

                                for (int i = 0; i < 10; i++) {
                                    if (dogxPos >= landxCoords[i] - 30 && dogxPos <= landxCoords[i] + 60) {

                                        if (dogyPos + 70 > landyCoords[i] && dogyPos < landyCoords[i] &&
                                                Math.abs(dogyPos + 70 - landyCoords[i]) < 30) {
                                            dogOriginalyPos = landyCoords[i] - 70;
                                            dogJumping = false;

                                            dogPlatformIndex = i;
                                            dogOnPlatform = true;

                                        }
                                    }
                                }

                            }

                            if (dogyPos > dogOriginalyPos) { // for landing
                                dogJumping = false;
                                dogyPos = dogOriginalyPos; // depends on y value of platform dog stands on

                                dogVelocity = -27;
                                dogGravity = 3;
                            }

                        } else {
                            g.drawImage(dogRunl[runSpriteNo], dogxPos, dogyPos, null);
                        }

                    } else if (!dogLookLeft) {
                        if (dogJumping) {
                            g.drawImage(dogIdle[idleSpriteNo], dogxPos, dogyPos, null);
                            dogyPos += dogVelocity;
                            dogVelocity += dogGravity;

                            if (dogOnPlatform) {
                                dogOriginalyPos = 500;
                                dogJumping = true;
                            }

                            // COLLISION (it works! :))
                            if (dogVelocity >= 0) { // if jumping down
                                for (int i = 0; i < 10; i++) {
                                    if (dogxPos >= landxCoords[i] - 30 && dogxPos <= landxCoords[i] + 60) {
                                        if (dogyPos + 70 > landyCoords[i] && dogyPos < landyCoords[i] &&
                                                Math.abs(dogyPos + 70 - landyCoords[i]) < 30) {
                                            dogOriginalyPos = landyCoords[i] - 70;

                                            dogJumping = false;

                                            dogPlatformIndex = i;
                                            dogOnPlatform = true;

                                        }
                                    }
                                }
                            }
                            if (dogyPos > dogOriginalyPos) {
                                dogJumping = false;
                                dogyPos = dogOriginalyPos; // depends on y value of platform dog stands on

                                dogVelocity = -27;
                                dogGravity = 3;

                            }
                        } else {
                            g.drawImage(dogRun[runSpriteNo], dogxPos, dogyPos, null);
                        }
                    }

                }

                // if nothing is pressed
                else {
                    // idle animation
                    if (dogLookLeft)
                        g.drawImage(dogIdlel[idleSpriteNo], dogxPos, dogyPos, null);
                    else if (!dogLookLeft)
                        g.drawImage(dogIdle[idleSpriteNo], dogxPos, dogyPos, null);
                }

                if (dogyPos < dogyPosOld) {
                    score += dogyPosOld - dogyPos;
                    // System.out.println(score);
                }

                if (dogOnPlatform || catOnPlatform)
                    g.drawImage(water[waterSpriteNo], 0, wavey, null);

                if (dogyPos >= 270) {
                    state = 6;
                    PlayMusic(gameOver);
                    //clip.stop();
                }

            }

            // two players movement, collision detection and sprites
            else {
                // for movement
                if (dogJumping || rightPressed || leftPressed) {
                    if (rightPressed) {
                        dogLookLeft = false;
                        dogxPos += 10;

                        // fall off platform
                        if (dogOnPlatform && !dogJumping) {
                            if (dogxPos > landxCoords[dogPlatformIndex] + 60) {
                                dogJumping = true;

                                dogVelocity = 0;
                                dogGravity = 3;

                                dogOriginalyPos = 500;
                            }
                        }
                    }

                    if (leftPressed) {
                        dogxPos -= 10;
                        dogLookLeft = true;

                        // IF DOG WLAKS OFF PLATFORM
                        if (dogOnPlatform && !dogJumping) {
                            if (dogxPos <= landxCoords[dogPlatformIndex] - 30) {
                                dogJumping = true;

                                dogVelocity = 0;
                                dogGravity = 3;

                                dogOriginalyPos = 500;
                            }
                        }
                    }

                    if (dogLookLeft == true) {
                        if (dogJumping) {
                            g.drawImage(dogIdlel[idleSpriteNo], dogxPos, dogyPos, null);
                            dogyPos += dogVelocity;
                            dogVelocity += dogGravity;

                            if (dogOnPlatform) {
                                dogOriginalyPos = 500;
                                dogJumping = true;
                            }

                            // COLLISION (it works! :))
                            if (dogVelocity >= 0) { // if jumping down

                                for (int i = 0; i < 10; i++) {
                                    if (dogxPos >= landxCoords[i] - 30 && dogxPos <= landxCoords[i] + 60) {

                                        if (dogyPos + 70 > landyCoords[i] && dogyPos < landyCoords[i] &&
                                                Math.abs(dogyPos + 70 - landyCoords[i]) < 30) {
                                            dogOriginalyPos = landyCoords[i] - 70;
                                            dogJumping = false;

                                            dogPlatformIndex = i;
                                            dogOnPlatform = true;

                                        }
                                    }
                                }

                            }

                            if (dogyPos > dogOriginalyPos) {
                                dogJumping = false;
                                dogyPos = dogOriginalyPos; // depends on y value of platform dog stands on

                                dogVelocity = -27;
                                dogGravity = 3;
                            }
                        } else {
                            g.drawImage(dogRunl[runSpriteNo], dogxPos, dogyPos, null);
                        }
                    } else if (!dogLookLeft) {
                        if (dogJumping) {
                            g.drawImage(dogIdle[idleSpriteNo], dogxPos, dogyPos, null);
                            dogyPos += dogVelocity;
                            dogVelocity += dogGravity;

                            if (dogOnPlatform) {
                                dogOriginalyPos = 500;
                                dogJumping = true;
                            }

                            // COLLISION (it works! :))
                            if (dogVelocity >= 0) { // if jumping down
                                for (int i = 0; i < 10; i++) {
                                    if (dogxPos >= landxCoords[i] - 30 && dogxPos <= landxCoords[i] + 60) {
                                        if (dogyPos + 70 > landyCoords[i] && dogyPos < landyCoords[i] &&
                                                Math.abs(dogyPos + 70 - landyCoords[i]) < 30) {
                                            dogOriginalyPos = landyCoords[i] - 70;

                                            dogJumping = false;

                                            dogPlatformIndex = i;
                                            dogOnPlatform = true;

                                        }
                                    }
                                }
                            }

                            if (dogyPos > dogOriginalyPos) {
                                dogJumping = false;
                                dogyPos = dogOriginalyPos; // depends on y value of platform dog stands on

                                dogVelocity = -27;
                                dogGravity = 3;

                            }
                        } else {
                            g.drawImage(dogRun[runSpriteNo], dogxPos, dogyPos, null);
                        }
                    }
                } else {
                    if (dogLookLeft)
                        g.drawImage(dogIdlel[idleSpriteNo], dogxPos, dogyPos, null);
                    else if (!dogLookLeft)
                        g.drawImage(dogIdle[idleSpriteNo], dogxPos, dogyPos, null);
                }

                if (catJumping || dPressed || aPressed) {
                    if (dPressed) {
                        catLookLeft = false;
                        catxPos += 10;

                        // fall off platform
                        if (catOnPlatform && !catJumping) {
                            if (catxPos > landxCoords[catPlatformIndex] + 60) {
                                catJumping = true;

                                catVelocity = 0;
                                catGravity = 3;

                                catOriginalyPos = 500;
                            }
                        }
                    }
                    if (aPressed) {
                        catLookLeft = true;
                        catxPos -= 10;

                        // IF DOG WLAKS OFF PLATFORM
                        if (catOnPlatform && !catJumping) {
                            if (catxPos <= landxCoords[catPlatformIndex] - 30) {
                                catJumping = true;

                                catVelocity = 0;
                                catGravity = 3;

                                catOriginalyPos = 500;
                            }
                        }
                    }

                    if (catLookLeft) {
                        if (catJumping) {
                            g.drawImage(catIdlel[idleSpriteNo], catxPos, catyPos, null);
                            catyPos += catVelocity;
                            catVelocity += catGravity;

                            if (catOnPlatform) {
                                catOriginalyPos = 500;
                                catJumping = true;
                            }

                            // COLLISION (it works! :))
                            if (catVelocity >= 0) { // if jumping down

                                for (int i = 0; i < 10; i++) {
                                    if (catxPos >= landxCoords[i] - 30 && catxPos <= landxCoords[i] + 60) {

                                        if (catyPos + 70 > landyCoords[i] && catyPos < landyCoords[i] &&
                                                Math.abs(catyPos + 70 - landyCoords[i]) < 30) {
                                            catOriginalyPos = landyCoords[i] - 70;
                                            catJumping = false;

                                            catPlatformIndex = i;
                                            catOnPlatform = true;

                                        }
                                    }
                                }

                            }

                            if (catyPos > catOriginalyPos) {
                                catJumping = false;
                                catyPos = catOriginalyPos; // depends on y value of platform cat stands on

                                catVelocity = -27;
                                catGravity = 3;
                            }

                        } else {
                            g.drawImage(catRunl[runSpriteNo], catxPos, catyPos, null);
                        }
                    } else if (!catLookLeft) {
                        if (catJumping) {
                            g.drawImage(catIdle[idleSpriteNo], catxPos, catyPos, null);
                            catyPos += catVelocity;
                            catVelocity += catGravity;

                            if (catOnPlatform) {
                                catOriginalyPos = 500;
                                catJumping = true;
                            }

                            // COLLISION (it works! :))
                            if (catVelocity >= 0) { // if jumping down
                                for (int i = 0; i < 10; i++) {
                                    if (catxPos >= landxCoords[i] - 30 && catxPos <= landxCoords[i] + 60) {
                                        if (catyPos + 70 > landyCoords[i] && catyPos < landyCoords[i]
                                                && Math.abs(catyPos + 70 - landyCoords[i]) < 30) {
                                            catOriginalyPos = landyCoords[i] - 70;
                                            catJumping = false;

                                            catPlatformIndex = i;
                                            catOnPlatform = true;
                                        }
                                    }
                                }
                            }

                            if (catyPos > catOriginalyPos) {
                                catJumping = false;
                                catyPos = catOriginalyPos; // depends on y value of platform cat stands on

                                catVelocity = -27;
                                catGravity = 3;
                            }
                        } else {
                            g.drawImage(catRun[runSpriteNo], catxPos, catyPos, null);
                        }
                    }

                } else {
                    if (catLookLeft)
                        g.drawImage(catIdlel[idleSpriteNo], catxPos, catyPos, null);
                    else if (!catLookLeft)
                        g.drawImage(catIdle[idleSpriteNo], catxPos, catyPos, null);
                }

                // gaining score
                if (dogyPos < dogyPosOld && dogyPos >= catyPos) {
                    score += dogyPosOld - dogyPos;
                    System.out.println(score);
                } else if (catyPos < catyPosOld && catyPos >= dogyPos) {
                    score += catyPosOld - catyPos;
                    System.out.println(score);
                }

                if (dogOnPlatform || catOnPlatform)
                    g.drawImage(water[waterSpriteNo], 0, wavey, null);

                if (dogyPos >= 270 || catyPos >= 270) {
                    state = 6;
                    PlayMusic(gameOver);
                }
            }
        }

        // game over
        if (state == 6)

        {
            // VARIABLE RESET
            dogxPos = 320;
            dogyPos = catyPos = dogyPosOld = catyPosOld = 240;
            catxPos = 360;
            bgyPos = -700;
            moveUpFactor = 2;

            wavey = 200;

            rightPressed = leftPressed = dogJumping = wPressed = aPressed = dPressed = catJumping = dogOnPlatform = catOnPlatform = false;
            dogGravity = catVelocity = 3;
            dogVelocity = catVelocity = -27;

            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0)
                    landx = rand.nextInt(300, 600);
                else if (i % 2 != 0)
                    landx = rand.nextInt(0, 300);
                landxCoords[i] = landx;
            }

            landyCoords[0] = -150;
            landyCoords[1] = -100;
            landyCoords[2] = -50;
            landyCoords[3] = 0;
            landyCoords[4] = 50;
            landyCoords[5] = 100;
            landyCoords[6] = 150;
            landyCoords[7] = 175;
            landyCoords[8] = 200;
            landyCoords[9] = 250;

            // display score and highscore
            if (!twoPlayers) {
                g.drawString("score: " + Integer.toString(score), 220, 150);
                g.drawString("highscore: " + Integer.toString(getNewHighScore(score, "score1.txt")), 170, 180);
            } else {
                g.drawString("score: " + Integer.toString(score), 220, 150);
                g.drawString("highscore: " + Integer.toString(getNewHighScore(score, "score2.txt")), 170, 180);
            }
        }
    }

    public void keyPressed(KeyEvent e) {

        if (state == 0) {
            // down arrow
            if (e.getKeyCode() == KeyEvent.VK_DOWN && arrowState == 1) {
                menuArrowxPos = 260;
                menuArrowyPos = 105;
                arrowState = 2;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && arrowState == 2) {
                menuArrowxPos = 240;
                menuArrowyPos = 130;
                arrowState = 3;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && arrowState == 3) {
                menuArrowxPos = 255;
                menuArrowyPos = 80;
                arrowState = 1;
            }

            // up arrow
            else if (e.getKeyCode() == KeyEvent.VK_UP && arrowState == 3) {
                menuArrowxPos = 260;
                menuArrowyPos = 105;
                arrowState = 2;
            } else if (e.getKeyCode() == KeyEvent.VK_UP && arrowState == 2) {
                menuArrowxPos = 255;
                menuArrowyPos = 80;
                arrowState = 1;
            } else if (e.getKeyCode() == KeyEvent.VK_UP && arrowState == 1) {
                menuArrowxPos = 240;
                menuArrowyPos = 130;
                arrowState = 3;
            }

            else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (arrowState == 1) {
                    state = 3; // Select num of players

                    selectArrowxPos = 230;
                    selectArrowyPos = 80;
                    arrowState = 1;
                } else if (arrowState == 2)
                    state = 2;
                else if (arrowState == 3) {
                    state = 1;
                }
            }
        }

        else if (state == 1) { // credits
            if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                state = 0; // return to menu
            }
        }

        else if (state == 2) { // rules
            if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                state = 0; // return to menu
            }
        }

        else if (state == 3) { // select # of players

            // down arrow
            if (e.getKeyCode() == KeyEvent.VK_DOWN && arrowState == 1) {
                selectArrowxPos = 220;
                selectArrowyPos = 105;
                arrowState = 2;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && arrowState == 2) {
                selectArrowxPos = 240;
                selectArrowyPos = 130;
                arrowState = 3;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && arrowState == 3) {
                selectArrowxPos = 230;
                selectArrowyPos = 80;
                arrowState = 1;
            }

            // up arrow
            else if (e.getKeyCode() == KeyEvent.VK_UP && arrowState == 3) {
                selectArrowxPos = 220;
                selectArrowyPos = 105;
                arrowState = 2;
            } else if (e.getKeyCode() == KeyEvent.VK_UP && arrowState == 2) {
                selectArrowxPos = 230;
                selectArrowyPos = 80;
                arrowState = 1;
            } else if (e.getKeyCode() == KeyEvent.VK_UP && arrowState == 1) {
                selectArrowxPos = 240;
                selectArrowyPos = 130;
                arrowState = 3;
            }

            else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (arrowState == 1) {
                    state = 4; // 1 PLAYER
                } else if (arrowState == 2) {
                    state = 4; // 2 PLAYERS
                    twoPlayers = true;
                    dogxPos = 280;
                } else if (arrowState == 3) {
                    state = 0;

                    menuArrowxPos = 255;
                    menuArrowyPos = 80;
                    arrowState = 1;
                }
            }
        }

        else if (state == 4) { // in-game

            if (e.getKeyCode() == 27) {
                state = 5; // pause
            } else if (e.getKeyChar() == 'g') {
                // state = 6; // game over
                // only for transitions
            }

            // for movement
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (!dogJumping) {
                    dogOriginalyPos = dogyPos;
                    dogJumping = true;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                leftPressed = true;
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                rightPressed = true;

            if (twoPlayers) {
                if (e.getKeyChar() == 'w') {
                    if (!catJumping) {
                        catOriginalyPos = catyPos;
                        catJumping = true;
                    }
                }
                if (e.getKeyChar() == 'a')
                    aPressed = true;
                if (e.getKeyChar() == 'd')
                    dPressed = true;
            }
        }

        else if (state == 5) { // pause
            if (e.getKeyChar() == 'r') {
                // VARIABLE RESET
                dogxPos = 320;
                dogyPos = catyPos = dogyPosOld = catyPosOld = 240;
                catxPos = 360;
                bgyPos = -700;
                moveUpFactor = 2;

                rightPressed = leftPressed = dogJumping = wPressed = aPressed = dPressed = catJumping = dogOnPlatform = catOnPlatform = false;
                dogGravity = catVelocity = 3;
                dogVelocity = catVelocity = -27;
                score = 0;

                wavey = 200;

                for (int i = 0; i < 10; i++) {
                    if (i % 2 == 0)
                        landx = rand.nextInt(300, 600);
                    else if (i % 2 != 0)
                        landx = rand.nextInt(0, 300);
                    landxCoords[i] = landx;
                }

                landyCoords[0] = -150;
                landyCoords[1] = -100;
                landyCoords[2] = -50;
                landyCoords[3] = 0;
                landyCoords[4] = 50;
                landyCoords[5] = 100;
                landyCoords[6] = 150;
                landyCoords[7] = 175;
                landyCoords[8] = 200;
                landyCoords[9] = 250;

                state = 4;
            }

            else if (e.getKeyChar() == ' ') {
                state = 4; // resume game
            }

            else if (e.getKeyChar() == 'm') {
                state = 0; // return to menu

                menuArrowxPos = 255;
                menuArrowyPos = 80;
                arrowState = 1;
            }
        }

        else if (state == 6) { // game over
            // reset all game variables here

            if (e.getKeyChar() == ' ') {
                state = 4; // restart
                score = 0;
            }

            else if (e.getKeyChar() == 'm') {
                state = 0; // return to menu

                menuArrowxPos = 255;
                menuArrowyPos = 80;
                arrowState = 1;
            }

        }

    }

    public void keyReleased(KeyEvent e) {
        if (state == 4) {
            if (e.getKeyCode() == KeyEvent.VK_UP)
                upPressed = false;
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                leftPressed = false;
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                rightPressed = false;

            if (twoPlayers) {
                if (e.getKeyChar() == 'w')
                    wPressed = false;
                if (e.getKeyChar() == 'a')
                    aPressed = false;
                if (e.getKeyChar() == 'd')
                    dPressed = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // Scanner inputFile = new Scanner(new File("culminating/hi.txt"));
        PrintWriter OutputFile = new PrintWriter(new FileWriter("culminating/score.txt"));

        LoopMusic(music);


        try {
            stateImages[0] = ImageIO.read(new File("culminating/assets/0menu.png"));
            stateImages[1] = ImageIO.read(new File("culminating/assets/1credits.png"));
            stateImages[2] = ImageIO.read(new File("culminating/assets/2rules.png"));
            stateImages[3] = ImageIO.read(new File("culminating/assets/3selectNumOfPlayers.png"));
            stateImages[4] = ImageIO.read(new File("culminating/assets/4inGame.png"));
            stateImages[5] = ImageIO.read(new File("culminating/assets/5pause.png"));
            stateImages[6] = ImageIO.read(new File("culminating/assets/6gameOver.png"));

            arrow = ImageIO.read(new File("culminating/assets/arrow.png"));
            land = ImageIO.read(new File("culminating/assets/land.png"));

            // dog sprites
            dogIdle[0] = ImageIO.read(new File("culminating/assets/sprites/dog/dogIdle0.png"));
            dogIdle[1] = ImageIO.read(new File("culminating/assets/sprites/dog/dogIdle1.png"));
            dogIdle[2] = ImageIO.read(new File("culminating/assets/sprites/dog/dogIdle2.png"));
            dogIdle[3] = ImageIO.read(new File("culminating/assets/sprites/dog/dogIdle3.png"));

            dogRun[0] = ImageIO.read(new File("culminating/assets/sprites/dog/dogRun0.png"));
            dogRun[1] = ImageIO.read(new File("culminating/assets/sprites/dog/dogRun1.png"));
            dogRun[2] = ImageIO.read(new File("culminating/assets/sprites/dog/dogRun2.png"));
            dogRun[3] = ImageIO.read(new File("culminating/assets/sprites/dog/dogRun3.png"));
            dogRun[4] = ImageIO.read(new File("culminating/assets/sprites/dog/dogRun4.png"));
            dogRun[5] = ImageIO.read(new File("culminating/assets/sprites/dog/dogRun5.png"));

            dogIdlel[0] = ImageIO.read(new File("culminating/assets/sprites/dog/flipped/dogIdle0l.png"));
            dogIdlel[1] = ImageIO.read(new File("culminating/assets/sprites/dog/flipped/dogIdle1l.png"));
            dogIdlel[2] = ImageIO.read(new File("culminating/assets/sprites/dog/flipped/dogIdle2l.png"));
            dogIdlel[3] = ImageIO.read(new File("culminating/assets/sprites/dog/flipped/dogIdle3l.png"));

            dogRunl[0] = ImageIO.read(new File("culminating/assets/sprites/dog/flipped/dogRun0l.png"));
            dogRunl[1] = ImageIO.read(new File("culminating/assets/sprites/dog/flipped/dogRun1l.png"));
            dogRunl[2] = ImageIO.read(new File("culminating/assets/sprites/dog/flipped/dogRun2l.png"));
            dogRunl[3] = ImageIO.read(new File("culminating/assets/sprites/dog/flipped/dogRun3l.png"));
            dogRunl[4] = ImageIO.read(new File("culminating/assets/sprites/dog/flipped/dogRun4l.png"));
            dogRunl[5] = ImageIO.read(new File("culminating/assets/sprites/dog/flipped/dogRun5l.png"));

            // cat sprites
            catIdle[0] = ImageIO.read(new File("culminating/assets/sprites/cat/catIdle0.png"));
            catIdle[1] = ImageIO.read(new File("culminating/assets/sprites/cat/catIdle1.png"));
            catIdle[2] = ImageIO.read(new File("culminating/assets/sprites/cat/catIdle2.png"));
            catIdle[3] = ImageIO.read(new File("culminating/assets/sprites/cat/catIdle3.png"));

            catRun[0] = ImageIO.read(new File("culminating/assets/sprites/cat/catRun0.png"));
            catRun[1] = ImageIO.read(new File("culminating/assets/sprites/cat/catRun1.png"));
            catRun[2] = ImageIO.read(new File("culminating/assets/sprites/cat/catRun2.png"));
            catRun[3] = ImageIO.read(new File("culminating/assets/sprites/cat/catRun3.png"));
            catRun[4] = ImageIO.read(new File("culminating/assets/sprites/cat/catRun4.png"));
            catRun[5] = ImageIO.read(new File("culminating/assets/sprites/cat/catRun5.png"));

            catIdlel[0] = ImageIO.read(new File("culminating/assets/sprites/cat/flipped/catIdle0l.png"));
            catIdlel[1] = ImageIO.read(new File("culminating/assets/sprites/cat/flipped/catIdle1l.png"));
            catIdlel[2] = ImageIO.read(new File("culminating/assets/sprites/cat/flipped/catIdle2l.png"));
            catIdlel[3] = ImageIO.read(new File("culminating/assets/sprites/cat/flipped/catIdle3l.png"));

            catRunl[0] = ImageIO.read(new File("culminating/assets/sprites/cat/flipped/catRun0l.png"));
            catRunl[1] = ImageIO.read(new File("culminating/assets/sprites/cat/flipped/catRun1l.png"));
            catRunl[2] = ImageIO.read(new File("culminating/assets/sprites/cat/flipped/catRun2l.png"));
            catRunl[3] = ImageIO.read(new File("culminating/assets/sprites/cat/flipped/catRun3l.png"));
            catRunl[4] = ImageIO.read(new File("culminating/assets/sprites/cat/flipped/catRun4l.png"));
            catRunl[5] = ImageIO.read(new File("culminating/assets/sprites/cat/flipped/catRun5l.png"));

            // water
            water[0] = ImageIO.read(new File("culminating/assets/sprites/water/water0.png"));
            water[1] = ImageIO.read(new File("culminating/assets/sprites/water/water1.png"));
            water[2] = ImageIO.read(new File("culminating/assets/sprites/water/water2.png"));

        

        } catch (Exception e) {
            System.out.println("Something wrong with the image!");
        }

        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(
                    Font.createFont(Font.TRUETYPE_FONT, new File("culminating/assets/PressStart2P-Regular.ttf")));
        } catch (IOException | FontFormatException e) {
            System.out.println("Something wrong with the font!");
        }

        // platform(s) generation (initial)
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)
                landx = rand.nextInt(300, 600);
            else if (i % 2 != 0)
                landx = rand.nextInt(0, 300);
            landxCoords[i] = landx;
        }

        JFrame frame = new JFrame("Flood Escape");
        Main panel = new Main();
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }

    // 50 FPS
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(20);
            } catch (Exception e) {
            }
        }
    }

    public static void PlayMusic(String location)
    {
        try {
            File musicPath = new File(location);

            if (musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip1 = AudioSystem.getClip();
                clip1.open(audioInput);
                clip1.start();
            
            }
            else {
                System.out.println("Can't find file");
            }

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void LoopMusic (String location)
    {
        try {

            File musicPath = new File(location);

            if (musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip1 = AudioSystem.getClip();
                clip1.open(audioInput);
                clip1.loop(Clip.LOOP_CONTINUOUSLY);
                clip1.start();
            }

        }
        catch (Exception e) {

        }
    }

    // Useless Methods
    public void keyTyped(KeyEvent e) {
    }
}