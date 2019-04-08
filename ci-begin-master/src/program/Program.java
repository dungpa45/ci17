package program;

import program.player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
//    static double[] giaiptbac2(double a, double b, double c){
//        double[] result = new double[2];
//        double delta = b*b-(4*a*c);
//        if (a==0){
//            if (b==0){
//                return null;
//            }else {
//                double x1 = -c / b;
//                result[0]=x1;
//                return result;
//            }
//        }else {
//            if (delta < 0){
//                return null;
//            }else if (delta == 0){
//                double x = -b / (2*a);
//                result[0]=x;
//                return result;
//            }else {
//                double x1 = (-b + Math.sqrt(delta))/(2*a);
//                double x2 = (-b - Math.sqrt(delta))/(2*a);
//                result[0]=x1;
//                result[1]=x2;
//                return result;
//            }
//        }
//    }

//    /**
//     * if number < 0 ->> throw exception
//     * @param number
//     * @throws Exception
//     */
//    public static void validateNum(int number)throws Exception{
//        if(number < 0){
//            throw new Exception("Invalid number");
//        }else if(number < 5){
//            throw new NumberFormatException("Number must greater than 5");
//        }
//        else {
//            System.out.println("Valid number");
//        }
//    }
    public static <SomeClass extends GameObject> void print(Class<SomeClass> cls){
        // SomeClass = Player
        System.out.println(cls);
    }

    public static void main(String[] args) {

//        System.out.println("Start parsing");
//        try {
//            validateNum(10);
//            validateNum(5);
//            validateNum(-100);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        System.out.println("Validate Done");

        GameWindow window = new GameWindow();

        GamePanel panel = new GamePanel();
        //set preference cho panel
        panel.setPreferredSize(new Dimension(Settings.GAME_WIDTH,Settings.GAME_HEIGHT));
        window.add(panel);
        //window pack
        window.pack();
        panel.setBackground(Color.WHITE);

        window.setVisible(true);
        panel.gameloop();

//        ArrayList<String> listString = new ArrayList<>();

        //listString.add() -- Dua phan tw vao mang
        //listString.size() -- lay kich thuoc mang
        //listString.get() -- lay phan tu
        //listString.remove() -- xoa phan tu

    }
}
