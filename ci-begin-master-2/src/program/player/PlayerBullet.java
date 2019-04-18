package program.player;

import program.GameObject;
import program.Settings;
import tklibs.SpriteUtils;

public class PlayerBullet extends GameObject {
    public PlayerBullet() {
        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        velocity.set(0, -Settings.P_BULLET_SPEED);
    }

    @Override
    public void run() {
        super.run();
        this.deactiveIfNeeded();
    }

    public void deactiveIfNeeded() {
        if(position.y < -30) {
            this.deactive();
        }
    }
}
