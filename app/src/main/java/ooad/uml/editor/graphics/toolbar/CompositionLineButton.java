package ooad.uml.editor.graphics.toolbar;

public class CompositionLineButton extends Button {
    private static final String iconPath = "/images/composition_line.png";

    public CompositionLineButton(String name) {
        super(name);
        this.setIcon(this.getButtonIcon(iconPath, name));
        this.setText("");
    }
}
