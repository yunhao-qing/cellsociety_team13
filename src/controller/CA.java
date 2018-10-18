package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import UI.UIManager;

/**
 * @author Julia Saveliff
 */
public class CA extends Application {

    /**
     * Initialize and show the stage. Call UIManager to handle all user interface components and updates.
     * @param stage: A JavaFx Stage object.
     */
    @Override
    public void start(Stage stage) {
        var UI = new UIManager(stage);
        UI.create();

        stage.sizeToScene();
        stage.show();
    }

    /**
     * Start the program.
     */
    public static void main(String[] args) {
        launch(args);
    }

}