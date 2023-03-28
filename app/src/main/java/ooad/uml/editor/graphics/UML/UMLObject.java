package ooad.uml.editor.graphics.UML;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

/**
 * {@summary This class represents the UML object in the canvas.}
 * Basic objects and connection lines inherits this class.
 */
public abstract class UMLObject extends JPanel {
    /** The value of depth is between 0 and 99 (inclusive). */
    private int depth;
    public static final int MIN_DEPTH = 0;
    protected boolean isSelected;
    protected UMLObject groupLeader;

    public UMLObject() {
        super();
        this.depth = 50; // default depth
        this.isSelected = false;
    }

    public int getDepth() {
        return this.depth;
    }

    /**
     * Set the depth of the object, then call `setComponentZOrder` to move 
     * the object the specified z-order index in the parent container.
     * @param depth the new depth of the UML object
     */
    public void setDepth(int depth) {
        this.getTopLeader().getParent().setComponentZOrder(this, depth);
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
        this.repaint();
    }

    public UMLObject getTopLeader() {
        if (this.groupLeader == null) {
            return this;
        } else {
            return this.groupLeader.getTopLeader();
        }
    }

    public UMLObject getGroupLeader() {
        if (this.groupLeader == null) {
            return this;
        } else {
            return this.groupLeader;
        }
    }

    public void setGroupLeader() {

    }

    /**
     * Only basic objects should override this method.
     */
    public ConnectionPort getClosestPort(int coordinateX, int coordinateY) {
        return null;
    }
    
    /**
     * Check whether the mouse clicks the object or not.
     * @param e the MouseEvent
     * @return the boolean value indicates whether the Mouse event happens inside the object or not.
     */
    public abstract boolean isInObject(MouseEvent e);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
