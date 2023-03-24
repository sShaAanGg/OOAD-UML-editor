package ooad.uml.editor.graphics.UML.basicObject;

import ooad.uml.editor.graphics.UML.UMLObject;

/**
 * This class represents the basic object in the canvas.
 */
public abstract class BasicObject extends UMLObject {
    /** The value of depth is between 0 and 99 (inclusive). */
    private int depth;

    public BasicObject(int coordinateX, int coordinateY) {
        super();
        this.depth = 50; // default depth
        this.setLocation(coordinateX, coordinateY);
    }

    public int getDepth() {
        return this.depth;
    }
}
