package View.PreferenceWidgets;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
        minPeopleSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int val = (int) minPeopleSpinner.getValue();
                if (val > (int) maxPeopleSpinner.getValue()) {
                    maxPeopleSpinner.setValue(val);
                }
            }
        });
        maxPeopleSpinner = new JSpinner(new SpinnerNumberModel(maxPeople, 1, 100, 1));
        maxPeopleSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int val = (int) maxPeopleSpinner.getValue();
                if (val < (int) minPeopleSpinner.getValue()) {
                    minPeopleSpinner.setValue(val);
                }
            }
        });
        hyphen = new JLabel("-");
        this.add(minPeopleSpinner);
        this.add(hyphen);
        this.add(maxPeopleSpinner);
    }


}
