package ooad.uml.editor.graphics.toolbar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import ooad.uml.editor.Config;

public class ToolBarPanel extends JPanel {
    private JToolBar toolBar;
    private ButtonGroup buttonGroup;

    public ToolBarPanel() {
        super();
        this.toolBar = new JToolBar(JToolBar.VERTICAL);
        this.toolBar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.toolBar.setAlignmentX(CENTER_ALIGNMENT);
        this.toolBar.setFloatable(false);
        this.toolBar.setRollover(true);
        this.toolBar.setBackground(Color.LIGHT_GRAY);

        int toolBarWidth = (int) (Config.getInstance().getWindowWidth() * 0.2);
        int toolBarHeight = Config.getInstance().getWindowHeight();
        Dimension toolBarSize = new Dimension(toolBarWidth, toolBarHeight);
        this.toolBar.setPreferredSize(toolBarSize);
        
        Dimension toolBarPanelSize = toolBarSize;
        this.add(toolBar);
        this.setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(toolBarPanelSize);
        this.buttonGroup = new ButtonGroup();

        // Create `Button` references to subclass Buttons for polymorphism to work, then add the buttons to this.tooBar.
        createButtons();
    }
    
    /**
     * Create `Button` references to subclass Buttons for polymorphism to work, then add the buttons to this.tooBar.
     */
    private void createButtons() {
        Button selectButton = new SelectButton("select");
        Button associationLineButton = new AssociationLineButton("association line");
        Button generalizationLineButton = new GeneralizationLineButton("generalization line");
        Button compositionLineButton = new CompositionLineButton("composition line");
        Button classButton = new ClassButton("class");
        Button useCaseButton = new UseCaseButton("use case");

        this.addButtons(selectButton);
        this.addButtons(associationLineButton);
        this.addButtons(generalizationLineButton);
        this.addButtons(compositionLineButton);
        this.addButtons(classButton);
        this.addButtons(useCaseButton);
    }
    
    private void addButtons(Button button) {
        this.toolBar.add(button);
        this.buttonGroup.add(button);
    }
}
