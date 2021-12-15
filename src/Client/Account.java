package Client;

import java.io.*;
import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Account {


    Person person;

    public Account (Person person){
        this.person = person;
    }


    public void writeToFile(int daily, int savings) throws IOException {
        String fileName;

        if (person.getIdNumber().startsWith("i")) {
            fileName = person.getIdNumber().substring(4) + ".txt";
        }else{
            fileName = person.getIdNumber() +".txt";
        }

        PrintWriter printer; //= new PrintWriter(new BufferedWriter(new FileWriter(fileName, TRUE)));
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

    public int getDailyAccount() throws IOException {
        String fileName = person.getIdNumber().substring(4) + ".txt";
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

    public int getSavingsAccount() throws IOException {
        String fileName = person.getIdNumber().substring(4)+ ".txt";
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

    public void transferMoney(int amount, String fromAcc, String ToAcc) throws IOException {
        String fileName = person.getIdNumber().substring(4)+ ".txt";
        PrintWriter printer;
        int newDaily;
        int newSavings;


        if(fromAcc.startsWith("D")){
                    newDaily = getDailyAccount() - amount;
                    newSavings = getSavingsAccount() + amount;
                    printer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, FALSE)));
                    printer.println("Daily account: " + newDaily);
                    printer.println("Savings account: " + newSavings);
                    printer.close();

        }else{
            newDaily = getDailyAccount() + amount;
            newSavings = getSavingsAccount() - amount;
            printer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, FALSE)));
            printer.println("Daily account: " + newDaily);
            printer.println("Savings account: " + newSavings);
            printer.close();
        }
    }
}


