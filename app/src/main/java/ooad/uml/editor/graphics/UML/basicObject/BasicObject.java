package ooad.uml.editor.graphics.UML.basicObject;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import ooad.uml.editor.graphics.UML.ConnectionPort;
import ooad.uml.editor.graphics.UML.UMLObject;
import ooad.uml.editor.graphics.UML.connectionLine.ConnectionLine;

/**
 * {@summary This abstract class represents the basic object in the canvas.}
 */
public abstract class BasicObject extends UMLObject {
    protected JLabel name;
    protected final Color BORDER_COLOR, OBJECT_COLOR;
    /** Use ArrayList since we don't perform inserting/removing nodes in/from the middle */
    protected ArrayList<ConnectionPort> connectionPorts;

    public BasicObject(int coordinateX, int coordinateY) {
        super();
        
        this.BORDER_COLOR = Color.DARK_GRAY;
        this.OBJECT_COLOR = Color.LIGHT_GRAY;
        this.connectionPorts = new ArrayList<>(4); // Capacity = # of ports
        this.setLocation(coordinateX, coordinateY);
        // this.setConnectionPorts();
    }

    @Override
    public void setObjectName(String name) {
        this.name.setText(name);
    }

    /**
     * Adds 4 connection ports to the basic object.
     */
    protected void setConnectionPorts() {
        int portLegnth = 5;
        // int halfLength = portLegnth / 2;
        ConnectionPort top = new ConnectionPort(this, this.getWidth() / 2, 0, portLegnth);
        ConnectionPort bottom = new ConnectionPort(this, this.getWidth() / 2, this.getHeight() - portLegnth, portLegnth);
        ConnectionPort left = new ConnectionPort(this, 0, this.getHeight() / 2, portLegnth);
        ConnectionPort right = new ConnectionPort(this, this.getWidth() - portLegnth, this.getHeight() / 2, portLegnth);
        connectionPorts.add(top);
        connectionPorts.add(bottom);
        connectionPorts.add(left);
        connectionPorts.add(right);
        this.add(top);
        this.add(bottom);
        this.add(left);
        this.add(right);
    }

    public void clearConnectionPorts() {
        for (ConnectionPort port : connectionPorts) {
            port.clearPoint();
            this.remove(port);
        }
        this.connectionPorts.clear();
        this.repaint();
    }
    
    private void setPortsVisible(boolean isVisible) {
        for (ConnectionPort port : connectionPorts) {
            port.setVisible(isVisible);
        }
    }

    private void setPortsAndLinesDepth(int depth) {
        for (ConnectionPort port : connectionPorts) {
            port.setDepth(depth);
            for (ConnectionLine line : port.getConnectionLines()) {
                line.setDepth(depth);
            }
        }
    }

    /**
     * @param coordinateX the x coordinate of the mouse event
     * @param coordinateY the y coordinate of the mouse event
     * @return ConnectionPort the closest connection port to the mouse event
     */
    @Override
    public ConnectionPort getClosestPort(int coordinateX, int coordinateY) {
        if (!this.connectionPorts.isEmpty()) {
            ConnectionPort closestPort = this.connectionPorts.get(0);
            double minDistance = Double.MAX_VALUE;
            for (ConnectionPort port : this.connectionPorts) {
                double distance = Point2D.distance(coordinateX, coordinateY, port.getX(), port.getY());
                if (distance < minDistance) {
                    minDistance = distance;
                    closestPort = port;
                }
            }
            return closestPort;
        }
        return null;
    }
    
    @Override
    public void setDepth(int depth) {
        if (this.getTopLeader().getParent() != null) {
            // Set the basic object and its ports and all ports' lines to the same depth
            this.getTopLeader().getParent().setComponentZOrder(this, depth);
            this.setPortsAndLinesDepth(depth);
        }
    }

    @Override
    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
        this.setPortsVisible(isSelected);
        this.repaint();
    }

    @Override
    public void ungroupObjects(Component[] components) {
        // only GroupObject should override this method
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        this.drawObject(g2);
    }
    
    protected abstract void drawObject(Graphics2D g2);
}
