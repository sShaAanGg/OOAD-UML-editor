package ooad.uml.editor.graphics.toolbar;

public class ClassButton extends Button {
    private static final String iconPath = "/images/class.png";
    
    public ClassButton(String name) {
        super(name);
        this.setIcon(this.getButtonIcon(iconPath, name));
        this.setText("");
    }
}
