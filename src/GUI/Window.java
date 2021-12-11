package GUI;

import javax.swing.*;
import javax.xml.transform.Transformer;
import java.awt.*;


public class Window extends JFrame{
    public static Window window;
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
        setSize(500,700);

    }
    public void swapPage(Page page) {
        remove(currentPage);
        switch (page) {
            case LOGIN: {
                currentPage = new LogIn();
                break;
            }
            case CREATEUSER: {
                currentPage = new CreateUser();
                window.setPreferredSize(new Dimension(500,700));
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

    public static void main(String[] args) {
        window = new Window();
        window.swapPage(Page.LOGIN);
    }

}
