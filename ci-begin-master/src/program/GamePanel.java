package program;
import program.player.Player;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Player player;

    public  GamePanel(){
//        backgroundImage = SpriteUtils.loadImage("assets/images/background/0.png");
//        // 1. dat vị trí khưởi tạo background
//        backgroundX= 0;
//        backgroundY= 600-3109;
        background = new Background();
        player = new Player(); // HAm tao x, y
    }

    static  Font font = new Font("Verdana",Font.BOLD,32);
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0,0,Settings.GAME_WIDTH,Settings.GAME_HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString("Game hay vl",400,200);

//        //GameObject.objects
        for (int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active){
                object.render(g);
            }

        }
//        background.render(g);
//        player.render(g);//draw image

    }
    public void runAll(){

        for (int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active){
                object.run();
            }
        }

//        background.run();
//        player.run();

    }

    public void gameloop(){
        long lastTime = 0;
        while(true){
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime > 1000/60){
//                System.out.println(currentTime - lastTime);
                this.repaint();
                this.runAll();
                lastTime = currentTime;

            }
        }
    }
}
