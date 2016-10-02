package View;

import FunThingGeneratorModel.IFunThing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by DJ on 10/1/2016.
 */
class FunThingPanel extends JPanel {
    private ImagePanel image;
    private JLabel title;
    private JTextPane info;

    FunThingPanel(IFunThing thing) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        BufferedImage image = new BufferedImage(View.WIDTH, View.HEIGHT, BufferedImage.TYPE_INT_RGB);
        try {
            image = ImageIO.read(new URL(thing.getImageSource()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.image = new ImagePanel(image, 400, 300);
        this.image.setAlignmentX(CENTER_ALIGNMENT);
        this.title = new JLabel(wordWrapper(thing.getName()));
        this.title.setFont(new Font("Arial", Font.BOLD, 50));
        this.title.setHorizontalAlignment(JLabel.CENTER);
        this.title.setAlignmentX(CENTER_ALIGNMENT);
        this.info = new JTextPane();
        this.info.setContentType("text/html");
        this.info.setEditable(false);
        this.info.setText("<html>" + replaceNewLines(thing.getInfoString()) + "</html>");
        this.info.setMaximumSize(new Dimension(50 * 15, 300));
        this.add(this.image);
        this.makeBlack();
        this.add(this.title);
        JScrollPane scroll = new JScrollPane(this.info);
        scroll.setMinimumSize(new Dimension(50 * 15, 300));
        scroll.setMaximumSize(new Dimension(50 * 15, 300));
        scroll.setAlignmentX(CENTER_ALIGNMENT);
        this.add(scroll);
    }

    private String replaceNewLines(String infoString) {
        return infoString.replaceAll("\n", "<br>");
    }

    private String wordWrapper(String name) {
        StringBuilder b = new StringBuilder();
        b.append("<html><center>");
        String[] split = name.split(" ");
        int charCount = 0;
        for (int i = 0; i < split.length; i++) {
            String word = split[i];
            charCount += word.length();
            b.append(word);
            if (charCount > 15 && i != 0) {
                b.append("<br>");
                charCount = 0;
            }
            if(i != split.length - 1){
                b.append(" ");
            }

        }
        b.append("</center></html>");
        return b.toString();
    }

    public void makeBlack() {
        for(Component c : getComponents()){
            c.setBackground(Color.BLACK);
        }
    }
}
