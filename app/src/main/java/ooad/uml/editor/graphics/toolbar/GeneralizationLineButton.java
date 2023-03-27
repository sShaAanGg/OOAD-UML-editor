package ooad.uml.editor.graphics.toolbar;

import ooad.uml.editor.graphics.UML.connectionLine.GeneralizationLine;
import ooad.uml.editor.response.ConnectObjectResponse;

public class GeneralizationLineButton extends Button {
    private static final String iconPath = "/images/generalization_line.png";
    
    public GeneralizationLineButton(String name) {
        super(name, new ConnectObjectResponse(GeneralizationLine::new));
        this.setIcon(this.getButtonIcon(iconPath, name));
        this.setText("");
        this.setActionCommand("GeneralizationLineButton");
    }
}
