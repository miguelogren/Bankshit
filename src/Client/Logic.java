package Client;

import GUI.Window;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

public class Logic {

    public void logIn(JTextArea userTextArea, JPasswordField passwordField) {
        try {
            BufferedReader input = new BufferedReader(new FileReader("Users.txt"));
            String line = input.readLine();
            String s = userTextArea.getText();
            while (line != null) {
                if (line.equalsIgnoreCase("id: " + s)) {
                    String id = line;
                    line = input.readLine();
                    s = passwordField.getText();
                    if (line.equalsIgnoreCase("password: " + s)) {

                        PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter("LoggedIn.txt")));
                        print.println(id);
                        print.close();
                        Window.window.swapPage(Window.Page.ACCOUNTOVERVIEW);
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong password. Try again!");
                        break;
                    }
                    break;
                } else {
                    line = input.readLine();
                    if (line == null) {
                        JOptionPane.showMessageDialog(null, "Användaren hittas ej - Korrigera felstavning eller" +
                                " skapa ny användare");
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createUser(JTextArea idNumberInput, JTextArea firstNameInput, JTextArea lastNameInput,
                           JTextArea genderInput, JTextArea addressInput, JTextArea nationalityInput, JPasswordField pass) {
        boolean shouldPrint = true;
        try {
            BufferedReader input = new BufferedReader(new FileReader("Users.txt"));
            String line = input.readLine();
            String s = idNumberInput.getText();
            while (line != null) {
                line = input.readLine();
                if (line != null && line.equalsIgnoreCase("id: " + s)) {
                    JOptionPane.showMessageDialog(null, "Already registered user");
                    shouldPrint = false;
                    break;
                }
            }
            if (shouldPrint) {
                PrintWriter print;
                try {
                    print = new PrintWriter(new BufferedWriter(new FileWriter("Users.txt", TRUE)));
                    print.println("id: " + idNumberInput.getText());
                    print.println("password: " + pass.getText());
                    print.println("firstname: " + firstNameInput.getText());
                    print.println("lastName: " + lastNameInput.getText());
                    print.println("gender: " + genderInput.getText());
                    print.println("address: " + addressInput.getText());
                    print.println("nationality " + nationalityInput.getText());

                    print.close();

                    JOptionPane.showMessageDialog(null, "User information saved");

                    Person person = new Person(idNumberInput.getText(), firstNameInput.getText(), lastNameInput.getText(),
                            genderInput.getText(), addressInput.getText(), nationalityInput.getText());
                    Account a = new Account(person);
                    a.writeToFile(0, 0);

                    Window.window.swapPage(Window.Page.LOGIN);


                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String loggedInUser() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("LoggedIn.txt"));
        String loggedIn= input.readLine();
        return loggedIn;
    }

    public ArrayList<String> personFromFile(String loggedInUser) {

        ArrayList<String> personList = new ArrayList<String>();
        String id = "";
        String firstName = "";
        String lastName = "";
        String gender = "";
        String address = "";
        String nationality = "";

        try {
            BufferedReader input = new BufferedReader(new FileReader("Users.txt"));
            String line = input.readLine();
            while (line != null) {
                line = input.readLine();
                if (line.equalsIgnoreCase(loggedInUser)) {
                    id = line;
                    input.readLine();
                        firstName = input.readLine();
                        lastName = input.readLine();
                        gender = input.readLine();
                        address = input.readLine();
                        nationality = input.readLine();

                        personList.add(id);
                        personList.add(firstName);
                        personList.add(lastName);
                        personList.add(gender);
                        personList.add(address);
                        personList.add(nationality);
                    break;
                }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return personList;
    }

    public ArrayList<Integer> readAccount() throws IOException {

        ArrayList<Integer> accounts = new ArrayList<Integer>();
        int daily;
        int savingsAccount;

        BufferedReader input = new BufferedReader(new FileReader("LoggedIn.txt"));
        String loggedInUser = input.readLine();
        input = new BufferedReader(new FileReader(loggedInUser.substring(4) + ".txt"));
        daily = Integer.parseInt(input.readLine().substring(15));
        savingsAccount = Integer.parseInt(input.readLine().substring(17));

        accounts.add(daily);
        accounts.add(savingsAccount);

        return accounts;
    }


    public static void main(String[] args) throws IOException {

    }
}

