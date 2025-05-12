import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonColorChanging {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Stylish Color-Changing Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // Define the button with custom rendering
        JButton button = new JButton("Click Me!") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                super.paintComponent(g);
                g2.dispose();
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.BLACK);
                g2.setStroke(new BasicStroke(2));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
                g2.dispose();
            }
        };

        // Style it
        button.setFont(new Font("SansSerif", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(200, 60));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false); // allow custom painting
        button.setOpaque(false);

        // Color cycle
        Color[] colors = {
            new Color(255, 99, 71),
            new Color(60, 179, 113),
            new Color(100, 149, 237),
            new Color(255, 215, 0),
            new Color(186, 85, 211)
        };
        final int[] index = { 0 };

        // Set initial background
        button.setBackground(colors[0]);

        // Change background on click
        button.addActionListener(e -> {
            index[0] = (index[0] + 1) % colors.length;
            button.setBackground(colors[index[0]]);
            button.repaint(); // repaint to apply new background
        });

        // Add to frame
        frame.add(button);
        frame.setVisible(true);
    }
}
