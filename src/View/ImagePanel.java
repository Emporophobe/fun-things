package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by DJ on 10/1/2016.
 */
class ImagePanel extends JPanel {
    private BufferedImage image;

    ImagePanel(BufferedImage image, int width, int height) {
        this.image = resizeImage(image, width, height);
        Icon icon = new ImageIcon(this.image);
        JLabel imageLabel = new JLabel(icon);
        this.add(imageLabel);
        this.setSize(image.getWidth(), image.getHeight());
    }

    private BufferedImage resizeImage(BufferedImage image, int width, int height) {
        Image tmp = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}