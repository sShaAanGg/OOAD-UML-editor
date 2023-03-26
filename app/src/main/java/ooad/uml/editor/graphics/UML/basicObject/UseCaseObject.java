package ooad.uml.editor.graphics.UML.basicObject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JLabel;

public class UseCaseObject extends BasicObject {
    private final Ellipse2D outerEllipse;
    private final Ellipse2D innerEllipse;
    private static final int width = 200;
    private static final int height = 100;
    
    public UseCaseObject(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY, new JLabel("Use Case", JLabel.CENTER));
        outerEllipse = new Ellipse2D.Double(0, 0, width, height);
        double borderSize = 1.5;
        innerEllipse = new Ellipse2D.Double(borderSize, borderSize, width - borderSize*2, height - borderSize*2);
        
        this.setSize(width, height); // **Without it, the object will not be drawn since it sets the JPanel's size**
        this.name.setBounds(0, 0, width, height);
        this.setLayout(null);
        this.setOpaque(false);
        this.setVisible(true);
    }

    @Override
    public void drawObject(Graphics2D g2) {
        g2.setPaint(this.borderColor);
        g2.fill(outerEllipse);
        g2.setPaint(this.objectColor);
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