package ooad.uml.editor.graphics.toolbar;

import ooad.uml.editor.operation.strategy.SelectOperation;

public class SelectButton extends Button {
    private static final String iconPath = "/images/select.png";

    public SelectButton(String name) {
        super(name, new SelectOperation());
        this.setIcon(this.getButtonIcon(iconPath, name));
        this.setText("");
        this.setActionCommand("SelectButton");
    }
}
