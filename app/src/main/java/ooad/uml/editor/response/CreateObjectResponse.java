package ooad.uml.editor.response;

import java.awt.event.MouseEvent;
import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.UMLObject;
import ooad.uml.editor.graphics.UML.basicObject.*;

public class CreateObjectResponse extends Response {

    @FunctionalInterface
    public interface BasicObjectProducer {
        BasicObject createBasicObject(int coordinateX, int coordinateY);
    }

    private BasicObjectProducer producer;

    /**
     * 
     * @param producer the producer of the basic object, which is a functional interface
     */
    public CreateObjectResponse(BasicObjectProducer producer) {
        super("create");
        this.producer = producer;
    }

    @Override
    public void canvasClicked(MouseEvent e, Canvas canvas) {
        BasicObject object = this.producer.createBasicObject(e.getX(), e.getY());
        canvas.add(object);
        object.setDepth(UMLObject.MIN_DEPTH);
        canvas.repaint();
        object.repaint();
    }

    @Override
    public void canvasPressed(MouseEvent e, Canvas canvas) {
        // TODO Auto-generated method stub
        // empty implementation
    }

    @Override
    public void canvasReleased(MouseEvent e, Canvas canvas) {
        // TODO Auto-generated method stub
        // empty implementation
    }

    @Override
    public void UMLObjectClicked(MouseEvent e, UMLObject object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'UMLObjectClicked'");
    }

    @Override
    public void UMLObjectPressed(MouseEvent e, UMLObject object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'UMLObjectPressed'");
    }

    @Override
    public void UMLObjectReleased(MouseEvent e, UMLObject object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'UMLObjectReleased'");
    }
    
}
