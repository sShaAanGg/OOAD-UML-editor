package ooad.uml.editor.graphics.toolbar;

import ooad.uml.editor.response.ConnectObjectResponse;

public class AssociationLineButton extends Button {
    private static final String iconPath = "/images/association_line.png";
    
    public AssociationLineButton(String name) {
        super(name, new ConnectObjectResponse());
        this.setIcon(this.getButtonIcon(iconPath, name));
        this.setText("");
        this.setActionCommand("AssociationLineButton");
    }
}
