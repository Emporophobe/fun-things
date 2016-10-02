package View.PreferenceWidgets;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DJ on 10/1/2016.
 */
public class PeopleRangeWidget extends JPanel {
    JSpinner peopleSpinner;
    JLabel hyphen;
    int people = 1;

    public PeopleRangeWidget() {
        this.setLayout(new FlowLayout());
        peopleSpinner = new JSpinner(new SpinnerNumberModel(people, 1, 100, 1));
        this.add(peopleSpinner);
    }


    public int getValue() {
        return (int) peopleSpinner.getValue();
    }
}
