import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChangingButton {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Color Changing Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create the button
        JButton button = new JButton("Click Me!");

        
        // Set custom font, size, and padding
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setPreferredSize(new Dimension(200, 60));

        // Make it visually styled
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setOpaque(true);

        // Colors to cycle through
        Color[] colors = { Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.MAGENTA };
        final int[] colorIndex = { 0 };

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button.setBackground(colors[colorIndex[0]]);
                colorIndex[0] = (colorIndex[0] + 1) % colors.length;
            }
        });

        // Optional: make background color visible
        button.setOpaque(true);
        button.setBorderPainted(false);

        // Add button to frame
        frame.getContentPane().add(button);
        frame.setVisible(true);
    }
}
