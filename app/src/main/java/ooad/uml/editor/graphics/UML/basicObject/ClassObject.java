package ooad.uml.editor.graphics.UML.basicObject;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class ClassObject extends BasicObject {
    
    public ClassObject(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY, new JLabel("Class", JLabel.CENTER));
    }

    @Override
    public boolean isInObject(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isInObject'");
    }

    @Override
    public void drawObject(Graphics2D g2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawObject'");
    }
}
