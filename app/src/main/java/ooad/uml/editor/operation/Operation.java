package ooad.uml.editor.operation;

import java.awt.event.MouseEvent;
import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.UMLObject;

/**
 * {@summary An abstract class for operations in response to the mouse events}
 * The operations are like the controllers with strategy/state pattern.
 * Now there are 3 types of operations: create, select, and
 * connect which inherit this class.
 */
public abstract class Operation {
    // private String mode;
    private OperationType type;
    
    public Operation(OperationType type) {
        // this.mode = mode;
        this.type = type;
    }

    protected enum OperationType {
        CREATE, SELECT, CONNECT
    }

    // public String getMode() {
    //     return mode;
    // }

    /**
     * Operation for the mouse event on the canvas.
     * @param e the MouseEvent
     * @param canvas
     */
    public abstract void canvasClicked(MouseEvent e, Canvas canvas);
    public abstract void canvasPressed(MouseEvent e, Canvas canvas);
    public abstract void canvasReleased(MouseEvent e, Canvas canvas);
    
    /**
     * Operation for the mouse event on the UML object.
     * @param e the MouseEvent
     * @param object the UML object
     */
    public abstract void UMLObjectClicked(MouseEvent e, UMLObject object);
    public abstract void UMLObjectPressed(MouseEvent e, UMLObject object);
    public abstract void UMLObjectReleased(MouseEvent e, UMLObject object);

    /** 
     * TODO: maybe undo these products from percolating up.
     * Solve the type issues with the enumeration
     */
    public void changeObjectName() {
        // only SelectOperation should override this method
    }

    public void groupSelectedObjects() {
        // only SelectOperation should override this method
    }

    public void ungroupSelectedObjects() {
        // only SelectOperation should override this method
    }
}
