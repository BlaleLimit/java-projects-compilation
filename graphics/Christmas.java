import java.awt.geom.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Christmas extends Frame {
    static final int X = 400;
    static final int Y = 300;
    static double dist = 30;
    static int basex = 100;
    static int basey = 80;
    static int[] ballx = new int[] {X-55, X-55-70, X-55-130, X-55-190};
    static String greet = "Merry Christmas and Happy New Year!!!";
    
    // Window Closing functionality
    Christmas() {
        addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        });
    }
    
    public void paint(Graphics g) {
        // Actual code
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke (2.0f);
        g2d.setStroke(bs);
        
        // Draw General Path (Tree)
        GeneralPath tree = new GeneralPath();
        tree.moveTo(X, Y);  // left part
        tree.lineTo(X-50, Y+100);
        tree.lineTo(X-30, Y+100);
        tree.lineTo(X-100, Y+200);
        tree.lineTo(X-80, Y+200);
        tree.lineTo(X-150, Y+300);
        tree.lineTo(X-130, Y+300);
        tree.lineTo(X-200, Y+400);  // right part
        tree.lineTo(X+200, Y+400);
        tree.lineTo(X+130, Y+300);
        tree.lineTo(X+150, Y+300);
        tree.lineTo(X+80, Y+200);
        tree.lineTo(X+100, Y+200);
        tree.lineTo(X+30, Y+100);
        tree.lineTo(X+50, Y+100);
        tree.closePath();
        g2d.setColor(Color.GREEN);
        g2d.fill(tree);
        
        // Draw General Path (Star)
        GeneralPath star = new GeneralPath();
        star.moveTo(X, Y);
        star.lineTo(X+dist, Y-dist);
        star.lineTo(X, Y-2*dist);
        star.lineTo(X-dist, Y-dist);
        star.closePath();
        g2d.setColor(Color.YELLOW);
        g2d.fill(star);
        
        // Draw General Path (Base)
        GeneralPath base = new GeneralPath();
        base.moveTo(X-basex/2, Y+400);
        base.lineTo(X+basex/2, Y+400);
        base.lineTo(X+basex/2, Y+400+basey);
        base.lineTo(X-basex/2, Y+400+basey);
        base.closePath();
        g2d.setColor(Color.BLACK);
        g2d.fill(base);
        
        // Draw Circles (Ball)
        for (int i = 1; i < 4; i++) {
            Ellipse2D.Double b = new Ellipse2D.Double(ballx[0]+i*25, Y+90, 10, 10);
            g2d.setColor(Color.ORANGE);    
            g2d.fill(b);
        }
        
        int j = 0;
        int changex = 40;
        int changey = 100;
        while (j < 3) {
            for (int i = 1; i < 6; i++) {
                Ellipse2D.Double b = new Ellipse2D.Double(ballx[j+1]+i*changex, Y+90+changey, 10, 10);
                if (i%2 == 1)
                    g2d.setColor(Color.ORANGE);
                else
                    g2d.setColor(Color.BLUE);
                g2d.fill(b);
            }
            j++;
            changex += 20;
            changey += 100;
        }
        
        // Draw String (Merry Christmas)
        Font font = new Font("Arial", Font.PLAIN, 20);
        Rectangle2D.Double r = new Rectangle2D.Double(X-200, Y-30-2*dist-60, 400, 60);  // rectangle
        FontMetrics metrics = g.getFontMetrics(font);   // Font Metrics
        int posx = (int)(r.x + (r.width - metrics.stringWidth(greet)) / 2);
        g2d.setFont(font);
        g2d.setColor(Color.RED);
        g2d.drawString(greet, posx, Y-30-2*(int)Math.round(dist));
    }
    
    public static void main(String argv[]) {
        Christmas i = new Christmas();
        i.setTitle("Christmas Tree in Java");
        i.setBackground(Color.GRAY);
        i.setSize(800, 850);
        i.setResizable(false);
        i.setForeground(Color.GREEN);
        i.setVisible(true);
    }
}
