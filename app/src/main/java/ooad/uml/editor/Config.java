package ooad.uml.editor;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * This class represents the GUI configuration of the application.
 * 
 * <p>
 * Use the singleton pattern since only 1 instance of Config is needed.
 * https://en.wikipedia.org/wiki/Singleton_pattern
 * <p>
 * The problem is: whenever a new graphic class is introduced, this file
 * probably needs to be changed. As more classes are added, it also becomes
 * larger and larger.
 * <p>
 * The solution is: (Refactor) **keep minimal, component independent**
 * information such as `screenWidth`, `screenHeight` stored in Config.java.
 * Move other component dependent info to their own class.
 */
public class Config {
    private static Config instance = new Config(); // eager initialization
    /*
     * They are kink of componet independent information
     * since windowWidth and windowHeight are related to
     * the size of the screen which is component independent.
     * 
     * * They will be uesd to calculate the size of other components.
     */
    private double screenWidth;
    private double screenHeight;
    private int windowWidth;
    private int windowHeight;

    /** Declared as private to make sure that nobody can call the constructor */
    private Config() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.screenWidth = screenSize.getWidth();
        this.screenHeight = screenSize.getHeight();
        this.windowWidth = (int) (screenWidth * 0.5);
        this.windowHeight = (int) (screenHeight * 0.7);
    }

    public static Config getInstance() {
        return instance;
    }

    public double getScreenWidth() {
        return screenWidth;
    }

    public double getScreenHeight() {
        return screenHeight;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

}
