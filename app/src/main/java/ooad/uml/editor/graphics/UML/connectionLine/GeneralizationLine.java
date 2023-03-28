package ooad.uml.editor.graphics.UML.connectionLine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.ConnectionPort;

public class GeneralizationLine extends ConnectionLine {

    public GeneralizationLine(Canvas canvas, ConnectionPort start, ConnectionPort end) {
        super(canvas, start, end);
    }

    @Override
    protected void paintHead(Graphics2D g2) {
        // Reset the coordinates of the start and end points
        this.startPoint = this.start.getConvertedPoint(this);
        this.endPoint = this.end.getConvertedPoint(this);
        this.vector = new MathVector(endPoint.getX() - startPoint.getX(), endPoint.getY() - startPoint.getY());
        Point2D point1 = getArrowPoint((5.0 / 6.0) * Math.PI);
        Point2D point2 = getArrowPoint((-5.0 / 6.0) * Math.PI);

        double threePointX[] = { point1.getX(), this.endPoint.getX(), point2.getX() };
        double threePointY[] = { point1.getY(), this.endPoint.getY(), point2.getY() };
        
        Polygon polygon = new Polygon();
        for (int i = 0; i < threePointX.length; i++) {
            polygon.addPoint((int) threePointX[i], (int) threePointY[i]);
        }
        g2.setPaint(this.headBackgroundColor);
        g2.fillPolygon(polygon);
        g2.setPaint(this.headColor);
        g2.drawPolygon(polygon);
    }

    private Point2D getArrowPoint(double theta) {
        return this.vector.getAnotherPoint(theta, this.endPoint);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        this.paintHead(g2);
    }
    
}
