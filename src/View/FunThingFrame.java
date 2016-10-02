package View;

import FunThingGeneratorModel.Generator;
import FunThingGeneratorModel.IFunThing;
import FunThingGeneratorModel.NoMatchException;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DJ on 10/1/2016.
 */
class FunThingFrame extends JFrame {
    private JButton backButton;
    private JButton vetoButton;
    private JButton acceptButton;
    private FunThingPanel ftPanel;
    private JLabel loadingLabel;
    private JPanel bottomPanel = new JPanel(new GridLayout(0, 1));

    private ImageIcon loadingIcon = new ImageIcon("ajax-loader.gif");

    FunThingFrame(IFunThing thing) {
        backButton = new JButton("BACK");
        backButton.addActionListener(e -> {
            this.setVisible(false);
            new CategoryForm().setVisible(true);
        });
        vetoButton = new JButton("VETO!");
        acceptButton = new JButton("YES!");
        acceptButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "CONGRATULATIONS!!! \n" +
                    "You have selected a fun thing!!! \n" +
                    "Go do the thing! \n" +
                    "omg you're going to have so much fun");
        });
        vetoButton.addActionListener(e -> {
            try {
                System.out.println(Preferences.getCategories());
                IFunThing f = Generator.generate(Preferences.getPeople(), Preferences.getMinutes(), Preferences.getCost(),
                        Preferences.isOutside(), Preferences.getDistance(), Preferences.getCategories());
                remove(ftPanel);
                this.ftPanel =new FunThingPanel(f);
                this.add(this.ftPanel);
                this.revalidate();
                this.repaint();
            } catch (NoMatchException e1) {
                JOptionPane.showMessageDialog(this, e1.getMessage(), "No fun things found.", JOptionPane.ERROR_MESSAGE);
            }
        });
        ftPanel = new FunThingPanel(thing);
        this.add(ftPanel, BorderLayout.CENTER);
        this.setSize(View.WIDTH, View.HEIGHT);
        this.loadingLabel = new JLabel("when pacman stops chomping, it's loading", loadingIcon, JLabel.CENTER);
        bottomPanel.add(new ButtonRow(backButton, acceptButton, vetoButton));
        bottomPanel.add(loadingLabel);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.ftPanel.makeBlack();
        this.setBackground(Color.BLACK);
        this.setForeground(Color.BLACK);
    }

    private class ButtonRow extends JPanel {
        ButtonRow(JButton... buttons) {
            this.setLayout(new FlowLayout());
            for (JButton button : buttons) {
                this.add(button);
            }
        }
    }
}
