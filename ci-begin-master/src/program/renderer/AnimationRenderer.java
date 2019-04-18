package program.renderer;

import program.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int currentImageIndex;

    public AnimationRenderer(String directoryPath){
        images = SpriteUtils.loadImages(directoryPath);
        currentImageIndex = 0;
    }

    int count = 0;
    @Override
    public void render(Graphics g, GameObject master) {
        BufferedImage currenImage = images.get(currentImageIndex);
        g.drawImage(currenImage,
                (int) master.position.x,
                (int) master.position.y,
                null
                );
        count++;
        if(count > 9){
            currentImageIndex++;
            if (currentImageIndex >= images.size()){
                currentImageIndex = 0;
            }
            count = 0;
        }
    }
}
