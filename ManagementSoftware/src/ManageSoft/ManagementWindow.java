package ManageSoft;

import javax.swing.*;
import java.awt.*;

public class ManagementWindow extends JComponent {

    //TODO Add JList of room categories
    //TODO More JLables
    //TODO Add Custom logotype


    private final int FPS = 40;
    private Manager manager;
    private Keyboard keyboard;
    private JLabel hotelLogo;

    public ManagementWindow(){
        keyboard = new Keyboard();
        manager = new Manager(this);

        hotelLogo = new JLabel();
        hotelLogo.setForeground(Color.RED);
        hotelLogo(new Font("Arial", Font.BOLD, 120));
        hotelLogo.setBounds(0, 0, 150, 50);
        add(hotelLogo);


    }

    private void hotelLogo(Font arial) {
        hotelLogo.setText("Hotel Demonstration!");
    }

    @Override
    public Dimension getPreferredSize() {return new Dimension(800, 600);}

    @Override
    protected void paintComponent(Graphics arg0){
        super.paintComponent(arg0);
        Graphics2D graphics = (Graphics2D)arg0;
        graphics.setColor(Color.gray);
        graphics.fillRect(0, 0, getWidth(), getHeight());

    }

    public void start(){
        JFrame frame = new JFrame("Example");
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        JMenuItem exitItem = new JMenuItem("Exit");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem removeItem = new JMenuItem("Remove");
        JMenuItem editItem = new JMenuItem("Edit");

        fileMenu.add(exitItem);

        editMenu.add(newItem);
        editMenu.add(editItem);
        editMenu.add(removeItem);


        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setJMenuBar(menuBar);

        frame.add(this);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while(true) {
            manager.update(keyboard);
            try {
                Thread.sleep(1000 / FPS); //Throttle thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
