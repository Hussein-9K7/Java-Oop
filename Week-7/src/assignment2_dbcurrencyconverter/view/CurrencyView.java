package assignment2_dbcurrencyconverter.view;

import assignment2_dbcurrencyconverter.controller.CurrencyController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CurrencyView {
    private CurrencyController controller;

    public CurrencyView(Stage stage) {
        controller = new CurrencyController();

        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");

        ComboBox<String> fromBox = new ComboBox<>();
        fromBox.getItems().addAll("USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CHF", "CNY");

        ComboBox<String> toBox = new ComboBox<>();
        toBox.getItems().addAll("USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CHF", "CNY");

        Button convertButton = new Button("Convert");
        Label resultLabel = new Label();

        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String from = fromBox.getValue();
                String to = toBox.getValue();

                if (from == null || to == null) {
                    resultLabel.setText("Please select both currencies.");
                    return;
                }

                double result = controller.convert(amount, from, to);
                if (result == -1) {
                    resultLabel.setText("Error fetching rates.");
                } else {
                    resultLabel.setText(String.format("%.2f", result));
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid amount.");
            }
        });

        VBox layout = new VBox(10, amountField, fromBox, toBox, convertButton, resultLabel);
        Scene scene = new Scene(layout, 300, 250);

        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }
}
