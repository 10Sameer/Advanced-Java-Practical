import javax.swing.*;
import java.awt.*;

public class ImageTest {
    class ImageComponent extends JComponent {
        public static final int DEFAULT_HEIGHT = 400;
        public static final int DEFAULT_WIDTH = 400;
        private Image image;

        public ImageComponent() {
            image = new ImageIcon("image.gif").getImage();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);  
            if (image == null) return;

            int imageWidth = image.getWidth(this);
            int imageHeight = image.getHeight(this);
              
              for (int i = 0; i * imageWidth <= getWidth(); i++) {
                for (int j = 0; j * imageHeight <= getHeight(); j++) {
                    g.drawImage(image, i * imageWidth, j * imageHeight, this);
                }
            }
        }

        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sameer Bhandari");
        ImageComponent component = new ImageTest().new ImageComponent();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(component);
        frame.pack();
        frame.setVisible(true);
    }
}