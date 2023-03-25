package ooad.uml.editor.graphics.toolbar;

import ooad.uml.editor.response.ConnectObjectResponse;

public class CompositionLineButton extends Button {
    private static final String iconPath = "/images/composition_line.png";

    public CompositionLineButton(String name) {
        super(name, new ConnectObjectResponse());
        this.setIcon(this.getButtonIcon(iconPath, name));
        this.setText("");
        this.setActionCommand("CompositionLineButton");
    }
}
