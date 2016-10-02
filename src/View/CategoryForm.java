package View;

import FunThingGeneratorModel.Generator;
import FunThingGeneratorModel.IFunThing;
import FunThingGeneratorModel.NoMatchException;
import View.PreferenceWidgets.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

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
    JLabel loadingLabel;

    CategoryWidget categoryWidget = new CategoryWidget();

    JPanel peopleRangeRow = new JPanel(new FlowLayout());
    JPanel timeRangeRow = new JPanel(new FlowLayout());
    JPanel costRow = new JPanel(new FlowLayout());
    JPanel distanceRow = new JPanel(new FlowLayout());
    JPanel outsideRow = new JPanel(new FlowLayout());
    JPanel categoryRow = new JPanel(new FlowLayout());

    ImageIcon loadingIcon = new ImageIcon("ajax-loader.gif");

    JButton entertainMeButton;

    public CategoryForm() {
        this.peopleRangeLabel = new JLabel("Number of People: ");
        this.timeRangeLabel = new JLabel("Maximum Duration: ");
        this.costLabel = new JLabel("Maximum Cost: ");
        this.distanceLabel = new JLabel("Maximum Distance: ");
        this.outsideLabel = new JLabel("Wanna go outside?");
        this.categoryLabel = new JLabel("Categories: ");
        this.loadingLabel = new JLabel("when pacman stops chomping, it's loading", loadingIcon, JLabel.CENTER);

        this.entertainMeButton = new JButton("ENTERTAIN ME");

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
        PeopleRangeWidget peopleRangeWidget = new PeopleRangeWidget();
        TimeRangeWidget timeRangeWidget = new TimeRangeWidget();
        CostRangeWidget costRangeWidget = new CostRangeWidget();
        DistanceWidget distanceWidget = new DistanceWidget();
        OutsideOrNahWidget outsideWidget = new OutsideOrNahWidget();
        peopleRangeRow.add(peopleRangeWidget);
        timeRangeRow.add(timeRangeWidget);
        costRow.add(costRangeWidget);
        distanceRow.add(distanceWidget);
        outsideRow.add(outsideWidget);
        categoryRow.add(categoryWidget);
        innerPanel.add(preferences, BorderLayout.NORTH);
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        innerPanel.add(this.peopleRangeRow);
        innerPanel.add(this.timeRangeRow);
        innerPanel.add(this.costRow);
        innerPanel.add(this.distanceRow);
        innerPanel.add(outsideRow);
        innerPanel.add(this.categoryRow);
        innerPanel.add(this.entertainMeButton);
        innerPanel.add(loadingLabel);
        this.categoryWidget.addEnablerToChildren(this.entertainMeButton);
        this.entertainMeButton.addActionListener(e -> {

            try {
                IFunThing thing = Generator.generate(peopleRangeWidget.getValue(), timeRangeWidget.getValue(),
                        costRangeWidget.getValue(),outsideWidget.getValue(), categoryWidget.getValue());

                this.setVisible(false);
                new FunThingFrame(thing).setVisible(true);
                Preferences.loadData(peopleRangeWidget.getValue(), timeRangeWidget.getValue(),
                        costRangeWidget.getValue(),distanceWidget.getValue(),outsideWidget.getValue(),
                        categoryWidget.getValue());
                this.dispose();
            } catch (NoMatchException e1) {
                JOptionPane.showMessageDialog(this, e1.getMessage(), "No fun things found.",JOptionPane.ERROR_MESSAGE);
            }

        });
        this.entertainMeButton.setEnabled(false);
        this.add(innerPanel);
        this.setSize(View.WIDTH, View.HEIGHT);
    }

    private class MockFunThing implements IFunThing{

        @Override
        public String getName() {
            return "Watch cat videos.";
        }

        @Override
        public String getInfoString() {
            return "WATCH ALL THE CAT VIDEOS.";
        }
    }
}
