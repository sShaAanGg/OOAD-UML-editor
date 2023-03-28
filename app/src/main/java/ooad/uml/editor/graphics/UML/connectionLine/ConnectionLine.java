package ooad.uml.editor.graphics.UML.connectionLine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.*;

/**
 * {@summary This abstract class represents a connection line between two basic objects.}
 */
public abstract class ConnectionLine extends UMLObject {
    protected final ConnectionPort start, end;
    protected final Color lineColor, headColor, headBackgroundColor;
    protected Point2D startPoint, endPoint;
    protected MathVector vector;

    public ConnectionLine(Canvas canvas, ConnectionPort start, ConnectionPort end) {
        super();
        this.start = start;
        this.end = end;
        start.addConnectionLine(this);
        end.addConnectionLine(this);
        this.lineColor = Color.BLACK;
        this.headColor = Color.BLACK;
        this.headBackgroundColor = Color.WHITE;
        this.setBounds(0, 0, canvas.getWidth(), canvas.getHeight()); // Default location and size
        this.setOpaque(false);
    }

    /** The lines are all the same */
    protected void paintLine(Graphics2D g2) {
        // Reset the coordinates of the start and end points
        this.startPoint = this.start.getConvertedPoint(this);
        this.endPoint = this.end.getConvertedPoint(this);
        Line2D line = new Line2D.Double(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
        g2.setPaint(this.lineColor);
        g2.draw(line);
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
        this.paintLine(g2);
    }

    /**
     * @return false because according to the spec, a user only clicks a BasicObject to select or unselect it.
     */
    @Override
    public boolean isInObject(MouseEvent e) {
        return false;
    }
}
