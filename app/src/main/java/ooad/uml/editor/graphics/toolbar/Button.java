package ooad.uml.editor.graphics.toolbar;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.Dimension;
import ooad.uml.editor.listener.UMLActionListener;
import ooad.uml.editor.Config;

/**
 * This class represents a button in the toolbar.
 * <p>
 * - [X] A Button is a JButton
 */
public class Button extends JToggleButton {
    private static final int buttonCount = 6; // Number of buttons in the LHS toolbar, it belongs to this class `Button`
    
    public Button(String name) {
        super(name);
        int windowWidth = Config.getInstance().getWindowWidth();
        int windowHeight = Config.getInstance().getWindowHeight();
        Dimension buttonSize = new Dimension((int) (windowWidth * 0.2 - 20), (int) windowHeight / (buttonCount + 1));
        this.setPreferredSize(buttonSize);
        this.setBackground(Color.WHITE);
        this.addActionListener(UMLActionListener.getInstance());
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
