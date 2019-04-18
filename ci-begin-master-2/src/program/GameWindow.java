package program;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    public static boolean isUpPress;
    public static boolean isRightPress;
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isFirePress;

    public GameWindow() {
        this.setTitle("Game Touhou"); // title
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // defaultCloseOperation
        this.setResizable(false); // resizable
        //key
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // ham duoc goi khi giu phim
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    isUpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    isRightPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    isDownPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    isLeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // ham duoc goi khi nha phim
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    isUpPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    isRightPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    isDownPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    isLeftPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isFirePress = false;
                }
            }
        });
        //mouse
    }
}
