package ooad.uml.editor.operation;

import java.awt.event.MouseEvent;
import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.UMLObject;
import ooad.uml.editor.operation.strategy.*;
/**
 * The operation dispatcher handles the MouseEvents and sends/dispatches 
 * appropriate operations with methods in the actual {@link #operation} object.
 * This approach is kind of like the strategy / state pattern in controller.
 * <p>
 * When the user clicks a button, the actual operation is set using
 * {@link #setOperation(Operation)}.
 * <p>
 * use the singleton pattern since only 1 instance is needed.
 * https://en.wikipedia.org/wiki/Singleton_pattern
 */
public class OperationDispatcher {
    private static OperationDispatcher instance = new OperationDispatcher(); // Eager initialization
    /** Current operation to handle the mouse event and interact with UML objects */
    private Operation operation;

    private OperationDispatcher() {
        this.operation = new SelectOperation(); // default operation
    }

    public static OperationDispatcher getInstance() {
        return instance;
    }

    /**
     * Set the operation after clear the states of the previous operation.
     * @param operation the operation to be used
     */
    public void setOperation(Operation operation) {
        this.operation.clearStates();
        this.operation = operation;
    }
    
    public Operation getOperation() {
        return this.operation;
    }

    /**
     * Dispatch the operation from canvas clicked event.
     * @param e the MouseEvent to be passed
     * @param canvas
     */
    public void dispatchCanvasMouseOperation(MouseEvent e, Canvas canvas) {
        switch (e.getID()) {
            case MouseEvent.MOUSE_CLICKED:
                operation.canvasClicked(e, canvas);
                break;
            case MouseEvent.MOUSE_PRESSED:
                operation.canvasPressed(e, canvas);
                break;
            case MouseEvent.MOUSE_RELEASED:
                operation.canvasReleased(e, canvas);
                break;
        }
    }
    
    /**
     * Dispatch the operation from UMLObject clicked event.
     * @param e the MouseEvent to be passed
     * @param object
     */
    public void dispatchObjectMouseOperation(MouseEvent e, UMLObject object) {
        switch (e.getID()) {
            case MouseEvent.MOUSE_CLICKED:
                operation.UMLObjectClicked(e, object);
                break;
            case MouseEvent.MOUSE_PRESSED:
                operation.UMLObjectPressed(e, object);
                break;
            case MouseEvent.MOUSE_RELEASED:
                operation.UMLObjectReleased(e, object);
                break;
        }
    }
}
