package ooad.uml.editor.graphics;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Point;

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
        double screenWidth = Config.getInstance().getScreenWidth();
        double screenHeight = Config.getInstance().getScreenHeight();

        int width = Config.getInstance().getWindowWidth();
        int height = Config.getInstance().getWindowHeight();
        Dimension windowSize = new Dimension(width, height);
        Point windowLocation = new Point((int) screenWidth / 4, (int) screenHeight / 8);

        this.setMinimumSize(windowSize);
        // this.getContentPane().setMinimumSize(this.windowSize);
        this.setLocation(windowLocation);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
