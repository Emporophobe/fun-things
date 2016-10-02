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
    JButton backButton;
    JButton vetoButton;
    JButton acceptButton;
    FunThingPanel ftPanel;
    public FunThingFrame(IFunThing thing) {
        backButton = new JButton("BACK");
        backButton.addActionListener(e->{
            this.setVisible(false);
            new CategoryForm().setVisible(true);
        });
        vetoButton = new JButton("VETO!");
        acceptButton = new JButton("YES!");
        vetoButton.addActionListener(e->{try {
            IFunThing f = Generator.generate(Preferences.getPeople(),Preferences.getMinutes(),Preferences.getCost(),
                    Preferences.isOutside(),Preferences.getCategories());
            this.remove(ftPanel);
            this.add(new FunThingPanel(f));
            this.revalidate();
            this.repaint();
        } catch (NoMatchException e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage(), "No fun things found.",JOptionPane.ERROR_MESSAGE);
        }});
        ftPanel = new FunThingPanel(thing);
        this.add(ftPanel, BorderLayout.CENTER);
        this.setSize(View.WIDTH,View.HEIGHT);
        this.add(new ButtonDuo(acceptButton, vetoButton),BorderLayout.SOUTH);
        this.add(backButton, BorderLayout.NORTH);
    }

    private class ButtonDuo extends JPanel {
        public ButtonDuo(JButton leftButton, JButton rightButton) {
            this.setLayout(new FlowLayout());
            this.add(leftButton);
            this.add(rightButton);
        }
    }
}
