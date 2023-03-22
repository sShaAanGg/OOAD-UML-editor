package ooad.uml.editor.graphics.toolbar;

public class SelectButton extends Button {
    private static final String iconPath = "/images/select.png";

    public SelectButton(String name) {
        super(name);
        this.setIcon(this.getButtonIcon(iconPath, name));
        this.setText("");
    }
}
