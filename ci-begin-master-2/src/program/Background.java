package program;

import tklibs.SpriteUtils;

import java.awt.*;

public class Background extends GameObject {
    public Background() {
        image = SpriteUtils.loadImage("assets/images/background/0.png");
        position.set(0, Settings.GAME_HEIGHT - Settings.BACKGROUND_HEIGHT);
        velocity.set(0, Settings.BACKGROUND_SPEED);
    }

    @Override
    public void run() {
        super.run();
        if(position.y >= 0) {
            position.setY(0);
        }
    }
}
