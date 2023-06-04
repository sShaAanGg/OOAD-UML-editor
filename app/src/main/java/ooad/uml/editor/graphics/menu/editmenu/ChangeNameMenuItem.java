package ooad.uml.editor.graphics.menu.editmenu;

import java.awt.event.ActionEvent;
import ooad.uml.editor.graphics.menu.MenuListenerItem;
import ooad.uml.editor.operation.*;

public class ChangeNameMenuItem extends MenuListenerItem {
    
    public ChangeNameMenuItem(String itemName) {
        super(itemName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Operation currentOperation = OperationDispatcher.getInstance().getOperation();
        currentOperation.changeObjectName();
        // if (currentOperation instanceof SelectOperation) {
        //     ((SelectOperation) currentOperation).changeObjectName();
        // }
    }
}
