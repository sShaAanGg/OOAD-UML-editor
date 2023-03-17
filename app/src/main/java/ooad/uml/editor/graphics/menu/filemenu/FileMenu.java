package ooad.uml.editor.graphics.menu.filemenu;

import javax.swing.JMenu;

import ooad.uml.editor.Config;

public class FileMenu extends JMenu {

    public FileMenu(String name) {
        super(name);
        this.setPreferredSize(Config.getInstance().getMenuSize());
    }

}
