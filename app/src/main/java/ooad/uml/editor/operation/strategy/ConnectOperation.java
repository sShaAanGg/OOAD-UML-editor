package ooad.uml.editor.operation.strategy;

import java.awt.event.MouseEvent;

import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.*;
import ooad.uml.editor.graphics.UML.connectionLine.ConnectionLine;
import ooad.uml.editor.operation.Operation;
import ooad.uml.editor.operation.factory.ConnectionLineFactory;

public class ConnectOperation extends Operation {
    private ConnectionLineFactory producer;
    private ConnectionPort start;
    private ConnectionPort end;

    /**
     * @param producer the producer produces the connection line
     */
    public ConnectOperation(ConnectionLineFactory producer) {
        super(OperationType.CONNECT);
        this.producer = producer;
    }

    @Override
    public void canvasClicked(MouseEvent e, Canvas canvas) {
        // empty implementation
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
        start = object.getClosestPort(e.getX(), e.getY());
    }

    @Override
    public void UMLObjectReleased(MouseEvent e, UMLObject object) {
        end = object.getClosestPort(e.getX(), e.getY());
        if (start == null || end == null || object == start.getHome()) {
            System.err.println("Invalid connection");
            return;
        }

        Canvas canvas = (Canvas) object.getTopLeader().getParent();
        ConnectionLine line = this.producer.createConnectionLine(canvas, start, end);
        canvas.add(line);
        object.setDepth(UMLObject.MIN_DEPTH);
        line.setDepth(UMLObject.MIN_DEPTH);
        canvas.repaint();
        line.repaint();
        this.start = null;
        this.end = null;
    }

    @Override
    public void clearStates() {
        this.start = null;
        this.end = null;
    }
    
}
