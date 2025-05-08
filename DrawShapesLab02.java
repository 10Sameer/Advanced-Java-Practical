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
