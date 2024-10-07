package Maman11.ExAWarGame;

import Maman11.ExAWarGame.GameObjects.Card;
import Maman11.ExAWarGame.GameObjects.CardsPack;

public class WarGame implements Game {

    private static final int warLength = 3;

    private CardsPack deck;
    private CardsPack playerOnePack;
    private CardsPack playerTwoPack;

    @Override
    public void startGame() {
        this.deck = new CardsPack(true);
        this.playerOnePack = new CardsPack(false);
        this.playerTwoPack = new CardsPack(false);
        this.dealCards();
    }


    private void dealCards() {
        this.deck.shufflePack();
        int size = this.deck.getCards().size();
        for (int i = 0; i < size / 2; i++) {
            this.playerOnePack.addCard(this.deck.getCards().get(i));
        }
        for (int i = size / 2; i < size; i++) {
            this.playerTwoPack.addCard(this.deck.getCards().get(i));
        }
    }

    @Override
    public void runGame() {
        this.startGame();
        while (!this.playerOnePack.getCards().isEmpty() && !this.playerTwoPack.getCards().isEmpty()) {
            this.playerOnePack.shufflePack();
            this.playerTwoPack.shufflePack();
            this.playRound();
        }
        this.determineWinner();
    }

    @Override
    public void playRound() {

        System.out.printf("\nPlayer one cards pack: %d, Player two cards pack: %d \n", this.playerOnePack.getCards().size(), this.playerTwoPack.getCards().size());
        Card playerOneCard = this.playerOnePack.getCards().removeLast();
        Card playerTwoCard = this.playerTwoPack.getCards().removeLast();

        CardsPack RoundCardsPack = new CardsPack(false);
        RoundCardsPack.addCard(playerOneCard);
        RoundCardsPack.addCard(playerTwoCard);

        boolean roundEnd = cardsContest(playerOneCard, playerTwoCard, RoundCardsPack);
        if (roundEnd) return;
        warRound(playerOneCard, playerTwoCard, RoundCardsPack);
    }

    private void warRound(Card playerOneCard, Card playerTwoCard, CardsPack warCardsPack) {
        System.out.println("\nStart war");

        while (playerOneCard.getCardValue().equals(playerTwoCard.getCardValue()) &&
                this.playerOnePack.getCards().size() > warLength &&
                this.playerTwoPack.getCards().size() > warLength) {

            System.out.println("War round");

            for (int i = 1; i < warLength; i++) {
                System.out.printf("%d ....\n", i);
                warCardsPack.addCard(this.playerOnePack.pullCard());
                warCardsPack.addCard(this.playerTwoPack.pullCard());
            }

            playerOneCard = this.playerOnePack.pullCard();
            playerTwoCard = this.playerTwoPack.pullCard();
            warCardsPack.addCard(playerOneCard);
            warCardsPack.addCard(playerTwoCard);

            boolean roundEnd = cardsContest(playerOneCard, playerTwoCard, warCardsPack);
            if (roundEnd) return;


        }
    }

    private boolean cardsContest(Card playerOneCard, Card playerTwoCard, CardsPack TablePack) {
        System.out.printf("Player one card: %s%n", playerOneCard);
        System.out.printf("Player two card: %s%n", playerTwoCard);

        if (playerOneCard.compareTo(playerTwoCard) > 0) {
            System.out.printf("Player one won the round%n");
            this.playerOnePack.addPack(TablePack);
            return true;
        }

        if (playerOneCard.compareTo(playerTwoCard) < 0) {
            System.out.printf("Player two won the round%n");
            this.playerTwoPack.addPack(TablePack);
            return true;
        }

        return false;
    }

    @Override
    public void restartGame() {
        dealCards();
    }

    @Override
    public void determineWinner() {
        if (this.playerOnePack.getCards().size() > this.playerTwoPack.getCards().size()) {
            System.out.println("Player one wins!");
        } else {
            System.out.println("Player two wins!");
        }
    }


    public static void main(String[] args) {
        WarGame game = new WarGame();
        game.runGame();
    }
}
