package ooad.uml.editor.action;

import java.awt.event.MouseEvent;
// import javax.swing.AbstractAction;
import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.UMLObject;

public abstract class BasicAction {
    
    public BasicAction() {

    }

    public abstract void canvasClicked(MouseEvent e, Canvas canvas);
    public abstract void canvasPressed(MouseEvent e, Canvas canvas);
    public abstract void canvasReleased(MouseEvent e, Canvas canvas);
    
    public abstract void UMLObjectClicked(MouseEvent e, UMLObject object);
    public abstract void UMLObjectPressed(MouseEvent e, UMLObject object);
    public abstract void UMLObjectReleased(MouseEvent e, UMLObject object);
}
