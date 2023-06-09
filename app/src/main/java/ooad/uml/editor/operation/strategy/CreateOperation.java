package ooad.uml.editor.operation.strategy;

import java.awt.event.MouseEvent;
import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.UMLObject;
import ooad.uml.editor.graphics.UML.basicObject.*;
import ooad.uml.editor.operation.Operation;
import ooad.uml.editor.operation.factory.BasicObjectFactory;

public class CreateOperation extends Operation {
    private BasicObjectFactory producer;

    /**
     * @param producer the producer produces the basic object
     */
    public CreateOperation(BasicObjectFactory producer) {
        super(OperationType.CREATE);
        this.producer = producer;
    }

    @Override
    public void canvasClicked(MouseEvent e, Canvas canvas) {
        BasicObject object = this.producer.createBasicObject(e.getX(), e.getY());
        object.setIsSelected(false);
        canvas.add(object);
        object.setDepth(UMLObject.MIN_DEPTH);
        canvas.repaint();
        object.repaint();
    }

    @Override
    public void canvasPressed(MouseEvent e, Canvas canvas) {
        // empty implementation
    }

    @Override
    public void canvasReleased(MouseEvent e, Canvas canvas) {
        // empty implementation
    }

    @Override
    public void UMLObjectClicked(MouseEvent e, UMLObject object) {
        // empty implementation
    }

    @Override
    public void UMLObjectPressed(MouseEvent e, UMLObject object) {
        // empty implementation
    }

    @Override
    public void UMLObjectReleased(MouseEvent e, UMLObject object) {
        // empty implementation
    }
    
}
