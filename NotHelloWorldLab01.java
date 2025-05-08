//lab1.1 
import javax.swing.*;  
import java.awt.*;     

public class NotHelloWorldLab01 {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new NotHelloWorldFrame();
            frame.setTitle("Sameer Bhandari");  
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);  
        });
        //WindowListener
       //ActionListener

    }
}

class NotHelloWorldFrame extends JFrame {
    public NotHelloWorldFrame() {
        add(new NotHelloWorldComponent());
        pack();
    }
}

class NotHelloWorldComponent extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g); 
        Font sansbold14 = new Font("SansSerif", Font.BOLD,30);
        g2.setFont(sansbold14); 
        g2.drawString("Not a Hello, world program", MESSAGE_X, MESSAGE_Y);  
    }

    @Override
    public Dimension getPreferredSize() {  
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);  
    }
}