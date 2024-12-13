package org.example.maman13a;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import javax.swing.*;

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

        view.drawHangman(model.getIncorrectGuesses());

        view.getLetterInputField().setOnAction(_ -> {
            String input = view.getLetterInputField().getValue().toUpperCase();

            if (validateInput(input)) {
                char selectedLetter = input.charAt(0);
                boolean correct = model.guessLetter(selectedLetter);
                wordProgressLabel.setText(model.getWordProgress());
                incorrectGuessesLabel.setText(String.format("Number of incorrect guesses: %d", model.getIncorrectGuesses()));
                if (!correct) {
                    view.drawHangman(model.getIncorrectGuesses());
                }

                if (model.isGameOver()) {
                    endGame();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Please enter a single valid letter!");
                alert.showAndWait();

            }
        });
    }

    private boolean validateInput(String input) {
        return input != null && input.length() == 1 && Character.isLetter(input.charAt(0));
    }


    private void endGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (model.isWordGuessed()) {
            alert.setContentText("Congratulations! You've guessed the word: " + model.getWordToGuess());
        } else {
            alert.setContentText("Game over! The word was: " + model.getWordToGuess());
        }
        alert.showAndWait();


        int response = JOptionPane.showOptionDialog(null, "Do you want to play another game?", "Game Over",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Yes", "No"}, JOptionPane.YES_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            reset();
        } else {
            System.exit(0);
        }

    }

    private void reset() {
        model.reset();
        view.drawHangman(model.getIncorrectGuesses());
        incorrectGuessesLabel.setText(String.format("Number of incorrect guesses: %d", model.getIncorrectGuesses()));
        wordProgressLabel.setText(model.getWordProgress());
    }
}
