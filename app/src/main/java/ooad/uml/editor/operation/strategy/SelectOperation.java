package ooad.uml.editor.operation.strategy;

import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.*;
import ooad.uml.editor.graphics.UML.basicObject.BasicObject;
import ooad.uml.editor.graphics.UML.basicObject.GroupObject;
import ooad.uml.editor.operation.Operation;

public class SelectOperation extends Operation {
    /** Use ArrayList since we don't perform inserting/removing nodes in/from the middle */
    private ArrayList<UMLObject> selectedObjects;
    private Point mousePressedPoint;
    private boolean isInMovingMode;
    private UMLObject objectToBeMoved;

    public SelectOperation() {
        super(OperationType.SELECT);
        selectedObjects = new ArrayList<>();
        isInMovingMode = false;
        objectToBeMoved = null;
    }

    private void unselectAll() {
        for (UMLObject object : selectedObjects) {
            object.setIsSelected(false);
        }
        selectedObjects.clear();
    }

    /** Use brutal force solution */
    private void selectSquare(MouseEvent event, Container canvas) {
        Point mouseReleasedPoint = event.getPoint();
        int minX = Math.min(mousePressedPoint.x, mouseReleasedPoint.x);
        int maxX = Math.max(mousePressedPoint.x, mouseReleasedPoint.x);
        int minY = Math.min(mousePressedPoint.y, mouseReleasedPoint.y);
        int maxY = Math.max(mousePressedPoint.y, mouseReleasedPoint.y);
        int[] cornerValues = new int[] { minX, minY, maxX, maxY };

        Component[] components = canvas.getComponents();
        for (Component component : components) {
            if (!(component instanceof BasicObject)) {
                continue;
            }
            UMLObject object = (UMLObject) component;
            if (isObjectInSquare((UMLObject) component, cornerValues)) {
                object.setIsSelected(true);
                this.selectedObjects.add(object);
                object.setDepth(UMLObject.MIN_DEPTH);
            }
        }
    }

    /** Use brutal force solution. Even the way of passing parameters is extremely brutal */
    private boolean isObjectInSquare(UMLObject object, int[] cornervalues) {
        int minX = cornervalues[0];
        int minY = cornervalues[1];
        int maxX = cornervalues[2];
        int maxY = cornervalues[3];
        if (object.getX() >= minX
                && (object.getX() + object.getWidth()) <= maxX
                && object.getY() >= minY
                && (object.getY() + object.getHeight()) <= maxY) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * TODO: refactor the following three methods
     */
    @Override
    public void groupSelectedObjects() {
        if (selectedObjects.size() > 1) {
            Container container = selectedObjects.get(0).getParent();
            GroupObject groupObject = new GroupObject();
            groupObject.groupObjects(this.selectedObjects);
            container.add(groupObject);
            groupObject.setDepth(UMLObject.MIN_DEPTH);
            this.unselectAll();
            groupObject.setIsSelected(true);
            this.selectedObjects.add(groupObject);
        }

    }

    @Override
    public void ungroupSelectedObjects() {
        if (selectedObjects.size() == 1) {
            UMLObject objectToBeUngrouped = selectedObjects.get(0);
            // System.out.println("Ungrouping...");
            objectToBeUngrouped.ungroupObjects(objectToBeUngrouped.getComponents());
            this.unselectAll();
            // if ((objectToBeUngrouped instanceof GroupObject)) {
            //     // System.out.println("Ungrouping...");
            //     ((GroupObject) objectToBeUngrouped).ungroupObjects(objectToBeUngrouped.getComponents());
            //     this.unselectAll();
            // }
        }
    }

    private void moveSelectedObject(MouseEvent event, UMLObject object) {
        if (object != null) {
            object.setLocation(event.getX() - mousePressedPoint.x, event.getY() - mousePressedPoint.y);
            object.setDepth(UMLObject.MIN_DEPTH);
            object.getTopLeader().getParent().repaint();
            // TODO: check the state of selection
            object.setIsSelected(true);
            this.selectedObjects.add(object);
            // end of section to be checked
            isInMovingMode = false;
            objectToBeMoved = null;
        }
    }

    @Override
    public void changeObjectName() {
        if (selectedObjects.size() == 1) {
            UMLObject objectToBeChanged = selectedObjects.get(0);
            String name = JOptionPane.showInputDialog("Please enter the new name:");
            if (name != null) {
                objectToBeChanged.setObjectName(name);
            }
            // if ((objectToBeChanged instanceof BasicObject)) {
            //     String name = JOptionPane.showInputDialog("Please enter the new name:");
            //     if (name != null) {
            //         ((BasicObject) objectToBeChanged).setObjectName(name);
            //     }
            // }
    
        }
    }

    @Override
    public void canvasClicked(MouseEvent e, Canvas canvas) {
        // System.out.println("Click on canvas");
        this.unselectAll();
    }

    @Override
    public void canvasPressed(MouseEvent e, Canvas canvas) {
        // System.out.println("Press on canvas");
        this.unselectAll();
        this.mousePressedPoint = e.getPoint();
    }

    @Override
    public void canvasReleased(MouseEvent e, Canvas canvas) {
        // System.out.println("Release on canvas");
        this.unselectAll();
        if (this.isInMovingMode) {
            this.moveSelectedObject(e, this.objectToBeMoved);
        } else {
            selectSquare(e, canvas);
        }
    }

    @Override
    public void UMLObjectClicked(MouseEvent e, UMLObject object) {
        this.unselectAll();
        this.selectedObjects.add(object);
        object.setIsSelected(true);
        object.setDepth(UMLObject.MIN_DEPTH);
    }

    @Override
    public void UMLObjectPressed(MouseEvent e, UMLObject object) {
        this.unselectAll();
        this.selectedObjects.add(object);
        object.setIsSelected(true);
        this.mousePressedPoint = e.getPoint();
        this.isInMovingMode = true;
        this.objectToBeMoved = object;
    }

    @Override
    public void UMLObjectReleased(MouseEvent e, UMLObject object) {
        this.unselectAll();
        // Converts the event to the coordinate system of the canvas.
        MouseEvent parentDestEvent = SwingUtilities.convertMouseEvent(object, e, object.getTopLeader().getParent());
        if (this.isInMovingMode) {
            this.moveSelectedObject(parentDestEvent, this.objectToBeMoved);
        } else {
            Container canvas = object.getTopLeader().getParent();
            selectSquare(parentDestEvent, canvas);
        }
    }

    @Override
    public void clearStates() {
        this.unselectAll();
        this.mousePressedPoint = null;
        this.isInMovingMode = false;
        this.objectToBeMoved = null;
    }

}
