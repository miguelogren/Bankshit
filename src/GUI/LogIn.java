package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import static java.lang.Boolean.TRUE;

public class LogIn extends JPanel{

    JLabel usernameLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JButton loginButton = new JButton("Login");
    JTextArea userTextArea = new JTextArea();
    JButton createUser = new JButton("Create user");
    JPasswordField passwordField = new JPasswordField();
    JCheckBox showPasswordBox = new JCheckBox("Show password");

    LogIn() {

        setPreferredSize(new Dimension(400, 250));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 20, 30);
        gbc.anchor = GridBagConstraints.CENTER;

        loginButton.addMouseListener(buttonClick);
        createUser.addMouseListener(buttonClick);

        usernameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        usernameLabel.setOpaque(false);

        userTextArea.setFont(new Font("Arial", Font.ITALIC, 16));
        userTextArea.setPreferredSize(new Dimension(150, 22));
        userTextArea.setLineWrap(true);
        userTextArea.setOpaque(true);

        passwordField.setFont(new Font("Arial", Font.ITALIC, 16));
        passwordField.setPreferredSize(new Dimension(157, 30));

        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        passwordLabel.setOpaque(false);

        showPasswordBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordBox.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
        });


        loginButton.setFont(new Font("Arial", Font.ITALIC, 16));
        loginButton.setPreferredSize(new Dimension(100, 30));

        createUser.setFont(new Font("Arial", Font.ITALIC, 16));
        createUser.setPreferredSize(new Dimension(100, 30));

        gbc.gridy = 0;
        gbc.gridx = 0;
        add(usernameLabel, gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        add(userTextArea, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        add(passwordLabel, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        add(passwordField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        add(showPasswordBox, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 5;
        add(createUser, gbc);
    }

    MouseAdapter buttonClick = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) throws ClassCastException {

            Object src = e.getSource();
            String s;

            if (src == loginButton) {
                try {
                    BufferedReader input = new BufferedReader(new FileReader("Users.txt"));
                    String line = input.readLine();
                    s = userTextArea.getText();
                    while (line != null) {
                        if (line.equalsIgnoreCase("id: " + s)) {
                            line = input.readLine();
                            s = passwordField.getText();
                            if(line.equalsIgnoreCase("password: " + s)) {
                                System.out.println("Välkommen tillbaka " + userTextArea.getText());
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Wrong password. Try again!");
                                break;
                            }
                            break;
                        }
                        else {
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
        Window window = new Window();
        window.add(new LogIn());
        window.pack(); //måste ha detta här för att window skall bli rätt size
    }
}

