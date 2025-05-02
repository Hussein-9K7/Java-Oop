package assignment2_currencyconverter;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CurrencyView {
    private CurrencyController controller;

    public CurrencyView(Stage stage) {
        controller = new CurrencyController();

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        Label fromLabel = new Label("From:");
        ComboBox<Currency> fromBox = new ComboBox<>();
        fromBox.getItems().addAll(controller.getCurrencies());

        Label toLabel = new Label("To:");
        ComboBox<Currency> toBox = new ComboBox<>();
        toBox.getItems().addAll(controller.getCurrencies());

        Button convertButton = new Button("Convert");
        Label resultLabel = new Label("Result:");
        TextField resultField = new TextField();
        resultField.setEditable(false);

        Label instructions = new Label("Enter an amount, select currencies, and press Convert.");

        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                Currency from = fromBox.getValue();
                Currency to = toBox.getValue();
                if (from == null || to == null) {
                    resultField.setText("Select both currencies.");
                } else {
                    double result = controller.convert(amount, from, to);
                    resultField.setText(String.format("%.2f", result));
                }
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid amount.");
            }
        });

        GridPane layout = new GridPane();
        layout.setHgap(10);
        layout.setVgap(10);

        layout.add(instructions, 0, 0, 2, 1);
        layout.add(amountLabel, 0, 1);
        layout.add(amountField, 1, 1);
        layout.add(fromLabel, 0, 2);
        layout.add(fromBox, 1, 2);
        layout.add(toLabel, 0, 3);
        layout.add(toBox, 1, 3);
        layout.add(convertButton, 0, 4);
        layout.add(resultLabel, 0, 5);
        layout.add(resultField, 1, 5);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Currency Converter");
        stage.show();
    }
}
