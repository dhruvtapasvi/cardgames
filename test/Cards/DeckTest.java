package Cards;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dhruvtapasvi on 08/11/2016.
 */
public class DeckTest {

    @RunWith(Theories.class)
    public static class Deal {

        private static class DealArguments {
            public int numHands;
            public int maxCardsPerHand;
            DealArguments(int numHands, int maxCardsPerHand) {
                this.numHands = numHands;
                this.maxCardsPerHand = maxCardsPerHand;
            }
        }


        // TODO: Consider a more systematic and comprehensive set of test cases
        @DataPoints
        public static DealArguments[] dealArguments() {
            return new DealArguments[] {
                    new DealArguments(1, 0),
                    new DealArguments(1, 10),
                    new DealArguments(1, 60),
                    new DealArguments(2, 0),
                    new DealArguments(2, 20),
                    new DealArguments(2, 30),
                    new DealArguments(3, 10),
                    new DealArguments(3, 20),
                    new DealArguments(5, 10),
                    new DealArguments(5, 11),
                    new DealArguments(100, 0),
                    new DealArguments(100, 1),
                    new DealArguments(100, 60)
            };
        }

        @Theory
        public void dealsTheCorrectNumberOfHands(DealArguments dealArguments) {
            // Given
            Deck deck = new Deck();

            // When
            List<Hand> hands = deck.deal(dealArguments.numHands, dealArguments.maxCardsPerHand);

            // Then
            assertEquals(dealArguments.numHands, hands.size());
        }

        @Theory
        public void dealsUptoMaxNumberOfHands(DealArguments dealArguments) {
            // Given
            Deck deck = new Deck();

            // When
            List<Hand> hands = deck.deal(dealArguments.numHands, dealArguments.maxCardsPerHand);

            //Then
            for (Hand hand: hands) {
                assertTrue(hand.size() <= dealArguments.maxCardsPerHand);
            }
        }

        @Theory
        public void dealsAllTheCardsItShould(DealArguments dealArguments) {
            // Given
            Deck deck = new Deck();

            // When
            List<Hand> hands = deck.deal(dealArguments.numHands, dealArguments.maxCardsPerHand);
            int totalCardsDealt = hands.stream().mapToInt(hand -> hand.size()).sum();

            // Then
            assertEquals(totalCardsDealt, Math.min(deck.size(), dealArguments.numHands * dealArguments.maxCardsPerHand));
        }

        @Theory
        public void dealsCardsEvenly(DealArguments dealArguments) {
            // Given
            Deck deck = new Deck();

            // When
            List<Hand> hands = deck.deal(dealArguments.numHands, dealArguments.maxCardsPerHand);
            int maxSize = hands.stream().mapToInt(hand -> hand.size()).max().getAsInt();
            int minSize = hands.stream().mapToInt(hand -> hand.size()).min().getAsInt();

            // Then
            assertTrue(maxSize - minSize <= 1);
        }
    }
}