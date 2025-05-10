//lab 1.7 calculator
import javax.swing.*;
import java.awt.*;

public class CalculatorPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sameer Bhandari");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5)); // 4x4 Grid Layout with spacing

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            panel.add(new JButton(text));
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}