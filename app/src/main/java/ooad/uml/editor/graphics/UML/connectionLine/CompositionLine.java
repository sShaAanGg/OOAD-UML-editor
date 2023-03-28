package ooad.uml.editor.graphics.UML.connectionLine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.ConnectionPort;

public class CompositionLine extends ConnectionLine {

    public CompositionLine(Canvas canvas, ConnectionPort start, ConnectionPort end) {
        super(canvas, start, end);
    }

    @Override
    protected void paintHead(Graphics2D g2) {
        // Reset the coordinates of the start and end points
        this.startPoint = this.start.getConvertedPoint(this);
        this.endPoint = this.end.getConvertedPoint(this);
        this.vector = new MathVector(endPoint.getX() - startPoint.getX(), endPoint.getY() - startPoint.getY());
        Point2D point1 = getSquarePoint((3.0 / 4.0) * Math.PI);
        Point2D point2 = getSquarePoint((-3.0 / 4.0) * Math.PI);
        Point2D point3 = getTheLastSquarePoint(point1, point2);

        double fourPointX[] = { point1.getX(), this.endPoint.getX(), point2.getX(), point3.getX() };
        double fourPointY[] = { point1.getY(), this.endPoint.getY(), point2.getY(), point3.getY() };
        
        Polygon polygon = new Polygon();
        for (int i = 0; i < fourPointX.length; i++) {
            polygon.addPoint((int) fourPointX[i], (int) fourPointY[i]);
        }
        g2.setPaint(this.headBackgroundColor);
        g2.fillPolygon(polygon);
        g2.setPaint(this.headColor);
        g2.drawPolygon(polygon);
    }

    private Point2D getSquarePoint(double theta) {
        return this.vector.getAnotherPoint(theta, this.endPoint);
    }

    private Point2D getTheLastSquarePoint(Point2D point1, Point2D point2) {
        MathVector vector1 = new MathVector(point1.getX() - this.endPoint.getX(), point1.getY() - this.endPoint.getY());
        MathVector vector2 = new MathVector(point2.getX() - this.endPoint.getX(), point2.getY() - this.endPoint.getY());
        MathVector target = new MathVector(vector1.getX(), vector1.getY());
        target.add(vector2);

        // Now we are going to get the new point
        target.add(this.endPoint);
        Point2D newPoint = target.getPoint();
        return newPoint;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        this.paintHead(g2);
    }
    
}
