package ooad.uml.editor.graphics.UML.connectionLine;

import java.awt.geom.Point2D;

/**
 * {@summary Instances of this class represent a vector in the Cartesian space.}
 * The class is used to calculate the vector of the connection line.
 * It uses rotation matrix to rotate the vector, which can be further used to
 * draw the head (end) of the various connection lines.
 */
public class MathVector {
    private double x;
    private double y;

    /**
     * The Cartesian space vector constructor.
     * @param x the x portion of the vector
     * @param y the y portion of the vector
     */
    public MathVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /** Just plain vector addition. */
    public void add(MathVector vector) {
        this.x += vector.x;
        this.y += vector.y;
    }

    /** Another overloaded method for vector addition. */
    public void add(Point2D point) {
        this.x += point.getX();
        this.y += point.getY();
    }

    /**
     * @return the {@link Point2D} representation of the vector
     */
    public Point2D getPoint() {
        return new Point2D.Double(x, y);
    }

    /**
     * Get the new point after rotating the vector by theta and adding it to the end point.
     * @param theta
     * @return the new point
     */
    public Point2D getAnotherPoint(double theta, Point2D endPoint) {
        MathVector rotatedVector = this.getRotatedVector(theta);
        // double dx = vector.getX(), dy = vector.getY();
        double distance = Math.sqrt(x * x + y * y);
        double length = 16.0;
        double scalar = distance / length;
        rotatedVector.scale(scalar);

        // Now we are going to get the new point
        rotatedVector.add(endPoint);
        Point2D newPoint = rotatedVector.getPoint();
        return newPoint;
    }

    /**
     * Get the rotated vector.
     * @param vector the vector to be rotated
     * @param theta the angle to rotate the vector by
     * @return the new rotated {@link MathVector} vector
     */
    public MathVector getRotatedVector(double theta) {
        double sinTheta = Math.sin(theta);
        double cosTheta = Math.cos(theta);
        double newX = cosTheta * this.x - sinTheta * this.y;
        double newY = sinTheta * this.x + cosTheta * this.y;
        return new MathVector(newX, newY);
    }
    
    /**
     * Scale the vector by a scalar.
     * @param scalar the scalar to scale the vector by
     * @apiNote the scalar is defined by `distance / length`.
     * Thus x = x / scalar, y = y / scalar.
     */
    public void scale(double scalar) {
        this.x /= scalar;
        this.y /= scalar;
    }
}
