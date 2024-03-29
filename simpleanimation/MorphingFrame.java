package simpleanimation;

import javax.swing.*;

public class MorphingFrame extends JFrame {
    RtoJMorphing panel;
    
    public MorphingFrame() {
        panel = new RtoJMorphing();
        this.setTitle("Transforming R -> J");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocation(1200, 280);
        this.setVisible(true);
        this.setResizable(false);
    }
}
