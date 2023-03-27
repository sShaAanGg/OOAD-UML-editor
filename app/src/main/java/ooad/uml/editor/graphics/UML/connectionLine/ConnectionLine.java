package ooad.uml.editor.graphics.UML.connectionLine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.*;

public abstract class ConnectionLine extends UMLObject {
    private final ConnectionPort start, end;
    protected final Color lineColor, headColor;

    public ConnectionLine(Canvas canvas, ConnectionPort start, ConnectionPort end) {
        super();
        this.start = start;
        this.end = end;
        this.lineColor = Color.BLACK;
        this.headColor = Color.BLACK;
        start.addConnectionLine(this);
        end.addConnectionLine(this);
        this.setBounds(0, 0, canvas.getWidth(), canvas.getHeight()); // Default location and size
        this.setOpaque(false);
    }

    /** The lines are all the same */
    protected void paintLine(Graphics2D g2) {
        Point2D startPoint = this.start.getConvertedPoint(this);
        Point2D endPoint = this.end.getConvertedPoint(this);
        // int portLegnth = this.start.getPortLength();
        Line2D line = new Line2D.Double(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
        g2.setPaint(this.lineColor);
        g2.draw(line);
        endPoint = new Point2D.Double(endPoint.getX() - startPoint.getX(), endPoint.getY() - startPoint.getY());
    }
    
    /** The heads are all different; must be implemented by subclass of ConnectionLine */
    protected abstract void paintHead(Graphics2D g2);
    
    /**
     * Subclass of ConnectionLine must implement this method.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // TODO: implement it
        this.paintLine(g2);
        this.paintHead(g2);
        // paintChildren(g);
    }

    /**
     * @return false because according to the spec, a user only clicks a BasicObject to select or unselect it.
     */
    @Override
    public boolean isInObject(MouseEvent e) {
        return false;
    }
}
