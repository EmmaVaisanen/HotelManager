package ManageSoft;

import javax.swing.*;

public class Program extends JFrame {
    ManagementWindow window;
    public Program(){
        window = new ManagementWindow();
        add(window);
        setResizable(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        window.start();
    }
    public static void main(String[] args) {Program program = new Program();}
}
