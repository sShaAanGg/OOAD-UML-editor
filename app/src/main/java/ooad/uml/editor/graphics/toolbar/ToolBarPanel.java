package ooad.uml.editor.graphics.toolbar;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import ooad.uml.editor.Config;

public class ToolBarPanel extends JPanel {
    private JToolBar toolbar;

    public ToolBarPanel() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.toolbar = new JToolBar(JToolBar.VERTICAL);
        this.toolbar.setAlignmentX(CENTER_ALIGNMENT);
        this.toolbar.setFloatable(false);
        this.toolbar.setRollover(true);
        this.add(toolbar);
        this.setPreferredSize(Config.getInstance().getToolBarPanelSize());
    }
    
}
