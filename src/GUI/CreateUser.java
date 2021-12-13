package GUI;

import Client.Account;
import Client.Bank;
import Client.Logic;
import Client.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import static java.lang.Boolean.TRUE;

public class CreateUser extends JPanel {
    Logic logic = new Logic();

    JLabel idNumber = new JLabel("Id number:");
    JLabel password = new JLabel("Password:");
    JLabel firstName = new JLabel("First name");
    JLabel lastName = new JLabel("Last name");
    JLabel gender = new JLabel("Gender");
    JLabel address = new JLabel("Address");
    JLabel nationality = new JLabel("Nationality");

    JButton save = new JButton("Save");
    JButton returnButton = new JButton("Return");

    JTextArea idNumberInput = new JTextArea();
    JTextArea firstNameInput = new JTextArea();
    JTextArea lastNameInput = new JTextArea();
    JTextArea genderInput = new JTextArea();
    JTextArea addressInput = new JTextArea();
    JTextArea nationalityInput = new JTextArea();

    JPasswordField pass = new JPasswordField();

    CreateUser() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 20, 30);
        gbc.anchor = GridBagConstraints.CENTER;

        setVisible(true);
        setPreferredSize(new Dimension(500, 700));

        setVisible(true);


        JCheckBox showPassword = new JCheckBox("Show password");


        save.addMouseListener(buttonClick);
        returnButton.addMouseListener(buttonClick);

        text(idNumber);
        text(password);
        text(firstName);
        text(lastName);
        text(gender);
        text(address);
        text(nationality);

        userInput(idNumberInput);
        userInput(firstNameInput);
        userInput(lastNameInput);
        userInput(genderInput);
        userInput(addressInput);
        userInput(nationalityInput);

        pass.setFont(new Font("Arial", Font.ITALIC, 16));
        pass.setPreferredSize(new Dimension(157, 30));

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


        save.setFont(new Font("Arial", Font.ITALIC, 16));
        setPreferredSize(new Dimension(100, 30));

        returnButton.setFont(new Font("Arial", Font.ITALIC, 16));
        setPreferredSize(new Dimension(100, 30));

        gbc.gridy = 0;
        gbc.gridx = 0;
        add(idNumber, gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        add(idNumberInput, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        add(password, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        add(pass, gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        add(showPassword, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        add(firstName, gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;
        add(firstNameInput, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        add(lastName, gbc);

        gbc.gridy = 4;
        gbc.gridx = 1;
        add(lastNameInput, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(gender, gbc);

        gbc.gridy = 5;
        gbc.gridx = 1;
        add(genderInput, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(address, gbc);

        gbc.gridy = 6;
        gbc.gridx = 1;
        add(addressInput, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        add(nationality, gbc);

        gbc.gridy = 7;
        gbc.gridx = 1;
        add(nationalityInput, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(save, gbc);

        gbc.gridy = 8;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        add(returnButton, gbc);

    }

    MouseAdapter buttonClick = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) throws ClassCastException {

            Object src = e.getSource();
            String s;

            if (src == save) {
                logic.createUser(idNumberInput, firstNameInput, lastNameInput, genderInput, addressInput,
                        nationalityInput, pass);
                if (src == returnButton) {
                    try {
                        Window.window.swapPage(Window.Page.LOGIN);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }

            if(src==returnButton){
                try {
                    Window.window.swapPage(Window.Page.LOGIN);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    };

    private JLabel text(JLabel jLabel) {
        jLabel.setFont(new Font("Arial", Font.BOLD, 18));
        jLabel.setOpaque(false);
        return jLabel;
    }

    private JTextArea userInput(JTextArea jTextArea) {
        jTextArea.setFont(new Font("Arial", Font.ITALIC, 16));
        jTextArea.setPreferredSize(new Dimension(150, 22));
        jTextArea.setLineWrap(true);
        return jTextArea;
    }

}

