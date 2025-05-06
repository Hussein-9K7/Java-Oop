package interfaceapp;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.CurrencyLogic;

public class UserScreen {
    private CurrencyLogic logic;

    public UserScreen(Stage stage) {
        logic = new CurrencyLogic();

        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");

        ComboBox<String> fromBox = new ComboBox<>();
        ComboBox<String> toBox = new ComboBox<>();

        fromBox.getItems().addAll("USD", "EUR", "GBP", "JPY");
        toBox.getItems().addAll("USD", "EUR", "GBP", "JPY");

        Button convertButton = new Button("Convert");
        Label resultLabel = new Label();

        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String from = fromBox.getValue();
                String to = toBox.getValue();

                if (from == null || to == null) {
                    resultLabel.setText("Select currencies");
                    return;
                }

                double result = logic.convert(amount, from, to);
                if (result == -1) {
                    resultLabel.setText("Error in conversion");
                } else {
                    resultLabel.setText(String.format("%.2f", result));
                }
            } catch (Exception ex) {
                resultLabel.setText("Invalid input");
            }
        });

        VBox layout = new VBox(10, amountField, fromBox, toBox, convertButton, resultLabel);
        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.setTitle("Currency Exchange");
        stage.show();
    }
}
