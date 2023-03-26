package ooad.uml.editor.graphics.UML.basicObject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;

public class ClassObject extends BasicObject {
    private final Rectangle2D outerRectangle;
    private final Rectangle2D innerRectangle;
    private static final int width = 120;
    private static final int height = 150;
    
    public ClassObject(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY, new JLabel("Class", JLabel.CENTER));
        outerRectangle = new Rectangle2D.Double(0, 0, width, height);
        double borderSize = 1.5;
        innerRectangle = new Rectangle2D.Double(borderSize, borderSize, width - borderSize*2, height - borderSize*2);
        
        this.setSize(width, height); // **Without it, the object will not be drawn since it sets the JPanel's size**
        this.name.setBounds(0, 0, width, height / 3);
        this.setLayout(null);
        this.setOpaque(false);
        this.setVisible(true);
    }

    @Override
    public void drawObject(Graphics2D g2) {
        g2.setPaint(borderColor);
        g2.fill(outerRectangle);
        g2.setPaint(objectColor);
        g2.fill(innerRectangle);

        Line2D line1 = new Line2D.Double(0, height / 3, width, height / 3);
        Line2D line2 = new Line2D.Double(0, height*2 / 3, width, height*2 /3);
        g2.setPaint(borderColor);
        g2.draw(line1);
        g2.draw(line2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        this.drawObject(g2);
    }
    
    @Override
    public boolean isInObject(MouseEvent e) {
        return this.outerRectangle.contains(e.getX(), e.getY());
    }
}
