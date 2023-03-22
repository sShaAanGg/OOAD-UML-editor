package ooad.uml.editor.graphics.menu.filemenu;

import java.awt.Dimension;
import javax.swing.JMenu;

public class FileMenu extends JMenu {

    public FileMenu(String name) {
        super(name);
        this.setPreferredSize(new Dimension(40, 40));
    }

}
