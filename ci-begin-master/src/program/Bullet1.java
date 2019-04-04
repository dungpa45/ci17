package program;

import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Bullet1 {
    BufferedImage image;

    ArrayList<Vector2D> bulletPositions;
    Player p;

    public Bullet1(Player p) {
        bulletPositions = new ArrayList<>();
        this.p = p;
        image=SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
    }

    public void render(Graphics g) {
        for (int i = 0; i < bulletPositions.size(); i++) {
            Vector2D bulletposition = bulletPositions.get(i);
            g.drawImage(
                    image,
                    (int) bulletposition.x,
                    (int) bulletposition.y,
                    null
            );
        }
    }

    public void run() {
        this.runBullet1();
        this.fire();
    }

    public void fire() {
        count++;

        if (GameWindow.isFirePress  && count > 20) {
            Vector2D bulletPosition = new Vector2D(p.position.x, p.position.y);
            bulletPositions.add(bulletPosition);
            count = 0;
        }

    }

    public void runBullet1() {

        for (int i = 0; i < bulletPositions.size(); i++) {
            Vector2D bulletPosition = bulletPositions.get(i);
            bulletPosition.setX(Mathx.clamp(bulletPosition.x,0,384-32));
            bulletPosition.setY(Mathx.clamp(bulletPosition.y,0,600-48));
            if(bulletPosition.x==0||bulletPosition.x==384-32)bulletPosition.x=-100;
            if(bulletPosition.y==0||bulletPosition.y==600-48)bulletPosition.y=600-48+100;
            bulletPosition.add(0, -7);
        }
    }


    int count = 0;



}
