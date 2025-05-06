package assignment3_jpacurrencyconverter.view;

import assignment3_jpacurrencyconverter.controller.CurrencyController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CurrencyView {
    private CurrencyController controller;

    public CurrencyView(Stage stage) {
        controller = new CurrencyController();

        TextField amountField = new TextField();
        amountField.setPromptText("Amount");

        ComboBox<String> fromBox = new ComboBox<>();
        ComboBox<String> toBox = new ComboBox<>();
        updateCurrencyChoices(fromBox, toBox);

        Button convertButton = new Button("Convert");
        Button addButton = new Button("Add Currency");
        Label resultLabel = new Label();

        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String from = fromBox.getValue();
                String to = toBox.getValue();

                if (from == null || to == null) {
                    resultLabel.setText("Select both currencies.");
                    return;
                }

                double result = controller.convert(amount, from, to);
                if (result == -1) {
                    resultLabel.setText("Conversion failed.");
                } else {
                    resultLabel.setText(String.format("%.2f", result));
                }
            } catch (Exception ex) {
                resultLabel.setText("Error: Invalid input.");
            }
        });

        addButton.setOnAction(e -> {
            showAddCurrencyWindow(stage);
            updateCurrencyChoices(fromBox, toBox);
        });

        VBox layout = new VBox(10, amountField, fromBox, toBox, convertButton, addButton, resultLabel);
        Scene scene = new Scene(layout, 350, 300);
        stage.setTitle("Currency Converter (JPA)");
        stage.setScene(scene);
        stage.show();
    }

    private void updateCurrencyChoices(ComboBox<String> fromBox, ComboBox<String> toBox) {
        fromBox.getItems().setAll("USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CHF", "CNY");
        toBox.getItems().setAll("USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CHF", "CNY");
    }

    private void showAddCurrencyWindow(Stage owner) {
        Stage newStage = new Stage();
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(owner);

        TextField abbrField = new TextField();
        abbrField.setPromptText("Abbreviation");

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField rateField = new TextField();
        rateField.setPromptText("Rate to USD");

        Button saveButton = new Button("Save");
        Label message = new Label();

        saveButton.setOnAction(e -> {
            try {
                String abbr = abbrField.getText().toUpperCase();
                String name = nameField.getText();
                double rate = Double.parseDouble(rateField.getText());

                boolean success = controller.addCurrency(abbr, name, rate);
                if (success) {
                    newStage.close();
                } else {
                    message.setText("Invalid input.");
                }
            } catch (Exception ex) {
                message.setText("Error saving currency.");
            }
        });

        VBox layout = new VBox(10, abbrField, nameField, rateField, saveButton, message);
        Scene scene = new Scene(layout, 300, 250);
        newStage.setScene(scene);
        newStage.setTitle("Add New Currency");
        newStage.showAndWait();
    }
}
