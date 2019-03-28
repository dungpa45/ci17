package program;

import javax.swing.*;
import java.awt.*;

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

    public static void main(String[] args) {
//        System.out.println("Hello World");
//        double[] result = giaiptbac2(1,2,1);
//        if (result==null){
//            System.out.println("Can not solve equlation");
//        } else {
////            for (int i=0; i<result.length;i++){
////                System.out.println(result[i]);
////            }
//            int i=0;
//            while (i < result.length){
//                System.out.println(result[i]);
//                i++;
//            }
//        }


//        System.out.println(People.count);
//        People person1 = new People();
//        System.out.println(People.count);
//        System.out.println(person1.name);
//        System.out.println(person1.age);
//        person1.walk();
//
//        People person2 = new People("Alex", 10);
//        System.out.println(person2.name);
//        System.out.println(person2.age);
//        person2.walk();
        GameWindow window = new GameWindow();


        GamePanel panel = new GamePanel();
        window.add(panel);
        panel.setBackground(Color.WHITE);

        window.setVisible(true);
        panel.gameloop();
    }
}
