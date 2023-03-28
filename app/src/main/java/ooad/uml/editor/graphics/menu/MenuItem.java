package ooad.uml.editor.graphics.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public abstract class MenuItem extends JMenuItem implements ActionListener {
    
    public MenuItem(String itemName) {
        super(itemName);
        this.addActionListener(this);
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);
}
