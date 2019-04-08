package program.player;

import program.GameObject;
import program.Settings;
import program.Vector2D;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
    public PlayerBullet(){
        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
//        position = new Vector2D();// vector (0;0)
        velocity.set(0,-Settings.P_BULLET_SPEED);
    }

    @Override
    public void run() {
        super.run();
        this.deactiveIfNeeded();
    }

    public void deactiveIfNeeded(){
        if(position.y < -30){
//            System.out.println("Deactive");
            this.deactive();
        }
    }

}
