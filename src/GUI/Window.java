package GUI;

import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        setTitle("Bank");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
