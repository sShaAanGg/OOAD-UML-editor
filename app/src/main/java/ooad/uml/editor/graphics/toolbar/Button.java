package ooad.uml.editor.graphics.toolbar;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.Dimension;

import ooad.uml.editor.Config;
import ooad.uml.editor.operation.*;

/**
 * This class represents a button in the toolbar.
 * <p>
 * - [X] A Button is a JButton
 * <p>
 * When a button is clicked, the actual operation in the OperationDispatcher is set.
 * Later mouse events will be responded with the methods in the second parameter of 
 * the constructor {@link #Button(String, Operation)}.
 */
public class Button extends JToggleButton {
    private static final int buttonCount = 6; // Number of buttons in the LHS toolbar, it belongs to this class `Button`
    
    public Button(String name, Operation operation) {
        super(name);
        int windowWidth = Config.getInstance().getWindowWidth();
        int windowHeight = Config.getInstance().getWindowHeight();
        Dimension buttonSize = new Dimension((int) (windowWidth * 0.2 - 20), (int) windowHeight / (buttonCount + 1));
        this.setPreferredSize(buttonSize);
        this.setBackground(Color.WHITE);
        this.addActionListener(actionEvent -> OperationDispatcher.getInstance().setOperation(operation)); // Use lamda expression
    }

    /**
     * Only children of Button can call this method.
     * @param path the specified path of the image
     * @param desciption
     * @return ImageIcon
     */
    protected ImageIcon getButtonIcon(String path, String desciption) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, desciption);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
