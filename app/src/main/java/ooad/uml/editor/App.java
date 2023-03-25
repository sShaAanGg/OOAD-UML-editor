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

    /** Only for debugging */
    public App() {
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
        Window window = new Window("My OOAD UML Editor");
        Canvas canvas = new Canvas();
        MenuBar menubar = new MenuBar();
        ToolBarPanel toolBarPanel = new ToolBarPanel();

        window.getContentPane().setLayout(new BorderLayout());
        window.getContentPane().add(toolBarPanel, BorderLayout.WEST);
        window.getContentPane().add(canvas, BorderLayout.CENTER);
        window.setJMenuBar(menubar);

        // Display the window.
        window.pack();
        window.setVisible(true);
    }
}
