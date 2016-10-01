package View.PreferenceWidgets;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

/**
 * Created by DJ on 10/1/2016.
 */
public class CostRangeWidget extends JPanel {
    JSlider slider;
    Hashtable tickLabels = new Hashtable();

    public CostRangeWidget() {
        slider = new JSlider(0, 4);
        this.add(slider);
        tickLabels.put(new Integer(0), new JLabel("FREE"));
        tickLabels.put(new Integer(1), new JLabel("$"));
        tickLabels.put(new Integer(2), new JLabel("$$"));
        tickLabels.put(new Integer(3), new JLabel("$$$"));
        tickLabels.put(new Integer(4), new JLabel("$$$$"));
        slider.setLabelTable(tickLabels);
        slider.setMajorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
    }
}
