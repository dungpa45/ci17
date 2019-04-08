package program;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject/*extend game obj*/{

    public Background(){
        image = SpriteUtils.loadImage("assets/images/background/0.png");
        position.set(0,Settings.GAME_HEIGHT-Settings.BACKGROUND_HEIGHT);
        velocity.set(0,Settings.BACKGROUND_SPEED);
    }

//    public void render(Graphics g) {
//        g.drawImage(image,(int)position.x,(int)position.y,null);
//    }
    @Override
    public void run(){
//         2. cho background troi
        super.run();
//        3. gioi han background
        if (position.y >=0){
            position.setY(0);
        }
    }
}
