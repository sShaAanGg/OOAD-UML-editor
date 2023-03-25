package ooad.uml.editor.graphics.UML.basicObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JLabel;

public class UseCaseObject extends BasicObject {
    private final Ellipse2D ellipseOut;
    private final Ellipse2D ellipseIn;
    private final Color color;
    
    public UseCaseObject(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY, new JLabel("UseCase", JLabel.CENTER));

        ellipseOut = new Ellipse2D.Double(0, 0, 200, 100);
        double borderSize = 1.5;
        ellipseIn = new Ellipse2D.Double(borderSize, borderSize, 200 - borderSize*2, 100 - borderSize*2);
        this.color = Color.LIGHT_GRAY;
        
        this.setSize(200, 100); // **Without it, the object will not be drawn since it sets the JPanel's size**
        this.name.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setLayout(null);
        this.setOpaque(false);
        this.setVisible(true);
    }

    @Override
    public void drawObject(Graphics2D g2) {
        g2.setPaint(Color.DARK_GRAY);
        g2.fill(ellipseOut);
        g2.setPaint(this.color);
        g2.fill(ellipseIn);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        this.drawObject(g2);
    }

    @Override
    public boolean isInObject(MouseEvent e) {
        return this.ellipseOut.contains(e.getX(), e.getY());
    }
}
