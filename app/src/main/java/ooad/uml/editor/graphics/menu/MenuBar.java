package ooad.uml.editor.graphics.menu;

import javax.swing.JMenuBar;

import ooad.uml.editor.graphics.menu.editmenu.EditMenu;
import ooad.uml.editor.graphics.menu.filemenu.FileMenu;

/**
 * This class represents the menu bar of the application.
 * 
 * <p>
 * * [X] A MenuBar is a JMenuBar.
 * <p>
 */
public class MenuBar extends JMenuBar {

    public MenuBar() {
        FileMenu fileMenu = new FileMenu("File");
        EditMenu editMenu = new EditMenu("Edit");

        this.add(fileMenu);
        this.add(editMenu);
    }

}
