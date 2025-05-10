import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SliderFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sameer Bhandari");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        JLabel label = new JLabel("Value: 50");
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                label.setText("Value: " + slider.getValue());
            }
        });
        
        panel.add(slider);
        panel.add(label);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}