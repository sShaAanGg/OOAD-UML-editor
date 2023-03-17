package ooad.uml.editor;

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
    private Point windowLocation;
    private Dimension canvasSize;
    private Color canvasColor;
    private Dimension menuBarSize;
    private Dimension menuSize;
    private Dimension toolBarPanelSize;

    /** Declared as private to make sure that nobody can call the constructor */
    private Config() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double factor1 = 0.6;
        double factor2 = 0.2;

        double screenWidth = screenSize.getWidth(); // Store the values of windowWidth and windowHeight to prevent duplicated calls
        double screenHeight = screenSize.getHeight();
        int windowWidth = (int) (screenWidth * 0.5);
        int windowHeight = (int) (screenHeight * 0.7);

        windowSize = new Dimension(windowWidth, windowHeight);
        windowLocation = new Point((int) screenWidth / 4, (int) screenHeight / 6);

        canvasSize = new Dimension((int) (windowWidth * factor1), (int) (windowHeight));
        canvasColor = Color.WHITE;

        menuBarSize = new Dimension(windowWidth, (int) (windowHeight * factor1 * factor2));
        menuSize = new Dimension(40, 40);
        toolBarPanelSize = new Dimension((int) (windowWidth * factor2), windowHeight);
    }

    public static Config getInstance() {
        return instance;
    }

    public Dimension getWindowSize() {
        return windowSize;
    }

    public Point getWindowLocation() {
        return windowLocation;
    }

    public Dimension getCanvasSize() {
        return canvasSize;
    }

    public Color getCanvasColor() {
        return canvasColor;
    }

    public Dimension getMenuBarSize() {
        return menuBarSize;
    }

    public Dimension getMenuSize() {
        return menuSize;
    }

    public Dimension getToolBarPanelSize() {
        return toolBarPanelSize;
    }
}
