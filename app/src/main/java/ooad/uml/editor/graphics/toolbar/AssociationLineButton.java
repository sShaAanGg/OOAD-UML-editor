package ooad.uml.editor.graphics.toolbar;

import ooad.uml.editor.graphics.UML.connectionLine.AssociationLine;
import ooad.uml.editor.operation.strategy.ConnectOperation;

public class AssociationLineButton extends Button {
    private static final String iconPath = "/images/association_line.png";
    
    public AssociationLineButton(String name) {
        super(name, new ConnectOperation(AssociationLine::new));
        this.setIcon(this.getButtonIcon(iconPath, name));
        this.setText("");
        this.setActionCommand("AssociationLineButton");
    }
}
