package ooad.uml.editor.response;

import java.awt.event.MouseEvent;

import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.*;
import ooad.uml.editor.graphics.UML.connectionLine.ConnectionLine;

public class ConnectObjectResponse extends Response {

    @FunctionalInterface
    public interface ConnectionLineProducer {
        ConnectionLine createConnectionLine(Canvas canvas, ConnectionPort start, ConnectionPort end);
    }

    private ConnectionLineProducer producer;
    private ConnectionPort start;
    private ConnectionPort end;

    /**
     * @param producer the producer produces the connection line
     */
    public ConnectObjectResponse(ConnectionLineProducer producer) {
        super("connect");
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
        // TODO Auto-generated method stub
        start = object.getClosestPort(e.getX(), e.getY());
    }

    @Override
    public void UMLObjectReleased(MouseEvent e, UMLObject object) {
        // TODO Auto-generated method stub
        end = object.getClosestPort(e.getX(), e.getY());
        if (start == null || end == null || object == start.getHome()) {
            System.err.println("Invalid connection");
            return;
        }

        Canvas canvas = (Canvas) object.getTopLeader().getParent();
        ConnectionLine line = this.producer.createConnectionLine(canvas, start, end);
        canvas.add(line);
        object.setDepth(UMLObject.MIN_DEPTH);

        canvas.repaint();
        line.repaint();
        this.start = null;
        this.end = null;
    }
    
}
