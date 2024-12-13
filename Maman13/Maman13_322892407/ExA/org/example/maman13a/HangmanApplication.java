package org.example.maman13a;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HangmanApplication extends Application {
    @Override
    public void start(Stage primaryStage) {


        int MAX_GUESSES = 6; // Can be change but the drawing is const for 6 errors
        this.playGame(primaryStage, MAX_GUESSES);



    }

    public void playGame(Stage primaryStage, int maxGuesses) {
        HangmanModel model = new HangmanModel(maxGuesses);
        HangmanView view = new HangmanView();
        new HangmanController(model, view);

        Scene scene = new Scene(view.getMainLayout(), 400, 400);

        primaryStage.setTitle("Hangman Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
