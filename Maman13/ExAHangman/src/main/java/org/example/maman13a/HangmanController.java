package org.example.maman13a;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HangmanController {
    private final HangmanModel model;
    private final HangmanView view;
    private Label wordProgressLabel;
    private Label incorrectGuessesLabel;

    public HangmanController(HangmanModel model, HangmanView view) {
        this.model = model;
        this.view = view;
        initialize();
    }

    private void initialize() {
        wordProgressLabel = new Label(model.getWordProgress());
        incorrectGuessesLabel = new Label(String.format("Number of incorrect guesses: %d", model.getIncorrectGuesses()));

        VBox layout = view.getMainLayout();
        layout.getChildren().add(wordProgressLabel);
        layout.getChildren().add(incorrectGuessesLabel);

        view.getLetterInputField().setOnAction(_ -> {
            String input = view.getLetterInputField().getText().toUpperCase();

            if (validateInput(input)) {
                char selectedLetter = input.charAt(0); // Get the first letter

                // Process the guess
                boolean correct = model.guessLetter(selectedLetter);
                wordProgressLabel.setText(model.getWordProgress());
                incorrectGuessesLabel.setText(String.format("Number of incorrect guesses: %d", model.getIncorrectGuesses()));

                // Update the view for incorrect guesses
                if (!correct) {
                    view.drawHangman(model.getIncorrectGuesses());
                }

                // Clear the TextField after processing
                view.getLetterInputField().clear();

                // Check if the game is over
                if (model.isGameOver()) {
                    endGame();
                }
            } else {
                // Invalid input handling
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Please enter a single valid letter!");
                alert.showAndWait();
                view.getLetterInputField().clear(); // Clear input field for new input
            }
        });
    }

    // Validate that the input is a single letter
    private boolean validateInput(String input) {
        return input != null && input.length() == 1 && Character.isLetter(input.charAt(0));
    }

    // Show game over message
    private void endGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (model.isWordGuessed()) {
            alert.setContentText("Congratulations! You've guessed the word: " + model.getWordToGuess());
        } else {
            alert.setContentText("Game over! The word was: " + model.getWordToGuess());
        }
        alert.showAndWait();
    }
}
