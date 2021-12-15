package GUI;

import Client.Account;
import Client.Logic;
import Client.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AdminOverview extends JPanel {

    JLabel userInfo;

    ArrayList<String> accountList = new ArrayList<String>();
    JButton showInformationButton = new JButton("Visa information");
    JTextArea userInformation = new JTextArea();
    JTextArea accounts = new JTextArea();
    JComboBox comboBox;
    JButton returnButton = new JButton("Return");
    JPanel upperGrid = new JPanel();
    JPanel midGrid = new JPanel();

    Logic logic = Logic.getInstance();

    AdminOverview() throws IOException {

        setLayout(new BorderLayout());

        add(upperGrid, BorderLayout.NORTH);
        add(midGrid, BorderLayout.CENTER);

        upperGrid.setLayout(new GridLayout(1,2));
        midGrid.setLayout(new GridLayout(2,1));

        BufferedReader input = new BufferedReader(new FileReader("Users.txt"));
        String line = input.readLine();
        while (line != null) {
            line = input.readLine();
            if (line != null && line.startsWith("id: ")) {
                accountList.add(line);
            }
        }

        returnButton.addMouseListener(buttonClick);
        add(returnButton, BorderLayout.SOUTH);

        comboBox = new JComboBox(accountList.toArray());

        showInformationButton.addMouseListener(buttonClick);

        upperGrid.add(comboBox);
        upperGrid.add(showInformationButton);

        midGrid.add(userInformation).setVisible(false);
        midGrid.add(accounts).setVisible(false);

        userInformation.setFont(new Font("Arial", Font.PLAIN, 22));
        accounts.setFont(new Font("Arial", Font.PLAIN, 30));


    }

    MouseAdapter buttonClick = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) throws ClassCastException {

            Object src = e.getSource();
            if (src == showInformationButton) {
                userInformation.setVisible(true);
                accounts.setVisible(true);

                userInformation.setText(logic.personFromFile(comboBox.getSelectedItem().toString()).get(1)
                        +"\n"     + logic.personFromFile(comboBox.getSelectedItem().toString()).get(2)
                        +"\n"     + logic.personFromFile(comboBox.getSelectedItem().toString()).get(3)
                        +"\n"     + logic.personFromFile(comboBox.getSelectedItem().toString()).get(4)
                        +"\n"     + logic.personFromFile(comboBox.getSelectedItem().toString()).get(5));

                Person person = new Person(logic.personFromFile(comboBox.getSelectedItem().toString()).get(0),
                        logic.personFromFile(comboBox.getSelectedItem().toString()).get(1),
                        logic.personFromFile(comboBox.getSelectedItem().toString()).get(2),
                        logic.personFromFile(comboBox.getSelectedItem().toString()).get(3),
                        logic.personFromFile(comboBox.getSelectedItem().toString()).get(4),
                        logic.personFromFile(comboBox.getSelectedItem().toString()).get(5));

                Account account = new Account(person);

                try {
                   accounts.setText("Daily Account: " + account.getDailyAccount() + "\n" +
                           "Savings Account: " + account.getSavingsAccount());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (src==returnButton){
                try {
                    Window.window.swapPage(Window.Page.LOGIN);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    };

}



