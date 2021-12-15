package GUI;

import Client.Account;
import Client.Bank;
import Client.Logic;
import Client.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class AccountOverview extends JPanel {

    JButton payButton = new JButton("Betala");
    JButton transferButton = new JButton("Överför");
    JButton depositButton = new JButton("Insättning");
    JButton gambleButton = new JButton("Spela");
    JButton gambleButton2 = new JButton("Spela");
    JButton returnButton = new JButton("Return");
    JButton logOutButton = new JButton("Logga ut");
    JButton blackButton = new JButton("");
    JButton redButton = new JButton("");
    JButton randomButton = new JButton("");

    JLabel userName = new JLabel("", SwingConstants.CENTER);
    JLabel userId = new JLabel("", SwingConstants.CENTER);
    JLabel dailyAccLabel = new JLabel("Daily acc", SwingConstants.CENTER);
    JLabel savingsAccLabel = new JLabel("Saving acc", SwingConstants.CENTER);
    JLabel fromAccount = new JLabel("Från konto", SwingConstants.CENTER);
    JLabel toAccount = new JLabel("Till konto", SwingConstants.CENTER);
    JLabel amount = new JLabel("Belopp", SwingConstants.CENTER);
    JLabel winnerText = new JLabel(" ", SwingConstants.CENTER);

    String[] accountList = {" ", "from daily to savings", "from savings to daily"};
    JComboBox accountsDropDownList = new JComboBox(accountList);

    String[] accountList2 = {" ", "Daily", "Savings"};
    JComboBox accountsDropDownList2 = new JComboBox(accountList2);


    JLabel daily = new JLabel("Daily");
    JLabel savings = new JLabel("Savings");

    JTextArea transferInput = new JTextArea();
    JTextArea accountIdInput = new JTextArea();

    Logic logic = Logic.getInstance();

    Person person = new Person(logic.personFromFile(logic.loggedInUser()).get(0),
            logic.personFromFile(logic.loggedInUser()).get(1),
            logic.personFromFile(logic.loggedInUser()).get(2),
            logic.personFromFile(logic.loggedInUser()).get(3)
            , logic.personFromFile(logic.loggedInUser()).get(4),
            logic.personFromFile(logic.loggedInUser()).get(5));

    Account account = new Account(person);

    GridBagConstraints gbc = new GridBagConstraints();

    int colorPick = 0;
    int randomNr = 0;
    int winOrLoss = 0;
    boolean win;

    public AccountOverview() throws IOException {

        transferButton.addMouseListener(buttonClick);
        returnButton.addMouseListener(buttonClick);
        payButton.addMouseListener(buttonClick);
        logOutButton.addMouseListener(buttonClick);
        depositButton.addMouseListener(buttonClick);
        gambleButton.addMouseListener(buttonClick);
        blackButton.addMouseListener(buttonClick);
        redButton.addMouseListener(buttonClick);
        gambleButton2.addMouseListener(buttonClick);

        setLayout(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        fromAccount.setForeground(Color.white);
        fromAccount.setFont(new Font("Arial", Font.ITALIC, 12));
        toAccount.setForeground(Color.white);
        toAccount.setFont(new Font("Arial", Font.ITALIC, 12));
        amount.setForeground(Color.white);
        amount.setFont(new Font("Arial", Font.ITALIC, 12));

        add(userName);
        add(userId);
        add(dailyAccLabel);
        add(savingsAccLabel);
        add(logOutButton);
        add(depositButton);
        add(gambleButton2).setVisible(false);

        add(daily).setVisible(false);
        add(transferInput).setVisible(false);
        add(savings).setVisible(false);
        add(accountIdInput).setVisible(false);
        add(fromAccount).setVisible(false);
        add(toAccount).setVisible(false);
        add(returnButton).setVisible(false);
        add(amount).setVisible(false);
        add(accountsDropDownList).setVisible(false);
        add(accountsDropDownList2).setVisible(false);
        add(randomButton).setVisible(false);
        gbc.fill = GridBagConstraints.BOTH;
        add(blackButton, gbc);
        blackButton.setVisible(false);

        gbc.fill = GridBagConstraints.BOTH;
        add(redButton, gbc);
        redButton.setVisible(false);


        randomButton.setPreferredSize(new Dimension(50, 50));


        //setSize(700, 500);
        setBackground(Color.DARK_GRAY);

        userId.setFont(new Font("Arial", Font.ITALIC, 16));
        userId.setForeground(Color.white);
        userName.setFont(new Font("Arial", Font.ITALIC, 16));
        userName.setForeground(Color.white);

        userId.setText("" + logic.personFromFile(logic.loggedInUser()).get(0).substring(4));

        userName.setText("" + logic.personFromFile(logic.loggedInUser()).get(1).substring(11) + " " +
                logic.personFromFile(logic.loggedInUser()).get(2).substring(10));

        dailyAccLabel.setForeground(Color.white);
        dailyAccLabel.setPreferredSize(new Dimension(150, 100));
        dailyAccLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        dailyAccLabel.setText("Daily: " + logic.readAccount().get(0));

        savingsAccLabel.setForeground(Color.white);
        savingsAccLabel.setPreferredSize(new Dimension(150, 100));
        savingsAccLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        savingsAccLabel.setText("Savings: " + logic.readAccount().get(1));

        text(daily);
        text(savings);

        userInput(transferInput);
        userInput(accountIdInput);

        gbc.gridy = 0;
        gbc.gridx = 0;
        add(userName, gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        add(userId, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        add(dailyAccLabel, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        add(savingsAccLabel, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        add(payButton, gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;
        add(depositButton, gbc);

        gbc.gridy = 4;
        gbc.gridx = 1;
        add(gambleButton, gbc);

        gbc.gridy = 4;
        gbc.gridx = 1;
        add(gambleButton2, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        add(transferButton, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        add(fromAccount, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(accountsDropDownList2, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(accountsDropDownList, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        add(toAccount, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        add(accountIdInput, gbc);

        gbc.gridy = 9;
        gbc.gridx = 0;
        add(amount, gbc);

        gbc.gridy = 10;
        gbc.gridx = 0;
        add(transferInput, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        add(savings, gbc);

        gbc.gridy = 11;
        gbc.gridx = 0;
        add(returnButton, gbc);

        gbc.gridy = 11;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(logOutButton, gbc);

    }

    MouseAdapter buttonClick = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) throws ClassCastException {

            Object src = e.getSource();

            if (src == transferButton) {
                accountsDropDownList.setVisible(true);
                transferInput.setVisible(true);
                savings.setVisible(false);

                payButton.setVisible(false);
                gambleButton.setVisible(false);
                depositButton.setVisible(false);
                logOutButton.setVisible(false);
                returnButton.setVisible(true);

                transferButton.setText("Överför");
                revalidate();

                if (src == transferButton) {

                    if (accountsDropDownList.getSelectedItem() == "from daily to savings") {
                        try {
                            account.transferMoney(Integer.parseInt(transferInput.getText()), "D", "S");
                            dailyAccLabel.setText("Daily: " + account.getDailyAccount());
                            savingsAccLabel.setText("Savings: " + account.getSavingsAccount());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    } else if (accountsDropDownList.getSelectedItem() == "from savings to daily") {
                        try {
                            account.transferMoney(Integer.parseInt(transferInput.getText()), "S", "D");
                            dailyAccLabel.setText("Daily: " + account.getDailyAccount());
                            savingsAccLabel.setText("Savings: " + account.getSavingsAccount());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }

            if (src == payButton) {
                depositButton.setVisible(false);
                transferButton.setVisible(false);
                gambleButton.setVisible(false);
                returnButton.setVisible(true);
                logOutButton.setVisible(false);

                fromAccount.setVisible(true);
                accountsDropDownList2.setVisible(true);
                toAccount.setVisible(true);
                accountIdInput.setVisible(true);
                amount.setVisible(true);
                transferInput.setVisible(true);

                if (accountsDropDownList2.getSelectedItem() == "Daily") {
                    try {
                        String aii = "id: " + accountIdInput.getText();
                        Person reciever = new Person(logic.personFromFile(aii).get(0),
                                logic.personFromFile(aii).get(1),
                                logic.personFromFile(aii).get(2),
                                logic.personFromFile(aii).get(3),
                                logic.personFromFile(aii).get(4),
                                logic.personFromFile(aii).get(5));
                        Account recievingAccount = new Account(reciever);

                        account.writeToFile(-Integer.parseInt(transferInput.getText()), 0);
                        recievingAccount.writeToFile(Integer.parseInt(transferInput.getText()), 0);
                        dailyAccLabel.setText("Daily: " + account.getDailyAccount());
                        savingsAccLabel.setText("Savings: " + account.getSavingsAccount());


                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                } else if (accountsDropDownList2.getSelectedItem() == "Savings") {
                    try {
                        String aii = "id: " + accountIdInput.getText();

                        System.out.println(aii);

                        Person reciever = new Person(logic.personFromFile(aii).get(0),
                                logic.personFromFile(aii).get(1),
                                logic.personFromFile(aii).get(2),
                                logic.personFromFile(aii).get(3),
                                logic.personFromFile(aii).get(4),
                                logic.personFromFile(aii).get(5));
                        Account recievingAccount = new Account(reciever);
                        account.writeToFile(0, -Integer.parseInt(transferInput.getText()));
                        recievingAccount.writeToFile(Integer.parseInt(transferInput.getText()), 0);
                        dailyAccLabel.setText("Daily: " + account.getDailyAccount());
                        savingsAccLabel.setText("Savings: " + account.getSavingsAccount());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
            }

            if (src == depositButton) {
                depositButton.setText("Sätt in");

                gbc.gridy = 3;
                gbc.gridx = 0;
                gbc.gridwidth = 1;
                add(depositButton, gbc);

                payButton.setVisible(false);
                depositButton.setVisible(true);
                transferButton.setVisible(false);
                gambleButton.setVisible(false);
                returnButton.setVisible(true);
                logOutButton.setVisible(false);

                accountsDropDownList2.setVisible(true);
                amount.setVisible(true);
                transferInput.setVisible(true);

                if (accountsDropDownList2.getSelectedItem() == "Daily") {
                    try {
                        account.writeToFile(Integer.parseInt(transferInput.getText()), 0);
                        dailyAccLabel.setText("Daily: " + account.getDailyAccount());
                        savingsAccLabel.setText("Savings: " + account.getSavingsAccount());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                } else if (accountsDropDownList2.getSelectedItem() == "Savings") {
                    try {
                        account.writeToFile(0, Integer.parseInt(transferInput.getText()));
                        dailyAccLabel.setText("Daily: " + account.getDailyAccount());
                        savingsAccLabel.setText("Savings: " + account.getSavingsAccount());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            if (src == gambleButton) {

                payButton.setVisible(false);
                depositButton.setVisible(false);
                transferButton.setVisible(false);
                gambleButton.setVisible(false);
                gambleButton2.setVisible(true);
                logOutButton.setVisible(false);


                fromAccount.setVisible(true);
                accountsDropDownList2.setVisible(true);
                amount.setVisible(true);
                redButton.setVisible(true);
                blackButton.setVisible(true);
                transferInput.setVisible(true);
                randomButton.setVisible(true);

                returnButton.setVisible(true);

                gbc.gridy = 3;
                gbc.gridx = 0;
                gbc.gridwidth = 3;
                add(gambleButton2, gbc);

                gbc.gridy = 4;
                gbc.gridx = 1;
                add(amount, gbc);

                gbc.gridy = 5;
                gbc.gridx = 1;
                add(transferInput, gbc);

                gbc.gridy = 10;
                gbc.gridx = 0;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.gridwidth = 1;
                add(blackButton, gbc);
                blackButton.setBackground(Color.black);
                blackButton.setForeground(Color.black);

                gbc.gridy = 10;
                gbc.gridx = 1;
                gbc.gridwidth = 1;
                gbc.fill = GridBagConstraints.BOTH;
                add(redButton, gbc);
                redButton.setBackground(Color.red);
                redButton.setForeground(Color.red);

                gbc.gridy = 12;
                gbc.gridx = 0;
                gbc.gridwidth = 2;
                gbc.fill = GridBagConstraints.VERTICAL;
                add(randomButton, gbc);

                gbc.gridy = 13;
                gbc.gridx = 0;
                gbc.gridwidth = 2;
                add(winnerText, gbc);
                text(winnerText);

                gbc.gridy = 15;
                gbc.gridx = 0;
                add(returnButton, gbc);
            }
            if (src == gambleButton2) {

                randomNr = logic.randomNumber();
                win = logic.winOrNot(colorPick, randomNr);

                if (randomNr == 1) {
                    randomButton.setBackground(Color.red);
                } else if (randomNr == 2) {
                    randomButton.setBackground(Color.black);
                }
                if (win) {
                    winOrLoss = Integer.parseInt(transferInput.getText()) * 2;
                    winnerText.setText("Grattis, du vann: " + winOrLoss + "kr");
                    winnerText.setForeground(Color.green);
                    try {
                        account.writeToFile(winOrLoss / 2, 0);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    winOrLoss = Integer.parseInt(transferInput.getText());
                    winnerText.setText("Otur, du förlorade: " + Integer.parseInt(transferInput.getText()) + "kr");
                    winnerText.setForeground(Color.red);
                    try {
                        account.writeToFile(-winOrLoss, 0);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                winnerText.setVisible(true);

                try {
                    dailyAccLabel.setText("" + account.getDailyAccount());
                    savingsAccLabel.setText("" + account.getSavingsAccount());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }

            if (src == redButton) {
                blackButton.setText("");
                redButton.setText("X");
                redButton.setForeground(Color.WHITE);
                colorPick = 1;
                System.out.println(colorPick);
            }

            if (src == blackButton) {
                redButton.setText("");
                blackButton.setText("X");
                blackButton.setForeground(Color.WHITE);
                colorPick = 2;
                System.out.println(colorPick);
            }

            if (src == returnButton) {
                try {
                    Window.window.swapPage(Window.Page.ACCOUNTOVERVIEW);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (src == logOutButton) {
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
        jTextArea.setLineWrap(true);
        return jTextArea;
    }

}

