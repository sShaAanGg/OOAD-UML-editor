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
    private OperationType type;
    
    public Operation(OperationType type) {
        this.type = type;
    }

    protected enum OperationType {
        CREATE, SELECT, CONNECT
    }

    public OperationType getType() {
        return type;
    }

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
     * Empty implementation for subclasses to override if needed. 
     * e.g. in situations like transition from select operation to another, 
     * the selection states should be cleared and repainted.
     * ! NOTE: operation.producer (the factory) should not be cleared.
     */
    public void clearStates() {
    }

    /** 
     * TODO: maybe remove these products from percolating up.
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
