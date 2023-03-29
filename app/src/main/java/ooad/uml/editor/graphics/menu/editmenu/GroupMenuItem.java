package ooad.uml.editor.graphics.menu.editmenu;

import java.awt.event.ActionEvent;
import ooad.uml.editor.graphics.menu.MenuListenerItem;
import ooad.uml.editor.response.*;

public class GroupMenuItem extends MenuListenerItem {

    public GroupMenuItem(String itemName) {
        super(itemName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Response currentResponse = ResponseDispatcher.getInstance().getResponse();
        if (currentResponse instanceof SelectObjectResponse) {
            ((SelectObjectResponse) currentResponse).groupSelectedObjects();
        }
    }
}
