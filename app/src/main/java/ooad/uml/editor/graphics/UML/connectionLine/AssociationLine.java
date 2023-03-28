package ooad.uml.editor.graphics.UML.connectionLine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.ConnectionPort;

public class AssociationLine extends ConnectionLine {

    public AssociationLine(Canvas canvas, ConnectionPort start, ConnectionPort end) {
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
        GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, threePointX.length);
        polyline.moveTo(threePointX[0], threePointY[0]);
        for (int i = 1; i < threePointX.length; i++) {
            polyline.lineTo(threePointX[i], threePointY[i]);
        }
        g2.setPaint(this.headColor);
        g2.draw(polyline);
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
