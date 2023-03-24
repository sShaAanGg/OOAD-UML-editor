package ooad.uml.editor.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import ooad.uml.editor.action.UMLActionHandler;

/**
 * This class represents the UML action listener of the application.
 * 
 * <p>
 * Maybe use the singleton pattern since only 1 instance of UMLActionListener is needed.
 * https://en.wikipedia.org/wiki/Singleton_pattern
 */
public class UMLActionListener implements ActionListener, MouseInputListener {
    private static UMLActionListener instance = new UMLActionListener(); // eager initialization

    /** Declared as private to make sure that nobody can call the constructor */
    private UMLActionListener() {
    }

    public static UMLActionListener getInstance() {
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: implement this method
        /**
         * Pass the source of the action event to the UMLActionHandler
         */
        UMLActionHandler.getInstance().handleButtonAction(e.getSource(), e.getActionCommand());
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        // empty implementation
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        // empty implementation
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
    }
}
