package ooad.uml.editor;

import java.awt.*;

/**
 * This class represents the GUI configuration of the application.
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

    private Color menuBarColor;
    private Dimension menuSize;

    private Dimension toolBarPanelSize;
    private Color toolBarPanelColor;
    private Dimension toolBarSize;
    private Color toolBarColor;

    private final int buttonCount = 6; // Default number of buttons in the left hand side toolbar
    private Dimension buttonSize;

    /** Declared as private to make sure that nobody can call the constructor */
    private Config() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double factor1 = 0.6;
        double factor2 = 0.2;

        // Store the values of windowWidth and windowHeight to prevent duplicated calls
        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();
        int windowWidth = (int) (screenWidth * 0.5);
        int windowHeight = (int) (screenHeight * 0.7);

        windowSize = new Dimension(windowWidth, windowHeight);
        windowLocation = new Point((int) screenWidth / 4, (int) screenHeight / 8);

        canvasSize = new Dimension((int) (windowWidth * factor1), (int) (windowHeight));
        canvasColor = Color.WHITE;

        menuBarColor = Color.LIGHT_GRAY;
        menuSize = new Dimension(40, 40);

        toolBarPanelSize = new Dimension((int) (windowWidth * factor2), windowHeight);
        toolBarPanelColor = Color.LIGHT_GRAY;
        toolBarSize = toolBarPanelSize;
        toolBarColor = toolBarPanelColor;

        buttonSize = new Dimension((int) (windowWidth * factor2 - 20), (int) windowHeight / (buttonCount + 1));
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

    public Color getMenuBarColor() {
        return menuBarColor;
    }

    public Dimension getMenuSize() {
        return menuSize;
    }

    public Dimension getToolBarPanelSize() {
        return toolBarPanelSize;
    }

    public Color getToolBarPanelColor() {
        return toolBarPanelColor;
    }

    public Dimension getToolBarSize() {
        return toolBarSize;
    }

    public Color getToolBarColor() {
        return toolBarColor;
    }

    public Dimension getButtonSize() {
        return buttonSize;
    }

}
