package Maman11.ExAHitStampGame;

import java.util.*;

public class HitStampGame implements Game {
    private final int numDigits;
    private String secretNumber;


    public HitStampGame(int numDigits) {
        this.numDigits = numDigits;
    }

    @Override
    public void startGame() {
        secretNumber = generateSecretNumber(this.numDigits);
        System.out.printf("A secret number has been generated (with %s digits), Try to guess it!\n", this.numDigits);
    }

    @Override
    public void playRound() {
        throw new IllegalArgumentException("You should insert guess every round");
    }


    public boolean playRound(String guess) {
        int exactDigits = this.countExactDigits(guess);
        int rightNumbers = this.countRightNumbers(guess);
        System.out.println("Right numbers not in exact locations: " + rightNumbers + ", Right numbers in exact locations: " + exactDigits);
        if (guess.equals(secretNumber)) {
            System.out.printf("You guessed secret number %s.\n", secretNumber);
            return true;
        }

        return false;


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

        System.out.println("Welcome to the HitStamp Game!");

        int numDigits = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter the number of digits for the secret number: ");
            try {
                numDigits = scanner.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }


        HitStampGame game = new HitStampGame(numDigits);
        game.startGame();

        boolean isToExit = false;
        boolean hasWon;
        while (!isToExit) {

            int guess = 0;
            validInput = false;

            while (!validInput) {
                System.out.println("Enter your guess: ");
                try {
                    guess = scanner.nextInt();
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.next();
                }
            }


            hasWon = game.playRound(String.valueOf(guess));
            if (hasWon) {
                System.out.println("Do you want to play again? (y/n): ");
                String answer = scanner.next();
                if (!answer.equals("y")) {
                    isToExit = true;
                } else {
                    game.restartGame();
                }
            }
        }
        scanner.close();
    }

}