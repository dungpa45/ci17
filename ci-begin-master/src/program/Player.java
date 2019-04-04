package program;

import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    BufferedImage image;
//    double x;
//    double y;
    Vector2D position;
    BufferedImage bulletImage;
    ArrayList<Vector2D> bulletPositions;
    BufferedImage bulletImage1;
    ArrayList<Vector2D> bulletPositions1;
    BufferedImage bulletImage2;
    ArrayList<Vector2D> bulletPositions2;

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position = new Vector2D(300,300);
        bulletImage = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        bulletPositions = new ArrayList<>();
        bulletImage1 = SpriteUtils.loadImage("assets/images/player-bullets/a/0.png");
        bulletPositions1 = new ArrayList<>();
        bulletImage2 = SpriteUtils.loadImage("assets/images/player-bullets/a/2.png");
        bulletPositions2 = new ArrayList<>();
    }

    public void render(Graphics g) {
        g.drawImage(image, (int) position.x, (int) position.y, null);
        //ve dan nawm trong mang bullPositions
        for (int i = 0; i < bulletPositions.size(); i++) {
            Vector2D bulletPosition = bulletPositions.get(i);
            g.drawImage(bulletImage,
                    (int)bulletPosition.x,
                    (int)bulletPosition.y,
                    null);
        }

        for (int i = 0; i < bulletPositions1.size(); i++) {
            Vector2D bulletPosition1 = bulletPositions1.get(i);
            g.drawImage(bulletImage,
                    (int)bulletPosition1.x,
                    (int)bulletPosition1.y,
                    null);
        }

        for (int i = 0; i < bulletPositions2.size(); i++) {
            Vector2D bulletPosition2 = bulletPositions2.get(i);
            g.drawImage(bulletImage,
                    (int)bulletPosition2.x,
                    (int)bulletPosition2.y,
                    null);
        }
    }

    public void run() {
        //move
        this.move();
        //limit position
        this.limitPosition();
//
        this.bulletsRun();
        this.fire();
    }
    int count =0;
    public void fire(){
        count ++;
        if(GameWindow.isFirePress && count > 10){
            Vector2D bulletPosition = position.clone();
            bulletPositions.add(bulletPosition);
            count = 0;
        }
        if(GameWindow.isMegaPress && count >14){
            Vector2D bulletPosition1 = position.clone();
            bulletPositions1.add(bulletPosition1);

            Vector2D bulletPosition2 = position.clone();
            bulletPositions2.add(bulletPosition2);
            count = 0;
        }
    }

    public void bulletsRun() {
        for (int i = 0; i < bulletPositions.size(); i++) {
            Vector2D bulletPosition = bulletPositions.get(i);
            //đường đạn
            bulletPosition.add(0,-5);
        }
        for (int i = 0; i < bulletPositions1.size(); i++) {
            Vector2D bulletPosition1 = bulletPositions1.get(i);

            bulletPosition1.add(-5, -5);
        }

        for (int i = 0 ; i < bulletPositions2.size();i++ ) {
            Vector2D bulletPosition2 = bulletPositions2.get(i);

            bulletPosition2.add(5, -5);
        }
    }

    public void move(){
        double playerSpeed = 3;
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
        position.setX(Mathx.clamp(position.x,0,384-32));
        position.setY(Mathx.clamp(position.y,0,600-48));
    }
}

// nh loai dan
//nh viên dan
// đường dan