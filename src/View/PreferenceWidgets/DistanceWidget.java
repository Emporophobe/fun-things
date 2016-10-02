package View.PreferenceWidgets;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

/**
 * Created by DJ on 10/1/2016.
 */
public class DistanceWidget extends JPanel {
    private JSlider slider;
    private JLabel minLabel;
    private JLabel maxLabel;

    public DistanceWidget() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        minLabel = new JLabel("Min (km)");
        maxLabel = new JLabel("Max (km)");
        slider = new JSlider(0, 5);
        Hashtable labelTable = new Hashtable();
        for(int i = 1; i <= 5; i++){
            labelTable.put(i, new JLabel(Integer.toString(i)));
        }
        slider.setLabelTable(labelTable);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        this.add(slider, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(minLabel, constraints);
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.EAST;
        this.add(maxLabel, constraints);

    }

    public int getValue() {
        return this.slider.getValue();
    }
}
