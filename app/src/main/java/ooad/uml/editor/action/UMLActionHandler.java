package ooad.uml.editor.action;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JToolBar;

import ooad.uml.editor.graphics.toolbar.*;

/**
 * use the singleton pattern since only 1 instance is needed.
 * https://en.wikipedia.org/wiki/Singleton_pattern
 */
public class UMLActionHandler {
    private static UMLActionHandler instance = new UMLActionHandler(); // eager initialization

    private UMLActionHandler() {
    }

    public static UMLActionHandler getInstance() {
        return instance;
    }

    /**
     * Handle the button action event.
     * 
     * @param source the source object on which the action event occurs
     */
    public void handleButtonAction(Object source, String actionCommand) {
        System.out.println(actionCommand);

        /** 
         * SelectButton, AssociationLineButton,
         * GeneralizationLineButton,
         * CompositionLineButton,
         * ClassButton, UseCaseButton
         * 
         * Use a switch statement to handle the button action
         * seems to be a bad idea.
         * TODO: refactor to improve maintainability and code quality
         */
        Button button = (Button) source;
        JToolBar toolBar = (JToolBar) button.getParent();
        ArrayList <Button> buttons = new ArrayList <Button> ();
        for (Component b : toolBar.getComponents()) {
            b.setBackground(Color.WHITE);
            System.out.println(b);
            buttons.add((Button) b);
        }
        switch (actionCommand) {
            case "SelectButton":
                
                break;
            case "AssociationLineButton":
            
                break;
            case "GeneralizationLineButton":
            
                break;
            case "CompositionLineButton":
            
                break;
            case "ClassButton":
                button.setBackground(Color.DARK_GRAY);
                break;
            case "UseCaseButton":
                button.setBackground(Color.DARK_GRAY);
                break;
            default:
                break;
        }

    }

}
