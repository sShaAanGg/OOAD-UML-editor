package ooad.uml.editor.graphics.UML.basicObject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;

import ooad.uml.editor.graphics.UML.UMLObject;

/**
 * This class represents the basic object in the canvas.
 */
public abstract class BasicObject extends UMLObject {
    
    protected JLabel name;

    public BasicObject(int coordinateX, int coordinateY, JLabel name) {
        super();
        this.name = name;
        this.add(name);
        this.setLocation(coordinateX, coordinateY);
    }

    public abstract void drawObject(Graphics2D g2);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        this.drawObject(g2);
    }

}
