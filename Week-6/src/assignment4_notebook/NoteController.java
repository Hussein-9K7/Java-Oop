package assignment4_notebook;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class NoteController {
    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private Label outputLabel;

    private Notebook notebook;

    public void initialize() {
        notebook = new Notebook();
    }

    @FXML
    private void handleAddNote() {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (title.isEmpty() || content.isEmpty()) {
            outputLabel
