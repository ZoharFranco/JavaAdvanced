package Year2023.Maman11.ExAWarGame;

public interface Game {
    // Starts or initializes the game
    void startGame();

    void runGame();

    // Plays one round of the game
    void playRound();

    void restartGame();

    // Determines the winner of the game
    void determineWinner();
}
