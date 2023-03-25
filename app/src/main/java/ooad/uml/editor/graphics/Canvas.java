package ooad.uml.editor.graphics;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;

import ooad.uml.editor.Config;
import ooad.uml.editor.graphics.UML.UMLObject;
import ooad.uml.editor.response.ResponseDispatcher;

/**
 * This class represents the canvas area in which all UML objects reside.
 * 
 * <p>
 * * [X] A Canvas is a JPanel.
 * <p>
 * Is it necessary to have a Canvas class?
 */
public class Canvas extends JPanel {
    public Canvas() {
        int windowWidth = Config.getInstance().getWindowWidth();
        int windowHeight = Config.getInstance().getWindowHeight();
        Dimension canvasSize = new Dimension((int) (windowWidth * 0.6), (int) (windowHeight));
        this.setLayout(null);
        this.setMinimumSize(canvasSize);
        this.setBackground(Color.WHITE);
        this.addMouseListener(new InnerMouseEventListener(this));
    }

    /**
     * Pass the event to the ResponseDispatcher to handle it.
     * @param e the MouseEvent to be passed
     */
    private void passEventToDispatcher(MouseEvent event) {
        Component[] components = this.getComponents();
        // Check whcih object is clicked first
        for (Component c : components) {
            UMLObject object = (UMLObject) c;
            MouseEvent objectDestEvent = SwingUtilities.convertMouseEvent(this, event, object);
            if (object.isInObject(objectDestEvent)) {
                UMLObject topLeader = object.getTopLeader();
                MouseEvent topLeaderDestEvent = SwingUtilities.convertMouseEvent(this, event, topLeader);
                ResponseDispatcher.getInstance().dispatchObjectMouseResponse(topLeaderDestEvent, topLeader);
                return;
            }
        }

        // No object is clicked so pass the event to `dispatchCanvasMouseResponse`
        ResponseDispatcher.getInstance().dispatchCanvasMouseResponse(event, this);
    }

    /**
     * A MouseInputListener for Canvas.
     * Methods either pass the event to the ResponseDispatcher or do nothing.
     */
    private record InnerMouseEventListener(Canvas canvas) implements MouseInputListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            canvas.passEventToDispatcher(e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            canvas.passEventToDispatcher(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            canvas.passEventToDispatcher(e);
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
}
