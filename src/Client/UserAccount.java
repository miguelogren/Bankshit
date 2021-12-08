package Client;

public class UserAccount {

    Person person;
    SavingsAccount savingsAccount;
    DailyAccount dailyAccount;

    public UserAccount(Person person){
        this.person = person;
    }


    public void writeToFile(){

    }

    public void payMoney(){

    }

    public int withdrawMoney(){
        return 0;
    }

    public void insertMoney(){

    }

    public UserAccount readFile(){
        return null;
    }

    public String showAccountBalance(){
        return "";
    }


}


