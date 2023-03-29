package ooad.uml.editor.graphics.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/**
 * {@summary This class represents a JMenuItem that implements ActionListener itself.}
 */
public abstract class MenuListenerItem extends JMenuItem implements ActionListener {
    
    public MenuListenerItem(String itemName) {
        super(itemName);
        this.addActionListener(this);
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);
}
