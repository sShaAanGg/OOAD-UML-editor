package ooad.uml.editor.graphics.toolbar;

import ooad.uml.editor.graphics.UML.connectionLine.GeneralizationLine;
import ooad.uml.editor.operation.strategy.ConnectOperation;

public class GeneralizationLineButton extends Button {
    private static final String iconPath = "/images/generalization_line.png";
    
    public GeneralizationLineButton(String name) {
        super(name, new ConnectOperation(GeneralizationLine::new));
        this.setIcon(this.getButtonIcon(iconPath, name));
        this.setText("");
        this.setActionCommand("GeneralizationLineButton");
    }
}
