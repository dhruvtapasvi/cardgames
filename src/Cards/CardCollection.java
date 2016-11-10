package Cards;

import java.util.HashSet;

/**
 * Created by dhruvtapasvi on 08/11/2016.
 */
public abstract class CardCollection {
    private int size  = 0;
    protected HashSet<Card> cards;

    public CardCollection() {
        cards = new HashSet<Card>();
    }

    public CardCollection(int maxSize) {
        cards = new HashSet<Card>(maxSize);
    }

    public boolean hasCards() {
        return (size == 0);
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
        if (cards.remove(card)) {
            size--;
            return true;
        } else {
            return false;
        }
    }

    public boolean addCard(Suit suit, Number number) {
        return addCard(new Card(suit, number));
    }

    public boolean addCard(Card card) {
        if (cards.add(card)) {
            size ++;
            return true;
        } else {
            return false;
        }
    }

    public int getSize() {
        return size;
    }
}
