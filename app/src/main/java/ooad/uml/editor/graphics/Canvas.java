package ooad.uml.editor.graphics;

import javax.swing.JPanel;

import ooad.uml.editor.Config;

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
        this.setMinimumSize(Config.getInstance().getCanvasSize());
        this.setBackground(Config.getInstance().getCanvasColor());
    }
}
