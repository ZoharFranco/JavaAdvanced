package Year2023.Maman11.ExAWarGame.GameObjects;

import java.util.ArrayList;
import java.util.Collections;


// CardsPack class to hold a list of Card objects
public class CardsPack {
    private final ArrayList<Card> cards;


    public CardsPack(boolean isFull) {
        this.cards = new ArrayList<>();
        if (isFull) this.initializeFullPack();  // Add all 52 this.cards to the pack
    }


    private void initializeFullPack() {
        for (CardSign sign : CardSign.values()) {
            for (CardValue value : CardValue.values()) {
                this.cards.add(new Card(value, sign));
            }
        }
    }


    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public Card pullCard() {
        return this.cards.removeLast();
    }

    public void addCard(Card card) {
        this.cards.addFirst(card);
    }

    public void addPack(CardsPack cardPack) {
        for (Card card : cardPack.getCards()) {
            this.addCard(card);
        }
    }


    public void displayPack() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }


    public void shufflePack() {
        Collections.shuffle(this.cards);
    }
}