package View;

import FunThingGeneratorModel.IFunThing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DJ on 10/1/2016.
 */
public class FunThingFrame extends JFrame{
    JButton vetoButton;
    JButton acceptButton;
    public FunThingFrame(IFunThing thing) {
        vetoButton = new JButton("VETO!");
        acceptButton = new JButton("YES!");
        this.add(new FunThingPanel(thing), BorderLayout.CENTER);
        this.setSize(800,600);
        this.add(new ButtonDuo(acceptButton, vetoButton),BorderLayout.SOUTH);
    }

    private class ButtonDuo extends JPanel {
        public ButtonDuo(JButton leftButton, JButton rightButton) {
            this.setLayout(new FlowLayout());
            this.add(leftButton);
            this.add(rightButton);
        }
    }
}
