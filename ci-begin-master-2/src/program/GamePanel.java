package program;

import program.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Player player; // image, x, y

    public GamePanel() {
        background = new Background();
        player = new Player(); // image, x, y
    }

    static Font font = new Font("Verdana", Font.ITALIC, 32);

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);

        for (int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active) {
                object.render(g);
            }
        }
    }

    public void runAll() {
        for (int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active) {
                object.run();
            }
        }
    }

    public void gameLoop() {
        long lastTime = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime >= 1000 / 60) {
                this.repaint(); // render anh
                this.runAll(); // chay logic
                lastTime = currentTime;
            }
        }
    }
}
