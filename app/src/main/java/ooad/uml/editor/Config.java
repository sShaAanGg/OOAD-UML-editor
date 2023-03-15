package ooad.uml.editor;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents the application configuration.
 * 
 * <p>
 * Use the singleton pattern since only 1 instance of Config is needed.
 * https://en.wikipedia.org/wiki/Singleton_pattern
 */
public class Config {
    private static Config instance = new Config(); // eager initialization
    private Dimension windowSize;
    private Dimension canvasSize;
    private Point windowLocation;

    /** Declared as private to make sure that nobody can call the constructor */
    private Config() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double factor = 0.6;

        double screenWidth = screenSize.getWidth(); // Store the values of width and height to prevent duplicated calls
        double screenHeight = screenSize.getHeight();
        int width = (int) (screenWidth * 0.4);
        int height = (int) (screenHeight * 0.6);
        windowSize = new Dimension(width, height);
        canvasSize = new Dimension((int) (width * factor), (int) (height * factor));
        windowLocation = new Point((int) screenWidth / 4, (int) screenHeight / 4);
    }

    public static Config getInstance() {
        return instance;
    }

    public void setConfig(JFrame frame) {
        frame.setMinimumSize(windowSize);
        frame.getContentPane().setMinimumSize(windowSize);
        frame.setLocation(windowLocation);
    }

    public Dimension getCanvasSize() {
        return canvasSize;
    }
}
