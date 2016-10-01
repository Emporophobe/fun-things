package View;

import FunThingGeneratorModel.IFunThing;
import com.sun.javafx.iio.ImageStorage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by DJ on 10/1/2016.
 */
public class FunThingPanel extends JPanel {
    private ImagePanel image;
    private JLabel title;
    private JTextArea info;

    public FunThingPanel(IFunThing thing){
        BufferedImage image = new BufferedImage(800,600, BufferedImage.TYPE_INT_RGB);
        try {
            image = ImageIO.read(new URL("http://kurld.com/images/cats%20cute/cats%20cute-1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.image = new ImagePanel(image);
        this.title = new JLabel(thing.getName());
        this.title.setFont(new Font("Arial", Font.BOLD, 50));
        this.info = new JTextArea();
        this.info.setEditable(false);
        this.info.setText(thing.getInfoString());
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(this.image, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        this.add(this.title, c);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.fill = GridBagConstraints.BOTH;
        this.add(this.info, c);
    }
}
