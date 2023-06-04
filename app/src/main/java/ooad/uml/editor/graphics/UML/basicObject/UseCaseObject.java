package ooad.uml.editor.graphics.UML.basicObject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JLabel;

public class UseCaseObject extends BasicObject {
    private final Ellipse2D outerEllipse;
    private final Ellipse2D innerEllipse;
    
    public UseCaseObject(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
        this.setSize(200, 100); // **Without it, the object will not be drawn since it sets the JPanel's size**

        outerEllipse = new Ellipse2D.Double(0, 0, this.getWidth(), this.getHeight());
        double borderSize = 1.5;
        innerEllipse = new Ellipse2D.Double(borderSize, borderSize, this.getWidth() - borderSize*2, this.getHeight() - borderSize*2);
        
        super.setConnectionPorts();
        this.name = new JLabel("Use Case", JLabel.CENTER);
        this.add(name);
        this.name.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setLayout(null);
        this.setOpaque(false);
        this.setVisible(true);
    }

    @Override
    protected void drawObject(Graphics2D g2) {
        g2.setPaint(this.BORDER_COLOR);
        g2.fill(outerEllipse);
        g2.setPaint(this.OBJECT_COLOR);
        g2.fill(innerEllipse);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        this.drawObject(g2);
    }

    @Override
    public boolean isInObject(MouseEvent e) {
        return this.outerEllipse.contains(e.getX(), e.getY());
    }
}
