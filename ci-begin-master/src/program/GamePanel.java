package program;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    BufferedImage backgroundImage;
    BufferedImage playerImage;
    int playerX;
    int playerY;
    int backgroundX;
    int backgroundY;

    public  GamePanel(){
        backgroundImage = SpriteUtils.loadImage("assets/images/background/0.png");
        // 1. dat vị trí khưởi tạo background
        backgroundX= 0;
        backgroundY= 600-3109;
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        playerX =300;
        playerY = 300;
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
        g.drawImage(backgroundImage,backgroundX,backgroundY,null);
        g.drawImage(playerImage,playerX,playerY,null);
    }
    public void runAll(){
        // 2. cho background troi
        backgroundY +=7;

        //3. gioi han background
        if (backgroundY >=0){
            backgroundY = 0;
        }

        if (GameWindow.isUpPress){
            playerY--;
        }
        if (GameWindow.isRightPress){
            playerX++;
        }
        if (GameWindow.isDownPress){
            playerY++;
        }
        if (GameWindow.isLeftPress){
            playerX--;
        }

    }

    public void gameloop(){
        long lastTime = 0;
        while(true){
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime > 1000/60){
//                System.out.println(currentTime - lastTime);
                this.repaint();
                this.runAll();
                lastTime = currentTime;

            }
        }
    }
}
