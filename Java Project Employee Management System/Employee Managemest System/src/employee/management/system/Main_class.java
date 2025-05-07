package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 1120, 630);
        background.setLayout(null); // Allows manual positioning


        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340, 155, 500, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        heading.setForeground(Color.BLACK); // Text color
        background.add(heading);


        JButton add = new JButton("Add Employee");
        add.setBounds(335, 270, 150, 40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        background.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);

            }
        });


        JButton view = new JButton("View Employee");
        view.setBounds(565, 270, 150, 40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLACK);
        background.add(view);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Employee();
                setVisible(false);

            }
        });


        JButton rem = new JButton("Remove Employee");
        rem.setBounds(440, 370, 150, 40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.BLACK);
        background.add(rem);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new RemoveEmployee();


            }
        });


        add(background);

        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_class();
    }
}
