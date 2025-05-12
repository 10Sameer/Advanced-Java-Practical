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

        // Colors to cycle through
   