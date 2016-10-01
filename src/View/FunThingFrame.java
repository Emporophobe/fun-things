package View;

import FunThingGeneratorModel.IFunThing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DJ on 10/1/2016.
 */
public class FunThingFrame extends JFrame{
    public FunThingFrame(IFunThing thing) {
        this.add(new FunThingPanel(thing), BorderLayout.CENTER);
        this.setSize(800,600);
    }
}
