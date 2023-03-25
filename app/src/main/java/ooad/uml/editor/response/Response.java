package ooad.uml.editor.response;

import java.awt.event.MouseEvent;
import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.UMLObject;

/**
 * An abstract class for responses to the mouse events.
 * There are 3 types of responses: create, select, and connect
 * which inherit this class.
 */
public abstract class Response {
    private String mode;
    
    public Response(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    /**
     * Response to the mouse event on the canvas.
     * @param e the MouseEvent
     * @param canvas
     */
    public abstract void canvasClicked(MouseEvent e, Canvas canvas);
    public abstract void canvasPressed(MouseEvent e, Canvas canvas);
    public abstract void canvasReleased(MouseEvent e, Canvas canvas);
    
    /**
     * Response to the mouse event on the UML object.
     * @param e the MouseEvent
     * @param object the UML object
     */
    public abstract void UMLObjectClicked(MouseEvent e, UMLObject object);
    public abstract void UMLObjectPressed(MouseEvent e, UMLObject object);
    public abstract void UMLObjectReleased(MouseEvent e, UMLObject object);
}
