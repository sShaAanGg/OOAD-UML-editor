package ooad.uml.editor.response;

import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.UML.*;
import ooad.uml.editor.graphics.UML.basicObject.BasicObject;
import ooad.uml.editor.graphics.UML.basicObject.GroupObject;

public class SelectObjectResponse extends Response {
    /** Use ArrayList since we don't perform inserting/removing nodes in/from the middle */
    private ArrayList<UMLObject> selectedObjects;
    private Point mousePressedPoint;

    public SelectObjectResponse() {
        super("select");
        selectedObjects = new ArrayList<>();
    }

    private void unselectAll() {
        for (UMLObject object : selectedObjects) {
            object.setIsSelected(false);
        }
        selectedObjects.clear();
    }

    /** Use brutal force solution */
    private void selectSquare(MouseEvent event, Canvas canvas) {
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
        if (object.getX() >= minX && (object.getX() + object.getWidth()) <= maxX 
                                 && object.getY() >= minY 
                                 && (object.getY() + object.getHeight()) <= maxY) {
            return true;
        } else {
            return false;
        }
    }

    public void groupSelectedObjects() {
        if (selectedObjects.size() <= 1) {
            return;
        }

        Container container = selectedObjects.get(0).getParent();
        GroupObject groupObject = new GroupObject();
        groupObject.groupObjects(this.selectedObjects);
        container.add(groupObject);
        groupObject.setDepth(UMLObject.MIN_DEPTH);
        this.unselectAll();
        groupObject.setIsSelected(true);
        this.selectedObjects.add(groupObject);
    }

    public void ungroupSelectedObjects() {
        if (selectedObjects.size() != 1) {
            return;
        }
        UMLObject objectToBeUngrouped = selectedObjects.get(0);
        if (!(objectToBeUngrouped instanceof GroupObject)) {
            return;
        }

        System.out.println("Ungrouping...");
        ((GroupObject) objectToBeUngrouped).ungroupObjects();;
        this.unselectAll();
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
        selectSquare(e, canvas);
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
    }

    @Override
    public void UMLObjectReleased(MouseEvent e, UMLObject object) {
        // Converts the event to the coordinate system of the canvas.
        System.out.println(object); // canvas
        System.out.println(object.getTopLeader()); // group object
        System.out.println(object.getTopLeader().getParent()); // null
        MouseEvent canvasDestEvent = SwingUtilities.convertMouseEvent(object, e, object.getTopLeader().getParent());
        Canvas canvas = (Canvas) object.getTopLeader().getParent();
        selectSquare(canvasDestEvent, canvas);
    }
    
}
