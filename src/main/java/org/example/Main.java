package org.example;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        MenuApp menuApp = new MenuApp();
        menuApp.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
