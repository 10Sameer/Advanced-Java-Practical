//1.8 TextComponentFrame.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextComponentFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Component Example: Sameer");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        JLabel label = new JLabel("Enter Text:");
        JTextField textField = new JTextField(20);
        JTextArea textArea = new JTextArea(5, 20);
        JButton button = new JButton("Submit");
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("You entered: " + textField.getText());
            }
        });
        
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.add(new JScrollPane(textArea));
        
        frame.add(panel);
        frame.setVisible(true);
    }
}