package org.example.maman13a;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class HangmanModel {
    private String wordToGuess;
    private final Set<Character> guessedLetters = new HashSet<>();
    private int incorrectGuesses = 0;
    private final int maxGuesses;

    public HangmanModel(int maxGuesses) {
        this.wordToGuess = this.generateRandomWord();
        this.maxGuesses = maxGuesses;
    }


    public String generateRandomWord() {
        String[] words = this.getAllWords();
        return words[(int) (Math.random() * words.length)];
    }

    public String[] getAllWords() {
        Path filePath = Paths.get("words.txt"); // Make sure the file is in the correct directory
        try {
            String content = Files.readString(filePath);
            return content.split("[,\\s]+");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public int getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public boolean isGameOver() {
        return incorrectGuesses >= this.maxGuesses || isWordGuessed();
    }

    public boolean isWordGuessed() {
        for (char letter : wordToGuess.toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }

    public boolean guessLetter(char letter) {
        letter = Character.toLowerCase(letter);
        if (guessedLetters.contains(letter)) {
            return false;
        }
        guessedLetters.add(letter);
        if (!wordToGuess.contains(String.valueOf(letter))) {
            incorrectGuesses++;
            return false;
        }
        return true;
    }

    public String getWordProgress() {
        StringBuilder progress = new StringBuilder();
        for (char letter : wordToGuess.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                progress.append(letter).append(" ");
            } else {
                progress.append("_ ");
            }
        }
        return progress.toString().trim();
    }


    public void reset() {
        incorrectGuesses = 0;
        guessedLetters.clear();
        this.wordToGuess = this.generateRandomWord();
    }
}
