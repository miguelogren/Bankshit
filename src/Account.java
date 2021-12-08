import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Account {
    Person person;
    ArrayList<Integer> accountList = new ArrayList<>();


    public void writeToFile(Person person, int daily, int savings) throws IOException {
        String fileName = person.getFirstName() + person.getLastName() + ".txt";
        PrintWriter printer;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();

        if (line != null) {
            int money = Integer.parseInt(line.substring(15));
            printer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, FALSE)));
            printer.println("Daily account: " + (daily + money));

            line = reader.readLine();
            money = Integer.parseInt(line.substring(17));
            printer.println("Savings account: " + (savings + money));

        } else {
            printer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, FALSE)));
            printer.println("Daily account: " + daily);
            printer.println("Savings account: " + savings);
        }

        printer.close();
    }

    public int getDailyAccount(Person person) throws IOException {
        String fileName = person.getFirstName() + person.getLastName() + ".txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int daily=0;
        String line = reader.readLine();

        while (reader.readLine() != null) {
            if (line.startsWith("D")) {
                daily = Integer.parseInt(line.substring(15));
            }
            reader.readLine();
        }
        return daily;
    }

    public int getSavingsAccount(Person person) throws IOException {
        String fileName = person.getFirstName() + person.getLastName() + ".txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int savings=0;

        while (reader.readLine() != null) {
            String line = reader.readLine();
            if (line.startsWith("S")) {
                savings = Integer.parseInt(line.substring(17));
            }
            reader.readLine();
        }
        return savings;
    }

    public void transferMoney() {

    }

    public static void main(String[] args) throws IOException {
        Person p = new Person("9412170137", "Erik", "Hollander", "Male", "Hamngatan 13a", "Sweden");
        Account a = new Account();
        a.writeToFile(p, 10000, 500);
        System.out.println(a.getDailyAccount(p));
        System.out.println(a.getSavingsAccount(p));

    }

}


