package ooad.uml.editor.graphics.UML;

import javax.swing.JPanel;

/**
 * This class represents the UML object in the canvas.
 * Basic objects and connection lines inherits this class.
 */
public class UMLObject extends JPanel {
    protected boolean isSelected = false;

    public UMLObject() {
        super();
    }
}
