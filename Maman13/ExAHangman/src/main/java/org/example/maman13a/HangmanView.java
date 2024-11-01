package org.example.maman13a;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HangmanView {
    private final Canvas canvas;
    private final TextField letterInputField;
    private final VBox mainLayout;

    public HangmanView() {
        canvas = new Canvas(300, 300);

        letterInputField = new TextField();
        HBox letterInputFieldBox = new HBox();
        letterInputFieldBox.getChildren().add(letterInputField);
        letterInputFieldBox.setPrefWidth(50);
        letterInputFieldBox.setMaxWidth(80);

        mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(canvas, letterInputFieldBox);
        VBox.setMargin(letterInputFieldBox, new Insets(2, 2, 2, 2));


    }

    public Canvas getCanvas() {
        return canvas;
    }

    public TextField getLetterInputField() {
        return letterInputField;
    }

    public VBox getMainLayout() {
        return mainLayout;
    }

    // Draw the hangman based on the number of incorrect guesses
    public void drawHangman(int incorrectGuesses) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.strokeLine(50, 250, 150, 250); // Base
        gc.strokeLine(100, 250, 100, 50); // Pole
        gc.strokeLine(100, 50, 200, 50);  // Top
        gc.strokeLine(200, 50, 200, 100); // Rope

        if (incorrectGuesses >= 1) {
            gc.strokeOval(175, 100, 50, 50); // Head
        }
        if (incorrectGuesses >= 2) {
            gc.strokeLine(200, 150, 200, 200); // Body
        }
        if (incorrectGuesses >= 3) {
            gc.strokeLine(200, 170, 170, 150); // Left arm
        }
        if (incorrectGuesses >= 4) {
            gc.strokeLine(200, 170, 230, 150); // Right arm
        }
        if (incorrectGuesses >= 5) {
            gc.strokeLine(200, 200, 170, 250); // Left leg
        }
        if (incorrectGuesses >= 6) {
            gc.strokeLine(200, 200, 230, 250); // Right leg
        }
    }
}