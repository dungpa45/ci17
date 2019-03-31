package program;

import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    BufferedImage image;
    double x;
    double y;

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        x = 300;
        y = 300;

    }

    public void render(Graphics g) {
        g.drawImage(image, (int) x, (int) y, null);
    }

    public void run() {
        double playerSpeed = 5;
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

        x += vx;
        y += vy;

        x = Mathx.clamp(x, 0, 384 - 32);
        y = Mathx.clamp(y, 0, 600 - 48);
    }

}
