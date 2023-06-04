package ooad.uml.editor.graphics.toolbar;

import ooad.uml.editor.graphics.UML.connectionLine.CompositionLine;
import ooad.uml.editor.operation.strategy.ConnectOperation;

public class CompositionLineButton extends Button {
    private static final String iconPath = "/images/composition_line.png";

    public CompositionLineButton(String name) {
        super(name, new ConnectOperation(CompositionLine::new));
        this.setIcon(this.getButtonIcon(iconPath, name));
        this.setText("");
        this.setActionCommand("CompositionLineButton");
    }
}
