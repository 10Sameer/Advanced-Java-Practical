import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class FontComponent extends JComponent {
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        String message = "Hello, Im Sameer Bhandari";
        Font f = new Font("Serif", Font.BOLD, 36);
        g2.setFont(f);
        
        // Measure the size of the message
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(message, context);
        
        // Set (x, y) - top left corner of text
        double x = (getWidth() - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getHeight()) / 2;
        
        // Add ascent to y to reach the baseline
        double ascent = -bounds.getY();
        double baseY = y + ascent;
        
        // Fill rectangle with yellow
        g2.setColor(Color.RED);
        g2.fillRect((int) x - 10, (int) (baseY - ascent - 10), (int) bounds.getWidth() + 20, (int) bounds.getHeight() + 20);
        
        // Set font color to blue
        g2.setColor(Color.GREEN);
        g2.drawString(message, (float) x, (float) baseY);
        
        // Draw a red line below the text
        g2.setColor(Color.BLACK);
        double lineY = baseY + 2; 
        g2.drawLine((int) x, (int) lineY, (int) (x + bounds.getWidth()), (int) lineY);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new FontComponent());
        frame.pack();
        frame.setVisible(true);
    }
}