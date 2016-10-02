package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DJ on 10/1/2016.
 */
class LaunchWindow extends JFrame {
    private JButton leggoButton;
    private JButton exitButton;
    private JLabel title;
    private JPanel myPanel;
    private JLabel subtitle;

    LaunchWindow() {
        leggoButton = new JButton("LEGGO");
        exitButton = new JButton("BAIBAI");
        exitButton.addActionListener(e -> {
            this.setVisible(false);
            this.dispose();
        });
        leggoButton.addActionListener(e -> {
            this.setVisible(false);
            new CategoryForm().setVisible(true);
            this.dispose();
        });
        title = new JLabel("FUN THINGS GENERATOR");
        title.setFont(new Font("Comic Sans", Font.BOLD, 50));
        subtitle = new JLabel("For when you don't know how to have fun.");
        subtitle.setFont(new Font("Serif", Font.ITALIC, 30));
        myPanel = new JPanel();
        BoxLayout layout = new BoxLayout(myPanel, BoxLayout.Y_AXIS);
        myPanel.setLayout(layout);
        myPanel.add(title);
        myPanel.add(subtitle);
        myPanel.add(Box.createVerticalStrut(100));
        myPanel.add(leggoButton);
        myPanel.add(exitButton);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        leggoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setSize(View.WIDTH, View.HEIGHT);
        this.add(myPanel);
    }
}
