package assignment1_dictionary;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView {
    private DictionaryController controller;

    public DictionaryView(Stage stage) {
        controller = new DictionaryController();

        Label label = new Label("Enter a word:");
        TextField wordField = new TextField();
        Button searchButton = new Button("Search");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setWrapText(true);

        searchButton.setOnAction(e -> {
            String word = wordField.getText();
            String meaning = controller.searchWord(word);
            resultArea.setText(meaning);
        });

        FlowPane layout = new FlowPane(10, 10);
        layout.getChildren().addAll(label, wordField, searchButton, resultArea);

        Scene scene = new Scene(layout, 400, 200);
        stage.setScene(scene);
        stage.setTitle("Virtual Dictionary");
        stage.show();
    }
}
