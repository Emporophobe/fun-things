package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by DJ on 10/1/2016.
 */
public class ImagePanel extends JPanel {
    private BufferedImage image;
    ImagePanel(BufferedImage image){
        this.image = image;
        Icon icon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(icon);
        this.add(imageLabel);
        this.setSize(image.getWidth(),image.getHeight());
    }
}
