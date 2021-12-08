package GUI;

import javax.swing.*;
import java.awt.*;

public class AccountOverview {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel DailyAcc = new JLabel("Daily acc", SwingConstants.CENTER);
        JLabel SavingAcc = new JLabel("Saving acc", SwingConstants.CENTER);

        JButton pay = new JButton("Betala");
        JButton transfer = new JButton("Överför");
        JButton gamble = new JButton("Spela");

        jFrame.setVisible(true);
        jFrame.pack();
        jFrame.add(jPanel);
        jFrame.setTitle("Bank");
        jFrame.setSize(500,600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color panelColor = new Color(30,120,200);
        Color labelColor = new Color(30, 140, 250);

        jPanel.setVisible(true);
        jPanel.setBackground(panelColor);

        DailyAcc.setOpaque(true);
        DailyAcc.setPreferredSize(new Dimension(475, 100));
        DailyAcc.setFont(new Font("Arial", Font.BOLD, 32));

        SavingAcc.setOpaque(true);
        SavingAcc.setPreferredSize(new Dimension(475,100));
        SavingAcc.setFont(new Font("Arial", Font.BOLD, 32));

        pay.setPreferredSize(new Dimension(475, 100));
        transfer.setPreferredSize(new Dimension(475, 100));
        gamble.setPreferredSize(new Dimension(475, 100));

        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jPanel.add(DailyAcc, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        jPanel.add(SavingAcc, gbc);

        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        jPanel.add(pay, gbc);

        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        jPanel.add(transfer, gbc);

        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        jPanel.add(gamble, gbc);



    }
}

