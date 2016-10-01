package View.PreferenceWidgets;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DJ on 10/1/2016.
 */
public class OutsideOrNahWidget extends JPanel {
    JRadioButton sureButton;
    JRadioButton nahButton;
    JRadioButton mandatoryButton;
    boolean[] opts = new boolean[3];

    public OutsideOrNahWidget() {
        sureButton = new JRadioButton("Sure!", opts[0]);
        nahButton = new JRadioButton("Nah", opts[1]);
        mandatoryButton = new JRadioButton("THIS IS NECESSARY", opts[2]);
        ButtonGroup group = new ButtonGroup();
        group.add(sureButton);
        group.add(nahButton);
        group.add(mandatoryButton);
        this.add(sureButton);
        this.add(nahButton);
        this.add(mandatoryButton);
    }
}
