package ooad.uml.editor.graphics.UML.basicObject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
// import javax.swing.JLabel;

import java.util.ArrayList;

import ooad.uml.editor.graphics.UML.ConnectionPort;
import ooad.uml.editor.graphics.UML.UMLObject;

public class GroupObject extends BasicObject {
    private static final Color GROUP_OBJECT_COLOR = Color.ORANGE;
    
    public GroupObject() {
        // Sets default bounds; it will be changed later when group() or ungroup() is called
        super(0, 0);
        this.setSize(0, 0);
        super.setConnectionPorts();
        this.name = null; // Group object doesn't have a name label
        // super(0, 0, 0, 0, new JLabel("Composite", JLabel.CENTER));
        this.setLayout(null);
        this.setOpaque(false);
    }

    public void groupObjects(ArrayList<UMLObject> objects) {
        if (objects.size() <= 1 || objects == null) { return; }

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = 0, maxY = 0;
        for (UMLObject object : objects) {
            if (minX > object.getX())
                minX = object.getX();
            if (minY > object.getY())
                minY = object.getY();
            if (maxX < object.getX() + object.getWidth())
                maxX = object.getX() + object.getWidth();
            if (maxY < object.getY() + object.getHeight())
                maxY = object.getY() + object.getHeight();
        }
        this.setBounds(minX, minY, maxX - minX, maxY - minY);
        this.setSize(maxX - minX, maxY - minY);
        this.clearConnectionPorts();
        this.setConnectionPorts();

        for (UMLObject object : objects) {
            object.setGroupLeader(this);
            object.getParent().remove(object);
            this.add(object);
            object.setLocation(object.getX() - this.getX(), object.getY() - this.getY());
            object.setDepth(UMLObject.MIN_DEPTH);
        }
    }

    @Override
    public void ungroupObjects(Component[] components) {
        Container container = this.getParent();
        // Component[] components = this.getComponents();
        container.remove(this);

        UMLObject object;
        for (Component component : components) {
            object = (UMLObject) component;
            object.setGroupLeader(null);
            this.remove(object);
            container.add(object);
            object.setLocation(object.getX() + this.getX(), object.getY() + this.getY());
            object.setDepth(UMLObject.MIN_DEPTH);
        }
        container.repaint();
        this.setBounds(0, 0, 0, 0);
    }

    @Override
    public ConnectionPort getClosestPort(int coordinateX, int coordinateY) {
        return null;
    }

    @Override
    public void setDepth(int depth) {
        super.setDepth(depth);
    }

    @Override
    public void setObjectName(String name) {
        // this (a GroupObject) doesn't have a name label
    }

    /**
     * {@summary Check whether the mouse clicks the composite object or not.}
     * The composite object is viewed as the smallest rectangle which contain 
     * all the basic objects grouped into it.
     */
    @Override
    public boolean isInObject(MouseEvent e) {
        return this.contains(e.getX(), e.getY());
    }

    @Override
    protected void drawObject(Graphics2D g2) {
        g2.setPaint(GROUP_OBJECT_COLOR);
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // super.paintChildren(g);
        Graphics2D g2 = (Graphics2D) g;
        // if (this.isSelected) {
        //     this.setOpaque(true);
        // } else {
        //     this.setOpaque(false);
        // }
        this.drawObject(g2);
    }
    
}
