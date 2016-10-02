package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by DJ on 10/1/2016.
 */
class LaunchWindow extends JFrame {
    private JButton leggoButton;
    private JButton exitButton;
    private Component title;
    private JPanel myPanel;

    LaunchWindow() {
        try {
            leggoButton = new JButton(new ImageIcon(ImageIO.read(new File("resources/Start.png"))));
            leggoButton.setBackground(Color.BLACK);
            leggoButton.setBorder(BorderFactory.createEmptyBorder());
        } catch (IOException e) {
            leggoButton = new JButton("Click Here");
        }
        try {
            exitButton = new JButton(new ImageIcon(ImageIO.read(new File("resources/Quit.png"))));
            exitButton.setBackground(Color.BLACK);
            exitButton.setBorder(BorderFactory.createEmptyBorder());
        } catch (IOException e) {
            exitButton = new JButton("No Thanks");
        }
        exitButton.addActionListener(e -> {
            this.setVisible(false);
            this.dispose();
        });
        leggoButton.addActionListener(e -> {
            this.setVisible(false);
            new CategoryForm().setVisible(true);
            this.dispose();
        });

        try {
            myPanel = new BackgroundPanel(ImageIO.read(new File("resources/Main_background.png")));
        } catch (IOException e) {
            myPanel = new JPanel();
        }
        myPanel.setLayout(new GridLayout(2,3));
        myPanel.add(Box.createHorizontalStrut(300));
        myPanel.add(Box.createHorizontalStrut(300));
        myPanel.add(leggoButton);
        myPanel.add(Box.createHorizontalStrut(300));
        myPanel.add(Box.createHorizontalStrut(300));
        myPanel.add(exitButton);
        leggoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setSize(View.WIDTH, View.HEIGHT);
        this.add(myPanel);
    }
}
