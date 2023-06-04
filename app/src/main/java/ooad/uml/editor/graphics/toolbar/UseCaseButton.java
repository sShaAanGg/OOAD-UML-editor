package ooad.uml.editor.graphics.toolbar;

import ooad.uml.editor.graphics.UML.basicObject.UseCaseObject;
import ooad.uml.editor.operation.strategy.CreateOperation;

public class UseCaseButton extends Button {
    private static final String iconPath = "/images/use_case.png";

    public UseCaseButton(String name) {
        super(name, new CreateOperation(UseCaseObject::new));
        this.setIcon(this.getButtonIcon(iconPath, name));
        this.setText("");
        this.setActionCommand("UseCaseButton");
    }
}
