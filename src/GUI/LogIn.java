package GUI;

import javax.swing.*;
import java.awt.*;

public class LogIn {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 20, 30);
        gbc.anchor = GridBagConstraints.CENTER;

        jFrame.setVisible(true);
        jFrame.pack();
        jFrame.add(jPanel);
        jFrame.setTitle("Login");
        jFrame.setSize(400,250);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(jPanel);

        jFrame.setVisible(true);

        JLabel username = new JLabel("Username:");
        JLabel password = new JLabel("Password:");

        JTextArea user = new JTextArea();
        JTextArea pass = new JTextArea();

        JCheckBox showPassword = new JCheckBox("Show password");

        JButton login = new JButton("Login");

        username.setFont(new Font("Arial", Font.BOLD, 18));
        username.setOpaque(false);

        user.setFont(new Font("Arial", Font.ITALIC, 16));
        user.setPreferredSize(new Dimension(150,20));
        user.setLineWrap(true);
        //user.append("Username");

        pass.setFont(new Font("Arial", Font.ITALIC, 16));
        pass.setPreferredSize(new Dimension(150,20));
        pass.setLineWrap(true);
        //pass.append("Password");

        password.setFont(new Font("Arial", Font.BOLD, 18));
        password.setOpaque(false);

        login.setFont(new Font("Arial", Font.ITALIC, 16));
        login.setPreferredSize(new Dimension(100,30));

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



    }
}
