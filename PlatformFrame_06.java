import javax.swing.*;

public class PlatformFrame_06 extends JFrame {
    private JPanel buttonPanel;

    public PlatformFrame_06() {
        buttonPanel = new JPanel();

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();

        for (UIManager.LookAndFeelInfo info : infos) {
            makeButton(info.getName(), info.getClassName());
        }

        add(buttonPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void makeButton(String name, String className) {
        // Create button
        JButton jButton = new JButton(name);
        buttonPanel.add(jButton);

        // Set button action
        jButton.addActionListener(_ -> {    //event ko thau ma _ rakheko
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
                pack();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlatformFrame_06 frame = new PlatformFrame_06();
            frame.setVisible(true);
        });
    }
}