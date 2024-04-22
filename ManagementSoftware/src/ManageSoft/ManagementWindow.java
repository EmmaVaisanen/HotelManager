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
