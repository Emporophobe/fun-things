package View;

import FunThingGeneratorModel.Generator;
import FunThingGeneratorModel.IFunThing;
import FunThingGeneratorModel.NoMatchException;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DJ on 10/1/2016.
 */
public class FunThingFrame extends JFrame{
    JButton vetoButton;
    JButton acceptButton;
    FunThingPanel ftPanel;
    public FunThingFrame(IFunThing thing) {
        vetoButton = new JButton("VETO!");
        acceptButton = new JButton("YES!");
        acceptButton.addActionListener(e->{
            JOptionPane.showMessageDialog(this, "CONGRATULATIONS!!! \n" +
                    "You have selected a fun thing!!! \n" +
                    "Go do the thing! \n" +
                    "omg you're going to have so much fun");
        });
        vetoButton.addActionListener(e->{try {
            IFunThing f = Generator.generate(Preferences.getPeople(),Preferences.getMinutes(),Preferences.getCost(),
                    Preferences.isOutside(),Preferences.getCategories());
            System.out.println(f.getName());
            ftPanel.setVisible(false);
            this.remove(ftPanel);
            this.ftPanel = new FunThingPanel(f);
            this.add(this.ftPanel);
            this.revalidate();
            this.repaint();
        } catch (NoMatchException e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage(), "No fun things found.",JOptionPane.ERROR_MESSAGE);
        }});
        ftPanel = new FunThingPanel(thing);
        this.add(ftPanel, BorderLayout.CENTER);
        this.setSize(View.WIDTH,View.HEIGHT);
        this.add(new ButtonRow(acceptButton, vetoButton),BorderLayout.SOUTH);
    }

    private class ButtonRow extends JPanel {
        public ButtonRow(JButton ... buttons) {
            this.setLayout(new FlowLayout());
            for(JButton button : buttons){
                this.add(button);
            }
        }
    }
}
