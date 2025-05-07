package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        ImageIcon i2 = new ImageIcon(i1.getImage().getScaledInstance(1170,650, Image.SCALE_DEFAULT));
        JLabel image= new JLabel(i2);
        image.setBounds(0,0,1170,650);
        add(image);


        setSize (1170, 650);
        setLocation(200,50);
        setLayout(null);
        setVisible(true);

        try {
            Thread.sleep(5000);
            setVisible(false);
            new login();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();

    }
}