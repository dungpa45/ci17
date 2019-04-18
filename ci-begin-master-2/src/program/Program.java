package program;

import program.player.Player;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();

        GamePanel panel = new GamePanel(); // replace JPanel by GamePanel
        // set preferredSize cho panel
        panel.setPreferredSize(new Dimension(Settings.GAME_WIDTH, Settings.GAME_HEIGHT));
        window.add(panel);
        // window pack
        window.pack();
        panel.setBackground(Color.CYAN);

        window.setVisible(true);

        panel.gameLoop();
    }
}
