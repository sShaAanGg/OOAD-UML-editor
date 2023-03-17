package ooad.uml.editor.graphics;

import javax.swing.JFrame;
import ooad.uml.editor.Config;

/**
 * This class represents the main window of the application which is just a JFrame.
 * 
 * <p>
 * * [X] A Window is a JFrame.
 * <p>
 */
public class Window extends JFrame {
    
    public Window(String title) {
        super(title);
        this.setMinimumSize(Config.getInstance().getWindowSize());
        // this.getContentPane().setMinimumSize(Config.getInstance().getWindowSize());
        this.setLocation(Config.getInstance().getWindowLocation());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
