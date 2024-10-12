package Year2023.Maman11.ExAWarGame.GameObjects;

// Card class using the CardSign and Value Enums
public class Card implements Comparable<Card>, GameObject {
    private CardValue value;
    private CardSign sign;

    // Constructor
    public Card(CardValue value, CardSign sign) {
        this.value = value;
        this.sign = sign;
    }

    // Getter for value
    public CardValue getCardValue() {
        return this.value;
    }

    // Setter for value
    public void setCardValue(CardValue value) {
        this.value = value;
    }

    // Getter for sign
    public CardSign getCardSign() {
        return this.sign;
    }

    // Setter for sign
    public void setCardSign(CardSign sign) {
        this.sign = sign;
    }

    // toString method to display the card details
    @Override
    public String toString() {
        return this.value + " of " + this.sign;
    }

    @Override
    public int compareTo(Card card) {
        return this.value.compareTo(card.getCardValue());
    }
}
