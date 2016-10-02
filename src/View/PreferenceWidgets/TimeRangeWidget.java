package View.PreferenceWidgets;

import javax.swing.*;

/**
 * Created by DJ on 10/1/2016.
 */
public class TimeRangeWidget extends JPanel {
    JSpinner minuteSpinner;
    private int time = 10;

    public TimeRangeWidget() {
        minuteSpinner = new JSpinner(new SpinnerNumberModel(time, 0, 640, 10));
        JLabel row = new JLabel(" in minutes");
        this.add(minuteSpinner);
        this.add(row);
    }

    public int getValue() {
        return (int) minuteSpinner.getValue();
    }
}
