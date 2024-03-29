package simpleanimation;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.geom.*;

public class RtoJMorphing extends JPanel implements ActionListener {
    final int PANEL_WIDTH = 270;
    final int PANEL_HEIGHT = 470;
    
    Timer timer;
    int count = -50;
    double steps = 100;
    double stepsDouble = steps;
    
    double[] rx = new double[] {50, 50, 400, 50, 50,       55, 115, 200};
    double[] ry = new double[] {50, 250, 180, 450, 250,    250, 330, 450};
    double[] jx = new double[] {100, 240, 250, 240, 250,   100, 100, 240};
    double[] jy = new double[] {250, 50, 500, 50, 500,     50, 50, 50};
    
    double x[] = new double[jx.length];
    double y[] = new double[x.length];
    double alpha;
     
    public RtoJMorphing() {
        initAnimation(); 
    }
    
    private void initAnimation() {
        try {
            this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
            this.setBackground(new Color(255, 255, 255));
            initTimer();
        }
        
        catch (Exception ex) {
            Logger.getLogger(RtoJMorphing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void initTimer() {
        timer = new Timer(20, this);
        timer.start();
    }
     
    public void drawing(Graphics2D g2d) {
        QuadCurve2D.Double q1 = new QuadCurve2D.Double(x[0],y[0],x[2],y[2],x[1],y[1]);
        QuadCurve2D.Double q2 = new QuadCurve2D.Double(x[0],y[0],x[4],y[4],x[3],y[3]);
        QuadCurve2D.Double q3 = new QuadCurve2D.Double(x[5],y[5],x[6],y[6],x[7],y[7]);
        
        g2d.setColor(Color.GREEN);
        g2d.draw(q1);
        g2d.setColor(Color.BLUE);
        g2d.draw(q2);
        g2d.setColor(Color.RED);
        g2d.draw(q3);      
    }
     
    public void animation() {
        if (count < 0) {
            for (int j = 0; j < x.length; j++)
            {
                x[j] = rx[j];
                y[j] = ry[j];
            }
        }
        
        if (count >= 0 && count < steps) {
            alpha = count/stepsDouble;
            
            for (int j = 0; j < x.length; j++)
            {
                x[j] = (1-alpha)*rx[j] + alpha*jx[j];
                y[j] = (1-alpha)*ry[j] + alpha*jy[j];
            }
        }
        
        if (count == steps + 50) {
            count = -50; 
            x = new double[jx.length];
            y = new double[x.length];
        }
        
        count++;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5.0f));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawing(g2d); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        animation();
        repaint();
    }
}
