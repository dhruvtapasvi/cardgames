package Cards;

import java.util.HashSet;

/**
 * Created by dhruvtapasvi on 08/11/2016.
 */
public abstract class CardCollection {
    protected HashSet<Card> cards;

    public CardCollection() {
        cards = new HashSet<Card>();
    }

    // Should read a little more about how hash sets work before choosing the maximum size like this
    public CardCollection(int maxSize) {
        cards = new HashSet<Card>(maxSize);
    }

    public boolean hasCards() {
        return !cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    public boolean hasCard(Suit suit, Number number) {
        return hasCard(new Card(suit, number));
    }

    public boolean hasCard(Card card) {
        return cards.contains(card);
    }

    public boolean removeCard(Suit suit, Number number) {
        return removeCard(new Card(suit, number));
    }

    public boolean removeCard(Card card) {
        return cards.remove(card);
    }

    public boolean addCard(Suit suit, Number number) {
        return addCard(new Card(suit, number));
    }

    public boolean addCard(Card card) {
        return cards.add(card);
    }
}
