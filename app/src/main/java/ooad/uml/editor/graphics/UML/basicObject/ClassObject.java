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
    
    public ClassObject(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
        this.setSize(120, 150); // **Without it, the object will not be drawn since it sets the JPanel's size**

        outerRectangle = new Rectangle2D.Double(0, 0, this.getWidth(), this.getHeight());
        double borderSize = 1.5;
        innerRectangle = new Rectangle2D.Double(borderSize, borderSize, this.getWidth() - borderSize*2, this.getHeight() - borderSize*2);
        
        super.setConnectionPorts();
        this.name = new JLabel("Class", JLabel.CENTER);
        this.add(name);
        this.name.setBounds(0, 0, this.getWidth(), this.getHeight() / 3);
        this.setLayout(null);
        this.setOpaque(false);
        this.setVisible(true);
    }

    @Override
    protected void drawObject(Graphics2D g2) {
        g2.setPaint(BORDER_COLOR);
        g2.fill(outerRectangle);
        g2.setPaint(OBJECT_COLOR);
        g2.fill(innerRectangle);

        Line2D line1 = new Line2D.Double(0, this.getHeight() / 3, this.getWidth(), this.getHeight() / 3);
        Line2D line2 = new Line2D.Double(0, this.getHeight()*2 / 3, this.getWidth(), this.getHeight()*2 /3);
        g2.setPaint(BORDER_COLOR);
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
