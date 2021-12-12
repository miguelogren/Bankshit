package GUI;

import Client.Account;
import Client.Bank;
import Client.Logic;
import Client.Person;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AccountOverview extends JPanel {

    JButton payButton = new JButton("Betala");
    JButton transferButton = new JButton("Överför");
    JButton gambleButton = new JButton("Spela");
    
    JLabel loggedInUser = new JLabel("");
    JLabel dailyAccLabel = new JLabel("Daily acc", SwingConstants.CENTER);
    JLabel savingsAccLabel = new JLabel("Saving acc", SwingConstants.CENTER);

    Logic logic = new Logic();

    public AccountOverview() throws IOException {


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        add(loggedInUser);
        add(dailyAccLabel);
        add(savingsAccLabel);

        setSize(700,500);

        Color panelColor = new Color(30,120,200);
        Color labelColor = new Color(30, 140, 250);

        setBackground(panelColor);

        loggedInUser.setOpaque(true);
        loggedInUser.setPreferredSize(new Dimension(475, 100));
        loggedInUser.setFont(new Font("Arial", Font.BOLD, 25));
        loggedInUser.setText("" + logic.personFromFile().get(1).substring(11) + " " +
                logic.personFromFile().get(2).substring(10));

        dailyAccLabel.setOpaque(true);
        dailyAccLabel.setPreferredSize(new Dimension(475, 100));
        dailyAccLabel.setFont(new Font("Arial", Font.BOLD, 32));
        dailyAccLabel.setText(""+logic.readAccount().get(0));

        savingsAccLabel.setOpaque(true);
        savingsAccLabel.setPreferredSize(new Dimension(475,100));
        savingsAccLabel.setFont(new Font("Arial", Font.BOLD, 32));
        savingsAccLabel.setText(""+logic.readAccount().get(1));

        payButton.setPreferredSize(new Dimension(475, 100));
        transferButton.setPreferredSize(new Dimension(475, 100));
        gambleButton.setPreferredSize(new Dimension(475, 100));

        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(loggedInUser, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(dailyAccLabel, gbc);

        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(savingsAccLabel, gbc);

        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        add(payButton, gbc);

        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(transferButton, gbc);

        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        add(gambleButton, gbc);

    }

}

