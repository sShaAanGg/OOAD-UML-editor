package ooad.uml.editor.graphics;


import java.awt.Color;
import javax.swing.JPanel;
import ooad.uml.editor.Config;

/**
 * This class represents the canvas area in which all UML objects reside.
 * 
 * <p>
 * * [X] A Canvas is a JPanel. => It seems to be true.
 * <p>
 * ? Maybe composition is better here? 
 * For the class do not have any unique attributes and methods.
 */
public class Canvas extends JPanel {
    public Canvas() {
        this.setMinimumSize(Config.getInstance().getCanvasSize());
        this.setBackground(new Color(Color.lightGray.getRGB()));
    }
}
