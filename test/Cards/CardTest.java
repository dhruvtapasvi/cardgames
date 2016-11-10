package Cards;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dhruvtapasvi on 08/11/2016.
 */
public class CardTest {
    // TODO: Decide whether we want tests for the equals and hashCode methods

    public static class StrongerThan {
        @Test
        public void returnsFalse_WhenEqualCards() {
            // Given
            Card first = new Card(Suit.SPADES, Number.FIVE);
            Card second = new Card(Suit.SPADES, Number.FIVE);

            // Then
            assertFalse(first.strongerThan(second));
        }

        @Test
        public void returnsFalse_WhenSameSuitSecondStrongerThanFirst() {
            // Given
            Card first = new Card(Suit.SPADES, Number.FIVE);
            Card second = new Card(Suit.SPADES, Number.JACK);

            // Then
            assertFalse(first.strongerThan(second));
        }

        @Test
        public void returnsTrue_WhenSameSuitFirstStrongThanSecond() {
            // Given
            Card first = new Card(Suit.SPADES, Number.JACK);
            Card second = new Card(Suit.SPADES, Number.FIVE);

            // Then
            assertTrue(first.strongerThan(second));
        }

        @Test
        public void returnsTrue_WhenOfDifferentSuits() {
            // Given
            Card first = new Card(Suit.SPADES, Number.TWO);
            Card second = new Card(Suit.HEARTS, Number.ACE);

            // Then
            assertTrue(first.strongerThan(second));
            assertTrue(second.strongerThan(first));
        }

        @Test
        public void treatsAceAsStrongest() {
            // Given
            Card first = new Card(Suit.SPADES, Number.ACE);
            Card second = new Card(Suit.SPADES, Number.FIVE);

            // Then
            assertTrue(first.strongerThan(second));
        }

        @Test
        public void returnsTrue_WhenFirstTrumpAndSecondNot() {
            // Given
            Card first = new Card(Suit.SPADES, Number.TWO);
            Card second = new Card(Suit.DIAMONDS, Number.ACE);

            // Then
            assertTrue(first.strongerThan(second, Suit.SPADES));
        }

        @Test
        public void returnsFalse_WhenSecondTrumpAndFirstNot() {
            // Given
            Card first = new Card(Suit.SPADES, Number.ACE);
            Card second = new Card(Suit.HEARTS, Number.KING);

            // Then
            assertFalse(first.strongerThan(second, Suit.HEARTS));
        }

        @Test
        public void ignoresTrump_WhenBothTrump() {
            // Given
            Card first = new Card(Suit.SPADES, Number.FIVE);
            Card second = new Card(Suit.SPADES, Number.FOUR);

            // Then
            assertTrue(first.strongerThan(second, Suit.SPADES));
        }

        @Test
        public void ignoresTrump_WhenNeitherTrump() {
            // Given
            Card first = new Card(Suit.SPADES, Number.FIVE);
            Card second = new Card(Suit.SPADES, Number.FOUR);
            Card third = new Card(Suit.DIAMONDS, Number.ACE);

            // Then
            assertTrue(first.strongerThan(second, Suit.HEARTS));
            assertTrue(first.strongerThan(third));
        }
    }
}