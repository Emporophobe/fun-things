package View;

import FunThingGeneratorModel.Generator;
import FunThingGeneratorModel.IFunThing;
import FunThingGeneratorModel.NoMatchException;
import View.PreferenceWidgets.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by DJ on 10/1/2016.
 */
public class CategoryForm extends JFrame {


    private JLabel peopleRangeLabel;
    private JLabel timeRangeLabel;
    private JLabel costLabel;
    private JLabel distanceLabel;
    private JLabel outsideLabel;
    private JLabel categoryLabel;
    private JLabel loadingLabel;

    private CategoryWidget categoryWidget = new CategoryWidget();

    private JPanel peopleRangeRow = new JPanel(new FlowLayout());
    private JPanel timeRangeRow = new JPanel(new FlowLayout());
    private JPanel costRow = new JPanel(new FlowLayout());
    private JPanel distanceRow = new JPanel(new FlowLayout());
    private JPanel outsideRow = new JPanel(new FlowLayout());
    private JPanel categoryRow = new JPanel(new FlowLayout());

    private ImageIcon loadingIcon = new ImageIcon("ajax-loader.gif");

    private JButton entertainMeButton;

    CategoryForm() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.peopleRangeLabel = new JLabel("Number of People: ");
        this.timeRangeLabel = new JLabel("Maximum Duration: ");
        this.costLabel = new JLabel("Maximum Cost: ");
        this.distanceLabel = new JLabel("Maximum Distance: ");
        this.outsideLabel = new JLabel("Wanna go outside?");
        this.categoryLabel = new JLabel("Categories: ");
        this.loadingLabel = new JLabel("when pacman stops chomping, it's loading", loadingIcon, JLabel.CENTER);
        this.peopleRangeLabel.setForeground(new Color(0, 255, 255));
        this.timeRangeLabel.setForeground(new Color(0, 255, 255));
        this.costLabel.setForeground(new Color(0, 255, 255));
        this.distanceLabel.setForeground(new Color(0, 255, 255));
        this.outsideLabel.setForeground(new Color(0, 255, 255));
        this.categoryLabel.setForeground(new Color(0, 255, 255));
        this.loadingLabel.setForeground(new Color(0, 255, 255));

        this.entertainMeButton = new JButton("ENTERTAIN ME");

        this.peopleRangeRow.add(peopleRangeLabel);
        this.timeRangeRow.add(timeRangeLabel);
        this.costRow.add(costLabel);
        this.distanceRow.add(distanceLabel);
        this.outsideRow.add(outsideLabel);
        this.categoryRow.add(categoryLabel);

        JPanel innerPanel;
        try {
            innerPanel = new BackgroundPanel(ImageIO.read(new File("resources/Preferences.png")));
        } catch (IOException e) {
            innerPanel = new JPanel();
        }
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
        innerPanel.add(Box.createVerticalStrut(100), BorderLayout.NORTH);
        recursiveBackground(peopleRangeRow);
        recursiveBackground(timeRangeRow);
        recursiveBackground(costRow);
        recursiveBackground(distanceRow);
        recursiveBackground(outsideRow);
        recursiveBackground(categoryRow);
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
                        costRangeWidget.getValue(), outsideWidget.getValue(), distanceWidget.getValue(),
                        categoryWidget.getValue());

                this.setVisible(false);
                new FunThingFrame(thing).setVisible(true);
                Preferences.loadData(peopleRangeWidget.getValue(), timeRangeWidget.getValue(),
                        costRangeWidget.getValue(), distanceWidget.getValue(), outsideWidget.getValue(),
                        categoryWidget.getValue());
                this.dispose();
            } catch (NoMatchException e1) {
                JOptionPane.showMessageDialog(this, e1.getMessage(), "No fun things found.", JOptionPane.ERROR_MESSAGE);
            }

        });
        this.entertainMeButton.setEnabled(false);
        this.add(innerPanel);
        this.setSize(View.WIDTH, View.HEIGHT);
    }

    private void recursiveBackground(Component c) {
        c.setBackground(Color.BLACK);
        if(c instanceof JPanel){
            for(Component comp : ((JPanel) c).getComponents()){
                recursiveBackground(comp);
            }
        }
    }
}
