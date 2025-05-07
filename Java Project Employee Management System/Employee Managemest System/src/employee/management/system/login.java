package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton eyeButton;
    boolean passwordVisible = false;
    boolean nightModeOn = false;

    JPanel passwordPanel;
    JLabel username, password;
    JButton login, back, nightModeButton;

    int failedAttempts = 0; // Track login failures

    login() {

        username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 20, 150, 30);
        add(tusername);

        password = new JLabel("Password");
        password.setBounds(40, 70, 150, 30);
        add(password);

        passwordPanel = new JPanel();
        passwordPanel.setLayout(null);
        passwordPanel.setBounds(150, 70, 200, 30);
        add(passwordPanel);

        tpassword = new JPasswordField();
        tpassword.setBounds(0, 0, 150, 30);
        tpassword.setEchoChar('•');
        passwordPanel.add(tpassword);

        eyeButton = new JButton("👀");
        eyeButton.setBounds(150, 0, 50, 30);
        eyeButton.setMargin(new Insets(0, 0, 0, 0));
        eyeButton.addActionListener(e -> {
            if (passwordVisible) {
                tpassword.setEchoChar('•');
                passwordVisible = false;
            } else {
                tpassword.setEchoChar((char) 0);
                passwordVisible = true;
            }
        });
        passwordPanel.add(eyeButton);

        login = new JButton("LOGIN");
        login.setBounds(175, 140, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(160, 180, 130, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        nightModeButton = new JButton("Night Mode");
        nightModeButton.setBounds(13, 223, 100, 27);
        nightModeButton.addActionListener(e -> toggleNightMode());
        add(nightModeButton);

        // Images
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(370, 7, 600, 400);
        add(imgg);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 600, 300);
        add(img);

        setSize(600, 300);
        setLocation(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    private void toggleNightMode() {
        if (!nightModeOn) {
            getContentPane().setBackground(Color.DARK_GRAY);
            username.setForeground(Color.WHITE);
            password.setForeground(Color.WHITE);
            tusername.setBackground(Color.GRAY);
            tusername.setForeground(Color.WHITE);
            tpassword.setBackground(Color.GRAY);
            tpassword.setForeground(Color.WHITE);
            passwordPanel.setBackground(Color.DARK_GRAY);
        } else {
            getContentPane().setBackground(null);
            username.setForeground(Color.BLACK);
            password.setForeground(Color.BLACK);
            tusername.setBackground(Color.WHITE);
            tusername.setForeground(Color.BLACK);
            tpassword.setBackground(Color.WHITE);
            tpassword.setForeground(Color.BLACK);
            passwordPanel.setBackground(null);
        }
        nightModeOn = !nightModeOn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("LOGIN")) {
            try {
                String Username = tusername.getText();
                String Password = new String(tpassword.getPassword());

                conn conn = new conn();

                String query = "select * from login where Username = '" + Username + "' and Password = '" + Password + "'";
                ResultSet resultSet = conn.statement.executeQuery(query);

                if (resultSet.next()) {
                    setVisible(false);
                    new Main_class();


                    tusername.setText("");
                    tpassword.setText("");


                    failedAttempts = 0;

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username / Password");


                    tusername.setText("");
                    tpassword.setText("");


                    failedAttempts++;

                    if (failedAttempts >= 3) {
                        login.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Too Many Failed Attempts. Login Disabled For 10 Seconds.");


                        Timer timer = new Timer(10000, evt -> {
                            login.setEnabled(true);
                            failedAttempts = 0; // reset
                        });
                        timer.setRepeats(false);
                        timer.start();
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equals("BACK")) {
            System.exit(909);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
