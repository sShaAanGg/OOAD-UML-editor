package ooad.uml.editor.graphics;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import ooad.uml.editor.Config;
import ooad.uml.editor.listener.UMLActionListener;

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
        this.setMinimumSize(canvasSize);
        this.setBackground(Color.WHITE);
        this.addMouseListener(UMLActionListener.getInstance());
    }
}
