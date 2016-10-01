package View.PreferenceWidgets;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DJ on 10/1/2016.
 */
public class PeopleRangeWidget extends JPanel {
    JSpinner minPeopleSpinner;
    JSpinner maxPeopleSpinner;
    JLabel hyphen;
    int minPeople = 1;
    int maxPeople = 1;

    public PeopleRangeWidget() {
        this.setLayout(new FlowLayout());
        minPeopleSpinner = new JSpinner(new SpinnerNumberModel(minPeople, 1, 100, 1));
        maxPeopleSpinner = new JSpinner(new SpinnerNumberModel(maxPeople, 1, 100, 1));
        hyphen = new JLabel("-");
        this.add(minPeopleSpinner);
        this.add(hyphen);
        this.add(maxPeopleSpinner);
    }


}
