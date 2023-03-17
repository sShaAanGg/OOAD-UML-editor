package ooad.uml.editor.graphics.menu.editmenu;

import javax.swing.JMenu;

import ooad.uml.editor.Config;

public class EditMenu extends JMenu {
    
    public EditMenu(String name) {
        super(name);
        this.setPreferredSize(Config.getInstance().getMenuSize());
    }

}
