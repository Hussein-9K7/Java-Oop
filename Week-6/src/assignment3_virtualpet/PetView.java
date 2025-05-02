package assignment3_virtualpet;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PetView {
    private PetModel model;
    private PetController controller;
    private boolean mouseInside = false;
    private double mouseX = 0;
    private double mouseY = 0;

    public PetView(Stage stage) {
        model = new PetModel();
        controller = new PetController(model);

        Canvas canvas = new Canvas(600, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image petImage = new Image(getClass().getResourceAsStream("/pet.png"));

        canvas.setOnMouseMoved(e -> {
            mouseX = e.getX();
            mouseY = e.getY();
            mouseInside = true;
        });

        canvas.setOnMouseExited(e -> mouseInside = false);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (mouseInside) {
                    controller.moveTowards(mouseX, mouseY);
                }
                draw(gc, petImage);
            }
        }.start();

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Virtual Pet");
        stage.show();
    }

    private void draw(GraphicsContext gc, Image petImage) {
        gc.clearRect(0, 0, 600, 400);
        Pet pet = model.getPet();
        gc.drawImage(petImage, pet.getX(), pet.getY(), 40, 40);
    }
}
