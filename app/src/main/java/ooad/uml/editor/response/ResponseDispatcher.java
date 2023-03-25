package ooad.uml.editor.response;

import java.awt.event.MouseEvent;
import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.UMLObject;
/**
 * The reponse dispatcher handles the MouseEvents and sends/dispatches 
 * appropriate responses with methods in the actual {@link #response} object.
 * <p>
 * When the user clicks a button, the actual response is set using
 * {@link #setResponse(Response)}.
 * <p>
 * use the singleton pattern since only 1 instance is needed.
 * https://en.wikipedia.org/wiki/Singleton_pattern
 */
public class ResponseDispatcher {
    private static ResponseDispatcher instance = new ResponseDispatcher(); // Eager initialization
    /** Current response object to handle the mouse event */
    private Response response;
    // private Response creator;
    // private Response selector;
    // private Response connector;

    private ResponseDispatcher() {
    }

    public static ResponseDispatcher getInstance() {
        return instance;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
    
    public Response getResponse() {
        return this.response;
    }

    /**
     * Dispatch the response from canvas clicked event.
     * @param e the MouseEvent to be passed
     * @param canvas
     */
    public void dispatchCanvasMouseResponse(MouseEvent e, Canvas canvas) {
        switch (e.getID()) {
            case MouseEvent.MOUSE_CLICKED:
                response.canvasClicked(e, canvas);
                break;
            case MouseEvent.MOUSE_PRESSED:
                response.canvasPressed(e, canvas);
                break;
            case MouseEvent.MOUSE_RELEASED:
                response.canvasReleased(e, canvas);
                break;
        }
    }
    
    /**
     * Dispatch the response from UMLObject clicked event.
     * @param e the MouseEvent to be passed
     * @param object
     */
    public void dispatchObjectMouseResponse(MouseEvent e, UMLObject object) {
        switch (e.getID()) {
            case MouseEvent.MOUSE_CLICKED:
                response.UMLObjectClicked(e, object);
                break;
            case MouseEvent.MOUSE_PRESSED:
                response.UMLObjectPressed(e, object);
                break;
            case MouseEvent.MOUSE_RELEASED:
                response.UMLObjectReleased(e, object);
                break;
        }
    }
}
