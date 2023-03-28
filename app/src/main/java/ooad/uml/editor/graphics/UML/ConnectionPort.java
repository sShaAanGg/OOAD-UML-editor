package ooad.uml.editor.graphics.UML;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import ooad.uml.editor.graphics.UML.basicObject.BasicObject;
import ooad.uml.editor.graphics.UML.connectionLine.ConnectionLine;

/**
 * {@summary This class represents the connection port of a BasicObject.}
 */
public class ConnectionPort extends UMLObject {
    /** The basicObject this connectionPort belongs to */
    private final BasicObject home;
    private ArrayList<ConnectionLine> connectionLines = new ArrayList<>();
    private Point2D point;
    private int PortLength;

    public ConnectionPort(BasicObject home, int coordinateX, int coordinateY, int length) {
        super();
        this.home = home;
        this.point = new Point2D.Double(coordinateX, coordinateY);
        this.PortLength = length;

        this.setBounds(coordinateX, coordinateY, length, length);
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
    }
    
    public BasicObject getHome() {
        return home;
    }

    public ArrayList<ConnectionLine> getConnectionLines() {
        return connectionLines;
    }

    public void addConnectionLine(ConnectionLine connectionLine) {
        connectionLines.add(connectionLine);
    }

    public Point2D getPoint() {
        return this.point;
    }

    public int getPortLength() {
        return this.PortLength;
    }

    public Point getConvertedPoint(ConnectionLine destinationLine) {
        return SwingUtilities.convertPoint(home, this.getX(), this.getY(), destinationLine);
    }

    /**
     * @return false because according to the spec, a user only clicks a BasicObject to select or unselect it.
     */
    @Override
    public boolean isInObject(MouseEvent e) {
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // It seems that Point2D do not need to be drawn explicitly
    }
    
}
