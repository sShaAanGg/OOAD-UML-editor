package ooad.uml.editor.graphics.UML.basicObject;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.util.ArrayList;
import ooad.uml.editor.graphics.UML.UMLObject;

public class GroupObject extends BasicObject {
    
    public GroupObject() {
        super(0, 0, 0, 0, new JLabel("Composite", JLabel.CENTER));
    }

    public void groupObjects(ArrayList<UMLObject> objects) {
        if (objects.size() <= 1 || objects == null) {
            return;
        }

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = 0;
        int maxY = 0;
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

        for (UMLObject object : objects) {
            object.setGroupLeader(this);
        }
    }

    public void ungroupObjects() {

    }

    @Override
    public boolean isInObject(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isInObject'");
    }

    @Override
    protected void drawObject(Graphics2D g2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawObject'");
    }
    
}
