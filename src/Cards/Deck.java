package Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dhruvtapasvi on 08/11/2016.
 */
public class Deck extends CardCollection {
    public Deck() {
        super(52);
        for (Suit suit: Suit.values()) {
            for (Number number: Number.values()) {
                addCard(suit, number);
            }
        }
    }

    public List<Hand> deal(int numHands, int cardsPerHand) {
        // If you request to deal more cards than available, this is permitted
        // The sizes of any two hands do not differ by more than one

        List<Hand> hands = new ArrayList<Hand>(numHands);
        for (int i=0; i<numHands; i++) hands.add(new Hand(cardsPerHand));

        List<Card> shuffled = getShuffledDeck();
        List<Card> truncated = shuffled.subList(0, Math.min(shuffled.size(), numHands * cardsPerHand));

        int handIndex = 0;
        for (Card card: truncated) {
            hands.get(handIndex % numHands).addCard(card);
            handIndex++;
        }

        return hands;
    }

    public List<Hand> dealAsManyAsPossible(int numHands) {
        int cardsPerHand = size() / numHands;
        return deal(numHands, cardsPerHand);
    }

    public List<Hand> dealAll(int numHands) {
        int cardsPerHand = size() / numHands + 1;
        return deal(numHands, cardsPerHand);
    }

    private List<Card> getShuffledDeck() {
        List<Card> shuffled = new ArrayList<Card>(super.cards);
        Collections.shuffle(shuffled);
        return shuffled;
    }
}
