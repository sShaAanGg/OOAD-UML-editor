package ooad.uml.editor.graphics.toolbar;

import ooad.uml.editor.graphics.UML.basicObject.ClassObject;
import ooad.uml.editor.response.CreateObjectResponse;

public class ClassButton extends Button {
    private static final String iconPath = "/images/class.png";
    
    public ClassButton(String name) {
        super(name, new CreateObjectResponse(ClassObject::new));
        this.setIcon(this.getButtonIcon(iconPath, name));
        this.setText("");
        this.setActionCommand("ClassButton");
    }
}
