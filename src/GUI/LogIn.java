package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import static java.lang.Boolean.TRUE;

public class LogIn {

    JLabel username = new JLabel("Username:");
    JLabel password = new JLabel("Password:");
    JButton login = new JButton("Login");
    JButton createUser = new JButton("Create user");
    JTextArea user = new JTextArea();
    JPasswordField pass = new JPasswordField();

    LogIn() {
        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 20, 30);
        gbc.anchor = GridBagConstraints.CENTER;

        jFrame.setVisible(true);
        jFrame.pack();
        jFrame.add(jPanel);
        jFrame.setTitle("Login");
        jFrame.setSize(400, 300);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(jPanel);

        jFrame.setVisible(true);


        JCheckBox showPassword = new JCheckBox("Show password");


        login.addMouseListener(buttonClick);
        createUser.addMouseListener(buttonClick);

        username.setFont(new Font("Arial", Font.BOLD, 18));
        username.setOpaque(false);

        user.setFont(new Font("Arial", Font.ITALIC, 16));
        user.setPreferredSize(new Dimension(150, 22));
        user.setLineWrap(true);

        pass.setFont(new Font("Arial", Font.ITALIC, 16));
        pass.setPreferredSize(new Dimension(157, 30));

        password.setFont(new Font("Arial", Font.BOLD, 18));
        password.setOpaque(false);

        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    pass.setEchoChar((char) 0);
                } else {
                    pass.setEchoChar('*');
                }
            }
        });


        login.setFont(new Font("Arial", Font.ITALIC, 16));
        login.setPreferredSize(new Dimension(100, 30));

        createUser.setFont(new Font("Arial", Font.ITALIC, 16));
        createUser.setPreferredSize(new Dimension(100, 30));

        gbc.gridy = 0;
        gbc.gridx = 0;
        jPanel.add(username, gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        jPanel.add(user, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        jPanel.add(password, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        jPanel.add(pass, gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        jPanel.add(showPassword, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        jPanel.add(login, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 5;
        jPanel.add(createUser, gbc);
    }

    MouseAdapter buttonClick = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) throws ClassCastException {

            Object src = e.getSource();
            String s;

            if (src == login) {
                try {
                    BufferedReader input = new BufferedReader(new FileReader("Users.txt"));
                    String line = input.readLine();
                    s = user.getText();
                    while (line != null) {
                        if (line.equalsIgnoreCase("id: " + s)) {
                            line = input.readLine();
                            s = pass.getText();
                            if(line.equalsIgnoreCase("password: " + s)) {
                                System.out.println("Välkommen tillbaka " + user.getText());
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Wrong password. Try again!");
                                break;
                            }
                            break;
                        } else {
                            line = input.readLine();
                            if (line == null) {
                                System.out.println( "Användaren hittas ej - Korrigera felstavning eller" +
                                        " skapa ny användare");
                            }
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (src == createUser) {
               new CreateUser();
            }

        }
    };

    public static void main(String[] args) {
        new LogIn();
    }
}

