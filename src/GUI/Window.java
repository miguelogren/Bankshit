package GUI;

import Client.Client;

import javax.swing.*;
import javax.xml.transform.Transformer;
import java.awt.*;
import java.io.IOException;


public class Window extends JFrame{
    //public static Window window;
    public enum Page {
        LOGIN,
        CREATEUSER,
        ACCOUNTOVERVIEW,
    }

    JPanel currentPage = new JPanel();

    public Window() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(400,500);
        setBackground(Color.DARK_GRAY);

    }
    public void swapPage(Page page) throws IOException {
        remove(currentPage);
        switch (page) {
            case LOGIN: {
                currentPage = new LogIn();
                break;
            }
            case CREATEUSER: {
                currentPage = new CreateUser();
                Client.window.setPreferredSize(new Dimension(500,700));
                break;
            }
            case ACCOUNTOVERVIEW: {
                currentPage = new AccountOverview();
                break;
            }
        }
        add(currentPage);
        revalidate();
    }

    /*public static void main(String[] args) throws IOException {
        window = new Window();
        window.swapPage(Page.LOGIN);
    }*/

}
