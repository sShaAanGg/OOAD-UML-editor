package ooad.uml.editor.graphics.toolbar;


import javax.swing.JButton;

import ooad.uml.editor.Config;

/**
 * This class represents a button in the toolbar.
 * <p>
 * - [X] A Button is a JButton
 */
public class Button extends JButton {
    
    public Button(String name) {
        super(name);
        this.setPreferredSize(Config.getInstance().getButtonSize());
        // this.addActionListener(new ActionListener());
    }
}
