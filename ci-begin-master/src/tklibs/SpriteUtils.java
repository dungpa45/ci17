package tklibs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by huynq on 5/11/17.
 */
public class SpriteUtils {

    public static BufferedImage loadImage(String url) {
        try {
            return ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //
    public static ArrayList<BufferedImage> loadImages(String dirPath){
        ArrayList<BufferedImage> images = new ArrayList<>();
        try {
            File directory = new File(dirPath);
            java.util.List<String> fileNames = Arrays.asList(directory.list());
            Collections.sort(fileNames, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            for(String fileName : fileNames){
                images.add(loadImage(dirPath + "/" + fileName));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return images;
    }
    //

    public static void renderAtCenter(Graphics graphics, BufferedImage image, double x, double y) {
        graphics.drawImage(image, (int)(x - (double)image.getWidth() / 2), (int)(y - (double) image.getHeight() / 2), null);
    }

    public static BufferedImage maskWhite(BufferedImage image) {
        BufferedImage returnImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int color = image.getRGB(x, y);
                int alpha = color & 0xFF000000;
                if (alpha != 0) {
                    returnImage.setRGB(x, y, color | 0x00FFFFFF | alpha);
                } else {
                    returnImage.setRGB(x, y, color);
                }
            }
        }

        return returnImage;
    }
}
