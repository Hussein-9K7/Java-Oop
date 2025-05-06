package interfaceapp;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppLauncher extends Application {
    @Override
    public void start(Stage primaryStage) {
        new UserScreen(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
