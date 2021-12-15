package GUI;

import Client.Logic;

import javax.swing.*;
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

    ArrayList <String> accountList = new ArrayList<String>();
    JComboBox accountsDropDownList;

    Logic logic = new Logic();
    String userID;

    AdminOverview() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("Users.txt"));
        while (reader.readLine()!=null) {
            userID = reader.readLine();
            if (userID.startsWith("i")) {
                System.out.println(userID);
                accountList.add(userID);
            }
        }

        for (int i = 0; i < accountList.size(); i++) {
            accountsDropDownList.addItem(accountList.get(i));
        }
        add(accountsDropDownList);
    }


}
