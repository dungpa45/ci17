package program.player;

import program.GameObject;
import program.GameWindow;
import program.Settings;
import program.Vector2D;
import tklibs.Mathx;
import tklibs.SpriteUtils;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
//    ArrayList<PlayerBullet> bullets;// replace by GameObject.object

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position.set(Settings.PLAYER_START_X,Settings.PLAYER_START_Y);
//        bullets = new ArrayList<>();
    }

    public void run() {
        super.run();// position.add(velocity)
        //move
        this.move();
        //limit position
        this.limitPosition();
        this.fire();
    }
    int count =0;
    public void fire(){
        count ++;
        if(GameWindow.isFirePress && count > Settings.PLAYER_FIRE_DELAY){
//            Vector2D bulletPosition = position.clone();
//            bulletPositions.add(bulletPosition);
//            Vector2D bulletPosition2 = position.clone();
//            bulletPositions.add(-10,0);
//            Vector2D bulletPosition3 = position.clone();
//            bulletPositions.add(10,0);
//            PlayerBullet bullet = new PlayerBullet();
//            bullet.position.set(this.position.x,this.position.y);
////            bullet.velocity.set(-3,-5);
//            bullets.add(bullet);
//
//            PlayerBullet bullet2 = new PlayerBullet();
//            bullet2.position.set(this.position.x-10,this.position.y);
//            bullet2.velocity.setAngle(-Math.PI/3);
//            bullets.add(bullet2);
//
//            PlayerBullet bullet3 = new PlayerBullet();
//            bullet3.position.set(this.position.x+10,this.position.y);
//            bullet3.velocity.setAngle(-2*Math.PI/3);
//            bullets.add(bullet3);
            double fromX = this.position.x+10;
            double toX = this.position.x-10;
            double fromAngle = -Math.PI/3;
            double toAngle = -2*Math.PI/3;
            int numberBullet = 5;
            for (int i = 0; i < numberBullet; i++) {
//                PlayerBullet bullet = new PlayerBullet();
                PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
                double x = fromX + i * (toX - fromX) / (numberBullet-1);
                bullet.position.set(x,this.position.y);

                double angle = fromAngle + i *(toAngle-fromAngle)/(numberBullet-1);
                bullet.velocity.setAngle(angle);
            }

            count = 0;
        }
    }

    public void move(){
        double playerSpeed = Settings.PLAYER_SPEED;
        double vx = 0;
        double vy = 0;

        if (GameWindow.isUpPress) {
            vy -= playerSpeed;
        }
        if (GameWindow.isRightPress) {
            vx += playerSpeed;
        }
        if (GameWindow.isDownPress) {
            vy += playerSpeed;
        }
        if (GameWindow.isLeftPress) {
            vx -= playerSpeed;
        }
        //TODO: Recalculate
        if (vx != 0 && vy != 0) {
            double v = playerSpeed / Math.sqrt(2);
            vx = Math.signum(vx) * v; //1*5*sqrt(2)
            vy = Math.signum(vy) * v;//-1*5*sqrt(2)
        }

        position.add(vx,vy);
    }

    public void limitPosition(){
        position.setX(Mathx.clamp(position.x,0,Settings.BACKGROUND_WIDTH-Settings.PLAYER_WIDTH));
        position.setY(Mathx.clamp(position.y,0, Settings.GAME_HEIGHT -Settings.PLAYER_HEIGHT));
    }
}
