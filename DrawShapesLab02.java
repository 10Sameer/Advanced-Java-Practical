//lab 1.2 DrawShape
import javax.swing.*;
import java.awt.*;

public class DrawShapesLab02 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("2D Shapes in Swing: Sameer Bhandari");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.add(new ShapesComponent());
            frame.setVisible(true);
        });
    }
}

class ShapesComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Set color and draw a rectangle
        g2.setColor(Color.PINK);
        g2.fillRect(50, 50, 100, 50);  // (x, y, width, height)

        // Set color and draw an oval
        g2.setColor(Color.BLACK);
        g2.fillOval(200, 50, 100, 50);

        // Draw a line
        g2.setColor(Color.RED);
        g2.drawLine(50, 150, 300, 150);

        // Draw a circle
        g2.setColor(Color.YELLOW);
        g2.fillOval(100, 200, 80, 80);

        // Draw a polygon (triangle)
        int[] xPoints = {150, 250, 200};
        int[] yPoints = {300, 300, 250};
        g2.setColor(Color.ORANGE);
        g2.fillPolygon(xPoints, yPoints, 3);
    }
}