package program.renderer;

import program.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SingleImageRanferer extends Renderer {
    BufferedImage image;

    public SingleImageRanferer(BufferedImage image){
        this.image = image;
    }

    public SingleImageRanferer(String filePath){
        this.image = SpriteUtils.loadImage(filePath);
    }

    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(image, (int)master.position.x, (int) master.position.y, null);
    }
}
