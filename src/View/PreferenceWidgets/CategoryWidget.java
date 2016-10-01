package View.PreferenceWidgets;

import FunThingGeneratorModel.Category;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

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

    private class CategoryWidgette extends JPanel {
        private JCheckBox checkBox;

        CategoryWidgette(Category c) {
            this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            checkBox = new JCheckBox(c.name());
            this.add(checkBox);
        }
    }
}
