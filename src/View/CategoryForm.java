package View;

import View.PreferenceWidgets.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DJ on 10/1/2016.
 */
public class CategoryForm extends JFrame {
    JLabel peopleRangeLabel;
    JLabel timeRangeLabel;
    JLabel costLabel;
    JLabel distanceLabel;
    JLabel outsideLabel;
    JLabel categoryLabel;

    JPanel peopleRangeRow = new JPanel(new FlowLayout());
    JPanel timeRangeRow = new JPanel(new FlowLayout());
    JPanel costRow = new JPanel(new FlowLayout());
    JPanel distanceRow = new JPanel(new FlowLayout());
    JPanel outsideRow = new JPanel(new FlowLayout());
    JPanel categoryRow = new JPanel(new FlowLayout());

    JButton entertainMeButton;

    public CategoryForm() {
        this.peopleRangeLabel = new JLabel("Number of People: ");
        this.timeRangeLabel = new JLabel("Maximum Duration: ");
        this.costLabel = new JLabel("Maximum Cost: ");
        this.distanceLabel = new JLabel("Maximum Distance: ");
        this.outsideLabel = new JLabel("Wanna go outside?");
        this.categoryLabel = new JLabel("Categories: ");

        this.entertainMeButton = new JButton("ENTERAIN ME");

        this.peopleRangeRow.add(peopleRangeLabel);
        this.timeRangeRow.add(timeRangeLabel);
        this.costRow.add(costLabel);
        this.distanceRow.add(distanceLabel);
        this.outsideRow.add(outsideLabel);
        this.categoryRow.add(categoryLabel);

        JPanel innerPanel = new JPanel();
        JLabel preferences = new JLabel("PREFERENCES: ");
        preferences.setFont(new Font("Serif", Font.BOLD, 50));
        preferences.setAlignmentX(Component.CENTER_ALIGNMENT);
        peopleRangeRow.add(new PeopleRangeWidget());
        timeRangeRow.add(new TimeRangeWidget());
        costRow.add(new CostRangeWidget());
        distanceRow.add(new DistanceWidget());
        outsideRow.add(new OutsideOrNahWidget());
        categoryRow.add(new CategoryWidget());
        innerPanel.add(preferences, BorderLayout.NORTH);
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        innerPanel.add(this.peopleRangeRow);
        innerPanel.add(this.timeRangeRow);
        innerPanel.add(this.costRow);
        innerPanel.add(this.distanceRow);
        innerPanel.add(outsideRow);
        innerPanel.add(this.categoryRow);
        innerPanel.add(this.entertainMeButton);
        this.add(innerPanel);
        this.setSize(800, 600);
    }

}
