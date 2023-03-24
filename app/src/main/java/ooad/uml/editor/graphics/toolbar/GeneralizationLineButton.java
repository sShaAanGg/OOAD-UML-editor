package ooad.uml.editor.graphics.toolbar;

public class GeneralizationLineButton extends Button {
    private static final String iconPath = "/images/generalization_line.png";
    
    public GeneralizationLineButton(String name) {
        super(name);
        this.setIcon(this.getButtonIcon(iconPath, name));
        this.setText("");
        this.setActionCommand("GeneralizationLineButton");
    }
}
