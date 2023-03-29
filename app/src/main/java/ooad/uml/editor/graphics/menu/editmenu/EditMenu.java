package ooad.uml.editor.graphics.menu.editmenu;

import java.awt.Dimension;
import javax.swing.JMenu;
import ooad.uml.editor.graphics.menu.MenuListenerItem;

public class EditMenu extends JMenu {
    
    public EditMenu(String name) {
        super(name);
        this.setPreferredSize(new Dimension(40, 40));
        MenuListenerItem groupItem = new GroupMenuItem("Group");
        MenuListenerItem ungroupItem = new UngroupMenuItem("Ungroup");
        MenuListenerItem changeNameItem = new ChangeNameMenuItem("change object name");
        this.add(groupItem);
        this.add(ungroupItem);
        this.add(changeNameItem);
    }

}
