package org.example.maman13a;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HangmanModel {
    private final String wordToGuess;
    private final Set<Character> guessedLetters = new HashSet<>();
    private int incorrectGuesses = 0;
    private final int maxGuesses;

    public HangmanModel(int wordLength, int maxGuesses) {
        this.wordToGuess = this.generateRandomWord(wordLength);
        this.maxGuesses = maxGuesses;
    }


    // Generate a random word with a given length
    public String generateRandomWord(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            word.append(alphabet.charAt(index));
        }

        return word.toString();
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
        letter = Character.toUpperCase(letter);
        if (guessedLetters.contains(letter)) {
            return false; // Letter already guessed
        }
        guessedLetters.add(letter);
        if (!wordToGuess.contains(String.valueOf(letter))) {
            incorrectGuesses++;
            return false; // Incorrect guess
        }
        return true; // Correct guess
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
}
