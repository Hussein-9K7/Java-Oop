package assignment3_virtualpet;

import javafx.application.Application;
import javafx.stage.Stage;

public class PetApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        new PetView(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
