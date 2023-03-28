package ooad.uml.editor.graphics.menu.editmenu;

import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class EditMenu extends JMenu {
    
    public EditMenu(String name) {
        super(name);
        this.setPreferredSize(new Dimension(40, 40));
        JMenuItem item1 = new GroupMenuItem("Group");
        JMenuItem item2 = new JMenuItem("Ungroup");
        JMenuItem item3 = new JMenuItem("change object name");
        this.add(item1);
        this.add(item2);
        this.add(item3);
    }

}
