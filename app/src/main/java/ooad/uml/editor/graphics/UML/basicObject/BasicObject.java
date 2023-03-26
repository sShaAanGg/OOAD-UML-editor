package ooad.uml.editor.graphics.UML.basicObject;

import java.awt.Graphics2D;
import javax.swing.JLabel;
import java.awt.Color;
import ooad.uml.editor.graphics.UML.UMLObject;

/**
 * This class represents the basic object in the canvas.
 */
public abstract class BasicObject extends UMLObject {
    protected JLabel name;
    protected final Color borderColor;
    protected final Color objectColor;

    public BasicObject(int coordinateX, int coordinateY, JLabel name) {
        super();
        this.name = name;
        this.add(name);
        this.borderColor = Color.DARK_GRAY;
        this.objectColor = Color.LIGHT_GRAY;
        this.setLocation(coordinateX, coordinateY);
    }

    public abstract void drawObject(Graphics2D g2);

}
