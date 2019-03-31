package program;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    Background background;
    Player player;

    public  GamePanel(){
//        backgroundImage = SpriteUtils.loadImage("assets/images/background/0.png");
//        // 1. dat vị trí khưởi tạo background
//        backgroundX= 0;
//        backgroundY= 600-3109;
        background = new Background();
        player = new Player(); // HAm tao x, y
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
//        g.drawImage(backgroundImage,backgroundX,backgroundY,null);
//        g.drawImage(playerImage,playerX,playerY,null);
        background.render(g);
        player.render(g);

    }
    public void runAll(){
        // 2. cho background troi
//        backgroundY +=7;
        //3. gioi han background
//        if (backgroundY >=0){
//            backgroundY = 0;
//        }
        background.run();
        player.run();

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
