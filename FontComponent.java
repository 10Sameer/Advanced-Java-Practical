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
        String message = "Hello, World!";
        Font f = new Font("Serif", Font.BOLD, 36);
        g2.setFont(f);
        
        // Measure the size of the message
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(message, context);
        
        // Set (x, y) - top left corner of text
     