package View.PreferenceWidgets;

import FunThingGeneratorModel.Category;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

/**
 * Created by DJ on 10/1/2016.
 */
public class CategoryWidget extends JPanel {
    private static final int NUMBER_ROWS = 2;
    private static final int NUMBER_COLS = 4;

    public CategoryWidget() {
        LayoutManager layout = new GridLayout(NUMBER_ROWS, NUMBER_COLS);
        this.setLayout(layout);
        for (Category c : Category.values()) {
            CategoryWidgette w = new CategoryWidgette(c);
            this.add(w);
        }
    }

    public boolean somethingSelected() {
        for(Component c : this.getComponents()){
            CategoryWidgette w = (CategoryWidgette) c;
            if(w.checkBox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public void addEnablerToChildren(JButton entertainMeButton) {
        for(Component c : getComponents()){
            CategoryWidgette w = (CategoryWidgette) c;
            w.checkBox.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    entertainMeButton.setEnabled(somethingSelected());
                }
            });
        }
    }

    private class CategoryWidgette extends JPanel {
        private JCheckBox checkBox;

        CategoryWidgette(Category c) {
            this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            checkBox = new JCheckBox(c.name());
            this.add(checkBox);
        }
    }
}
