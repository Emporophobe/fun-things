package View.PreferenceWidgets;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DJ on 10/1/2016.
 */
public class OutsideOrNahWidget extends JPanel {
    JRadioButton sureButton;
    JRadioButton nahButton;
    boolean[] opts = new boolean[2];

    public OutsideOrNahWidget() {
        opts[0] = true;
        sureButton = new JRadioButton("Sure!", opts[0]);
        nahButton = new JRadioButton("Nah", opts[1]);
        ButtonGroup group = new ButtonGroup();
        group.add(sureButton);
        group.add(nahButton);
        this.add(sureButton);
        this.add(nahButton);
    }

    public boolean getValue() {
        return sureButton.isSelected();
    }
}
