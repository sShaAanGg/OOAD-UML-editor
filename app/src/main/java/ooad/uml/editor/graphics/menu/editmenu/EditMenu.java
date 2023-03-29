package ooad.uml.editor.graphics.menu.editmenu;

import java.awt.Dimension;
import javax.swing.JMenu;
import ooad.uml.editor.graphics.menu.MenuItem;

public class EditMenu extends JMenu {
    
    public EditMenu(String name) {
        super(name);
        this.setPreferredSize(new Dimension(40, 40));
        MenuItem groupItem = new GroupMenuItem("Group");
        MenuItem ungroupItem = new UngroupMenuItem("Ungroup");
        MenuItem changeNameItem = new ChangeNameMenuItem("change object name");
        this.add(groupItem);
        this.add(ungroupItem);
        this.add(changeNameItem);
    }

}
