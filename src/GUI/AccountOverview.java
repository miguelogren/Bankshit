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
    JButton transferButton = new JButton("Överför mellan konton");
    JButton depositButton = new JButton("Insättning");
    JButton gambleButton = new JButton("Spela");
    JButton returnButton = new JButton("Return");
    JButton logOutButton = new JButton("Logga ut");

    JLabel userName = new JLabel("");
    JLabel userId = new JLabel("");
    JLabel dailyAccLabel = new JLabel("Daily acc", SwingConstants.CENTER);
    JLabel savingsAccLabel = new JLabel("Saving acc", SwingConstants.CENTER);
    JLabel fromAccount = new JLabel("Från konto", SwingConstants.CENTER);
    JLabel toAccount = new JLabel("Till konto", SwingConstants.CENTER);
    JLabel amount = new JLabel("Belopp", SwingConstants.CENTER);

    String[] accountList = { " ", "from daily to savings", "from savings to daily"};
    JComboBox accountsDropDownList = new JComboBox(accountList);

    String[] accountList2 = { " ", "Daily", "Savings"};
    JComboBox accountsDropDownList2 = new JComboBox(accountList2);


    JLabel daily = new JLabel("Daily");
    JLabel savings = new JLabel("Savings");

    JTextArea transferInput = new JTextArea();
    JTextArea accountIdInput = new JTextArea();

    Logic logic = new Logic();
    Person person = new Person(logic.personFromFile(logic.loggedInUser()).get(0),
            logic.personFromFile(logic.loggedInUser()).get(1),
            logic.personFromFile(logic.loggedInUser()).get(2),
            logic.personFromFile(logic.loggedInUser()).get(3)
            ,logic.personFromFile(logic.loggedInUser()).get(4),
            logic.personFromFile(logic.loggedInUser()).get(5));

    Account account = new Account(person);

    public AccountOverview() throws IOException {

        transferButton.addMouseListener(buttonClick);
        returnButton.addMouseListener(buttonClick);
        payButton.addMouseListener(buttonClick);
        logOutButton.addMouseListener(buttonClick);
        depositButton.addMouseListener(buttonClick);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        add(accountsDropDownList).setVisible(false);
        add(accountsDropDownList2).setVisible(false);

        add(userName);
        add(userId);
        add(dailyAccLabel);
        add(savingsAccLabel);

        add(daily).setVisible(false);
        add(transferInput).setVisible(false);

        add(savings).setVisible(false);
        add(accountIdInput).setVisible(false);

        add(fromAccount).setVisible(false);
        add(toAccount).setVisible(false);

        add(logOutButton);

        add(depositButton);
        add(returnButton).setVisible(false);

        add(amount).setVisible(false);


        setSize(700, 500);

        userId.setFont(new Font("Arial", Font.ITALIC, 12));
        userName.setFont(new Font("Arial", Font.ITALIC, 12));

        userId.setText("" + logic.personFromFile(logic.loggedInUser()).get(0).substring(4));

        userName.setText("" + logic.personFromFile(logic.loggedInUser()).get(1).substring(11) + " " +
                logic.personFromFile(logic.loggedInUser()).get(2).substring(10));

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
        add(fromAccount, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(accountsDropDownList2, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        add(depositButton, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(transferButton, gbc);

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

        gbc.gridy = 9;
        gbc.gridx = 0;
        add(gambleButton, gbc);

        gbc.gridy = 11;
        gbc.gridx = 0;
        add(returnButton, gbc);

        gbc.gridy = 11;
        gbc.gridx = 0;
        add(logOutButton, gbc);

    }

    MouseAdapter buttonClick = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) throws ClassCastException {

            Object src = e.getSource();
            String s;

            if (src == transferButton){
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

                if(src==transferButton){

                    if (accountsDropDownList.getSelectedItem()=="from daily to savings"){
                        try {
                            account.transferMoney(Integer.parseInt(transferInput.getText()),"D", "S");
                            dailyAccLabel.setText("Daily: " + account.getDailyAccount());
                            savingsAccLabel.setText("Savings: " + account.getSavingsAccount());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    }else if(accountsDropDownList.getSelectedItem()=="from savings to daily"){
                        try {
                            account.transferMoney(Integer.parseInt(transferInput.getText()),"S", "D");
                            dailyAccLabel.setText("Daily: " + account.getDailyAccount());
                            savingsAccLabel.setText("Savings: " + account.getSavingsAccount());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }

            if (src==payButton){
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

            if (src==depositButton){
                depositButton.setText("Sätt in");

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

            if (src==returnButton){
                try {
                    Window.window.swapPage(Window.Page.ACCOUNTOVERVIEW);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (src==logOutButton){
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

