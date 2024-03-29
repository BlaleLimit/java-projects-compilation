package simpleanimation;

import javax.swing.*;

public class ClockFrame extends JFrame {
    ClockMoon panel;
    
    public ClockFrame() {
        panel = new ClockMoon();
        this.setTitle("Geometric Transformation Animation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocation(420, 250);
        this.setVisible(true);
        this.setResizable(false);
    }
}
