package GUI;

import javax.swing.*;

public class Window extends JFrame{

    public Window() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}
