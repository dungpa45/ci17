package program;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    BufferedImage image;
//    double x;
//    double y;
    Vector2D position;

    public Background(){
        image = SpriteUtils.loadImage("assets/images/background/0.png");
//        x=0;
//        y=600 -3109;
        position = new Vector2D(0,600-3109);
    }

    public void render(Graphics g) {
        g.drawImage(image,(int)position.x,(int)position.y,null);
    }

    public void run(){
//         2. cho background troi
        position.add(0,10);
//        3. gioi han background
        if (position.y >=0){
            position.y = 0;
        }
    }
}
