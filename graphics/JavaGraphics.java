import java.awt.geom.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JavaGraphics extends Frame {
    // Window Closing functionality
    JavaGraphics() {
        addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        });
    }
    
    public void paint(Graphics g) {
       // Custom color
        Color myColor = new Color(0.5f, 0.5f, 0.5f);
        
        // Actual code
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke (9.0f);
        g2d.setStroke(bs);
        g2d.setFont(new Font("Arial", Font.ITALIC, 19));
        g2d.drawString("Graphics in Java", 100, 80);
        
        // Draw rectangle
        Rectangle2D.Double r1 = new Rectangle2D.Double(500, 300, 200, 150);

        // Draw circle/ellipse Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        Ellipse2D.Double e1 = new Ellipse2D.Double (500, 380, 150, 100);

        // Draw Area
        Area a = new Area(r1);
        Area b = new Area(e1);
        a.add(b);
        // a.intersect(b);
        // a.exclusiveOr(b);    // symmetric difference
        // a.subtract(b);       // relative difference
        g2d.setColor(myColor);
        g2d.draw(a);
        g2d.setColor(Color.ORANGE);
        g2d.fill(a);
    }
    
      public static void main(String argv[]) {
        JavaGraphics i = new JavaGraphics();
        i.setTitle("Graphics in Java");
        i.setBackground(Color.LIGHT_GRAY);
        i.setSize(800, 800);
        i.setForeground(Color.BLUE);
        i.setVisible(true);
    }
}
