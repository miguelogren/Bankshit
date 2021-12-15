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
    JLabel userInformation = new JLabel();
    JLabel accounts = new JLabel();
    JComboBox comboBox;
    JButton returnButton = new JButton("Return");
    String userText;


    Logic logic = Logic.getInstance();



    AdminOverview() throws IOException {

        new BorderLayout();
        BufferedReader input = new BufferedReader(new FileReader("Users.txt"));
        String line = input.readLine();
        while (line != null) {
            line = input.readLine();
            if (line != null && line.startsWith("id: ")) {
                accountList.add(line);
            }
        }

        returnButton.addMouseListener(buttonClick);
        add(returnButton);

        comboBox = new JComboBox(accountList.toArray());

        add(comboBox, BorderLayout.NORTH);
        add(showInformationButton, BorderLayout.NORTH);
        showInformationButton.addMouseListener(buttonClick);
        add(userInformation, BorderLayout.CENTER);
        userInformation.setVisible(false);
        add(accounts, BorderLayout.CENTER);
        accounts.setVisible(false);

    }

    MouseAdapter buttonClick = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) throws ClassCastException {

            Object src = e.getSource();
            if (src == showInformationButton) {
                userInformation.setVisible(true);
                accounts.setVisible(true);


                userText = ("<html><body>" + logic.personFromFile(comboBox.getSelectedItem().toString()).get(0)
                + "<br>" + logic.personFromFile(comboBox.getSelectedItem().toString()).get(1)
                + "<br>" + logic.personFromFile(comboBox.getSelectedItem().toString()).get(2)
                + "<br>" + logic.personFromFile(comboBox.getSelectedItem().toString()).get(3)
                + "<br>" + logic.personFromFile(comboBox.getSelectedItem().toString()).get(4)
                + "<br>" + logic.personFromFile(comboBox.getSelectedItem().toString()).get(5) + "</body></html>");

                userInformation.setText(userText);


                Person person = new Person(logic.personFromFile(comboBox.getSelectedItem().toString()).get(0),
                        logic.personFromFile(comboBox.getSelectedItem().toString()).get(1),
                        logic.personFromFile(comboBox.getSelectedItem().toString()).get(2),
                        logic.personFromFile(comboBox.getSelectedItem().toString()).get(3),
                        logic.personFromFile(comboBox.getSelectedItem().toString()).get(4),
                        logic.personFromFile(comboBox.getSelectedItem().toString()).get(5));

                Account account = new Account(person);

                try {
                   accounts.setText("" + account.getDailyAccount() + " " + account.getSavingsAccount());
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



