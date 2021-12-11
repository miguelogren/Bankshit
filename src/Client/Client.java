package Client;

import GUI.Window;

public class Client {

    Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public static void main(String[] args) {
        Window window = new Window();
        window.swapPage(Window.Page.LOGIN);
    }
}
