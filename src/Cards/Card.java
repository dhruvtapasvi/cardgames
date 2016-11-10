package Cards;

/**
 * Created by dhruvtapasvi on 07/11/2016.
 */
public class Card {
    private final Suit suit;
    private final Number number;
    private final String printFormat = "%s of %s";

    public Card(Suit suit, Number number) {
        this.suit = suit;
        this.number = number;
    }

    public boolean strongerThan(Card card) {
        return (this.suit != card.suit || this.number.strongerThan(card.number));
    }

    public boolean strongerThan(Card card, Suit trump) {
        return (this.suit == card.suit && this.number.strongerThan(card.number) || card.suit != trump);
    }

    public boolean equals(Object o) {
        if (!(o instanceof Card)) return false;
        Card other = (Card) o;
        return (this.suit == other.suit && this.number == other.number);
    }

    // This effectively does number * 16 ^ suit
    // TODO: Decide whether we want number * 13 ^ suit instead
    public int hashCode() {
        return (number.ordinal()<<(suit.ordinal()<<2));
    }

    public String toString() {
        return String.format(printFormat, number, suit);
    }
}
