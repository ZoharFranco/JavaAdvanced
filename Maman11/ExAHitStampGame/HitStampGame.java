package Maman11.ExAHitStampGame;

import javax.swing.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class HitStampGame implements Game {
    private final int numDigits;
    private String secretNumber;

    public String getSecretNumber() {
        return secretNumber;
    }

    public HitStampGame(int numDigits) {
        this.numDigits = numDigits;
    }

    @Override
    public void startGame() {
        secretNumber = generateSecretNumber(this.numDigits);
        JOptionPane.showMessageDialog(null, String.format("A secret number has been generated (with %s digits), Try to guess it!\n", this.numDigits));
    }

    @Override
    public void playRound() {
        throw new IllegalArgumentException("You should insert guess every round");
    }


    public String playRound(String guess, int guessNumber) {
        int exactDigits = this.countExactDigits(guess);
        int rightNumbers = this.countRightNumbers(guess);
        String message = String.format("You guessed %s.\n Right numbers not in exact locations: %s, Right numbers in exact locations: %s \n",
                guess, rightNumbers, exactDigits);
        if (guess.equals(secretNumber)) {
            message += String.format("You guessed the secret number %s. Number of guesses: %d\n", secretNumber, guessNumber);

        }
        return message;


    }

    @Override
    public void restartGame() {
        startGame();
    }


    private String generateSecretNumber(int numDigits) {
        Random random = new Random();
        Set<Integer> digitsSet = new HashSet<>();
        StringBuilder secret = new StringBuilder();

        while (secret.length() < this.numDigits) {
            int digit = random.nextInt(10);
            if (!digitsSet.contains(digit)) {
                secret.append(digit);
                digitsSet.add(digit);
            }
        }
        return secret.toString();
    }


    // Count the number of correct digit in the correct position
    private int countExactDigits(String guess) {
        int exactDigits = 0;
        for (int i = 0; i < this.secretNumber.length(); i++) {
            if (this.secretNumber.charAt(i) == guess.charAt(i)) {
                exactDigits++;
            }
        }
        return exactDigits;
    }

    // Count the number of correct digit in the wrong position
    private int countRightNumbers(String guess) {
        int rightNumbers = 0;
        for (int i = 0; i < guess.length(); i++) {
            char guessDigit = guess.charAt(i);
            if (i < this.secretNumber.length() && this.secretNumber.indexOf(guessDigit) != -1 && this.secretNumber.charAt(i) != guessDigit) {
                rightNumbers++;
            }
        }
        return rightNumbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        JOptionPane.showMessageDialog(null, "Welcome to the HitStamp Game!");

        int numDigits = 0;
        boolean validInput = false;


        while (!validInput) {
            try {
                numDigits = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of digits for the secret number: "));
                validInput = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }


        HitStampGame game = new HitStampGame(numDigits);
        game.startGame();

        StringBuilder gameBoard = new StringBuilder();
        boolean isToExit = false;

        int guess = 0;

        while (!isToExit) {


            int numberGuesses = 0;
            validInput = false;

            while (!validInput) {

                try {
                    guess = Integer.parseInt(JOptionPane.showInputDialog(gameBoard + "Enter your guess:"));
                    validInput = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
                }
            }

            numberGuesses += 1;
            gameBoard.append(game.playRound(String.valueOf(guess), numberGuesses));

            if (String.valueOf(guess).equals(game.getSecretNumber())) {
                JOptionPane.showMessageDialog(null, gameBoard);
                String RestartAnswer = JOptionPane.showInputDialog("Do you want to play again? (y/n): ");
                if (!RestartAnswer.equals("y")) {
                    isToExit = true;
                } else {
                    game.restartGame();
                    guess = 0;
                    gameBoard = new StringBuilder();
                }
            }
        }
        scanner.close();
    }

}