package assignment1_dictionary;

import javafx.application.Application;
import javafx.stage.Stage;

public class DictionaryApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        new DictionaryView(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
