package ooad.uml.editor.graphics.toolbar;

public class UseCaseButton extends Button {
    private static final String iconPath = "/images/use_case.png";

    public UseCaseButton(String name) {
        super(name);
        this.setIcon(this.getButtonIcon(iconPath, name));
        this.setText("");
    }
    
}
