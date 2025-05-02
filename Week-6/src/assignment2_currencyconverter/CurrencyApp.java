package assignment2_currencyconverter;

import javafx.application.Application;
import javafx.stage.Stage;

public class CurrencyApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        new CurrencyView(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
