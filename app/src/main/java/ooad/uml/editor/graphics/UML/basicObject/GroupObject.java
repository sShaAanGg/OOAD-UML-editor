package ooad.uml.editor.graphics.UML.basicObject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
// import javax.swing.JLabel;
// import javax.swing.SwingUtilities;

import java.util.ArrayList;
import ooad.uml.editor.graphics.UML.UMLObject;

public class GroupObject extends BasicObject {
    private static final Color GROUP_OBJECT_COLOR = Color.ORANGE;
    
    public GroupObject() {
        // Sets default bounds
        super(0, 0, 0, 0, null);
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
        this.width = maxX - minX;
        this.height = maxY - minY;
        this.clearConnectionPorts();

        Container container = objects.get(0).getParent(); // Get the canvas container first
        for (UMLObject object : objects) {
            object.setGroupLeader(this);
            container.remove(object);
            this.add(object);
            // object.setLocation(object.getX() - this.getX(), object.getY() - this.getY());
            object.setDepth(UMLObject.MIN_DEPTH);
        }
        container.repaint();
        System.out.println(container);
        container.add(this);
    }

    public void ungroupObjects() {
        Container container = this.getParent();
        container.remove(this);

        Component[] components = this.getComponents();
        UMLObject object;
        for (Component component : components) {
            object = (UMLObject) component;
            object.setGroupLeader(null);
            this.remove(object);
            container.add(object);
            // object.setLocation(object.getX() + this.getX(), object.getY() + this.getY());
            object.setDepth(UMLObject.MIN_DEPTH);
        }
        container.repaint();
        this.setBounds(0, 0, 0, 0);
    }

    @Override
    public void setDepth(int depth) {
        super.setDepth(depth);
        Component[] components = this.getComponents();
        UMLObject object;
        for (Component component : components) {
            object = (UMLObject) component;
            object.setDepth(UMLObject.MIN_DEPTH);
        }
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
        super.paintChildren(g);
        Graphics2D g2 = (Graphics2D) g;
        if (this.isSelected)
            this.drawObject(g2);
    }
    
}
