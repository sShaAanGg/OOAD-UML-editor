package ooad.uml.editor;

import ooad.uml.editor.graphics.Canvas;
import ooad.uml.editor.graphics.Window;
import ooad.uml.editor.graphics.menu.MenuBar;
import ooad.uml.editor.graphics.toolbar.ToolBarPanel;

import java.awt.BorderLayout;

/**
 * This class represents the application.
 */
public class App {

    /** Declared as private to make sure that nobody can call the constructor */
    private App() {
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

    /** Starts the GUI application */
    private void start() {
        Window frame = new Window("My OOAD UML Editor");
        Canvas canvas = new Canvas();
        MenuBar menubar = new MenuBar();
        ToolBarPanel toolBarPanel = new ToolBarPanel();

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(toolBarPanel, BorderLayout.WEST);
        frame.getContentPane().add(canvas, BorderLayout.CENTER);
        frame.setJMenuBar(menubar);
        
        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
