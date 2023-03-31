package simpleanimation;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.geom.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ClockMoon extends JPanel implements ActionListener {
    final int PANEL_WIDTH = 780;
    final int PANEL_HEIGHT = 530;
    
    Timer timer;
    Image moon;
    int count = -20;
    double steps = 500;
    double stepsDouble = steps;
    boolean lunar = false;
    
    double frameSize = 100;
    double handLength = 40;
    double handWidth = 5;
     
    public ClockMoon() {
        initAnimation(); 
    }
    
    private void initAnimation() {
        try {
            this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
            this.setBackground(new Color(255, 255, 255));
            initTimer();
        }
        
        catch (Exception ex) {
            Logger.getLogger(ClockMoon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initTimer() {
        timer = new Timer(30, this);
        timer.start();
    }
    
    private void initImage() {
        try {
            moon = ImageIO.read(getClass().getResource("images/moon.png"));
        }
        catch (IOException ex) {
            Logger.getLogger(ClockMoon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void geometricTransform(Graphics2D g2d) {
        AffineTransform yUp = new AffineTransform();
        yUp.setToScale(1,-1);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(0, PANEL_HEIGHT);
        yUp.preConcatenate(translate);
        g2d.transform(yUp);
    }
    
    public void border(Graphics2D g2d) {
        Rectangle2D.Double windowFrame = new Rectangle2D.Double(50, 50, PANEL_WIDTH-100, PANEL_HEIGHT-100);
        g2d.draw(windowFrame);
    }
    
    public void drawing(Graphics2D g2d) {
        // Prepared clockFrame and clockHand
        Ellipse2D.Double clockFrame = new Ellipse2D.Double(-frameSize/2, -frameSize/2, frameSize, frameSize);
        Rectangle2D.Double clockHand = new Rectangle2D.Double(-handWidth/2, 0, handWidth, handLength);
        
        // Prepare moon
        initImage();
        
        // clockFrame translation
        AffineTransform singleTranslation = new AffineTransform();
        singleTranslation.setToTranslation(count*2+150, count*1+150);
        
        // clockHand accumulated rotation and translation
        AffineTransform singleRotation = new AffineTransform();
        singleRotation.setToRotation(-Math.toRadians(count*2));
        AffineTransform accumulatedRotationTranslation = new AffineTransform();
        accumulatedRotationTranslation.setTransform(singleRotation);
        accumulatedRotationTranslation.preConcatenate(singleTranslation);
        
        // moon accumulated rotation and translation
        AffineTransform moonRotationTranslation = new AffineTransform();
        moonRotationTranslation.setToTranslation(250, 250);
        moonRotationTranslation.preConcatenate(accumulatedRotationTranslation);

        if (!lunar) {
            // draw clockFrame and fill clockHand
            g2d.draw(singleTranslation.createTransformedShape(clockFrame));
            g2d.fill(accumulatedRotationTranslation.createTransformedShape(clockHand));
        }
        else {
            // drawImage moon
            g2d.drawImage(moon, moonRotationTranslation, this);
        }
    }
     
    public void animation() {
        lunar = count >= steps/2;
        
        if (count == steps-20) {
            count = -20;
        }
            
        count++;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4.0f));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        geometricTransform(g2d);
        border(g2d);
        drawing(g2d); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        animation();
        repaint();
    }
}
