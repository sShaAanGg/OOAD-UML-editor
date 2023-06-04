package ooad.uml.editor.graphics.menu.editmenu;

import java.awt.event.ActionEvent;
import ooad.uml.editor.graphics.menu.MenuListenerItem;
import ooad.uml.editor.operation.*;

public class UngroupMenuItem extends MenuListenerItem {

    public UngroupMenuItem(String itemName) {
        super(itemName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Operation currentOperation = OperationDispatcher.getInstance().getOperation();
        currentOperation.ungroupSelectedObjects();
        // if (currentOperation instanceof SelectObjectOperation) {
        //     ((SelectObjectOperation) currentOperation).ungroupSelectedObjects();
        // }
    }
}
