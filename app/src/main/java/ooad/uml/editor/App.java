package ooad.uml.editor;

import ooad.uml.editor.graphics.Canvas;
import java.awt.BorderLayout;
import javax.swing.*;

/**
 * This class represents the application.
 */
public class App {

    /** Declared as private to make sure that nobody can call the constructor */
    private App() {
    }

    /** Starts the GUI application */
    private void start() {
        JFrame frame = new JFrame("My OOAD UML Editor");
        Canvas canvas = new Canvas();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas, BorderLayout.CENTER);

        Config config = Config.getInstance();
        config.setConfig(frame);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        App application = new App();
        /**
         * Example code from https://docs.oracle.com/javase/tutorial/uiswing
         * Schedule a job for the event-dispatching thread:
         */ 
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                application.start();
            }
        });
    }
}
