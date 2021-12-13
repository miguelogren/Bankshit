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

    JLabel userName = new JLabel("");
    JLabel userId = new JLabel("");
    JLabel dailyAccLabel = new JLabel("Daily acc", SwingConstants.CENTER);
    JLabel savingsAccLabel = new JLabel("Saving acc", SwingConstants.CENTER);

    Logic logic = new Logic();

    public AccountOverview() throws IOException {


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        add(userName);
        add(userId);
        add(dailyAccLabel);
        add(savingsAccLabel);

        setSize(700, 500);



        userId.setFont(new Font("Arial", Font.ITALIC, 12));
        userName.setFont(new Font("Arial", Font.ITALIC, 12));

        userId.setText("" + logic.personFromFile().get(0).substring(4));

        userName.setText("" + logic.personFromFile().get(1).substring(11) + " " +
                logic.personFromFile().get(2).substring(10));

        dailyAccLabel.setOpaque(true);
        dailyAccLabel.setPreferredSize(new Dimension(200, 50));
        dailyAccLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        dailyAccLabel.setText("Daily: " + logic.readAccount().get(0));

        savingsAccLabel.setOpaque(true);
        savingsAccLabel.setPreferredSize(new Dimension(200, 50));
        savingsAccLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        savingsAccLabel.setText("Savings: " + logic.readAccount().get(1));

        payButton.setPreferredSize(new Dimension(200, 30));
        transferButton.setPreferredSize(new Dimension(150, 30));
        gambleButton.setPreferredSize(new Dimension(150, 30));

        gbc.gridy = 0;
        gbc.gridx = 0;
        add(userName, gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        add(userId, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        add(dailyAccLabel, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        add(savingsAccLabel, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        add(payButton, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        add(transferButton, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(gambleButton, gbc);


    }

}

