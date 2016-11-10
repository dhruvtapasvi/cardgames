package Cards;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dhruvtapasvi on 08/11/2016.
 */
public class CardTest {
    @Test
    public void strongerThan_ReturnsFalse_WhenEqualCards() {
        // Given
        Card first = new Card(Suit.SPADES, Number.FIVE);
        Card second = new Card(Suit.SPADES, Number.FIVE);

        // Then
        assertFalse(first.strongerThan(second));
    }

    @Test
    public void strongerThan_ReturnsFalse_WhenSameSuitSecondStrongerThanFirst() {
        // Given
        Card first = new Card(Suit.SPADES, Number.FIVE);
        Card second = new Card(Suit.SPADES, Number.JACK);

        // Then
        assertFalse(first.strongerThan(second));
    }

    @Test
    public void strongerThan_ReturnsTrue_WhenSameSuitFirstStrongThanSecond() {
        // Given
        Card first = new Card(Suit.SPADES, Number.JACK);
        Card second = new Card(Suit.SPADES, Number.FIVE);

        // Then
        assertTrue(first.strongerThan(second));
    }

    @Test
    public void strongerThan_TreatsAceAsStrongest() {
        // Given
        Card first = new Card(Suit.SPADES, Number.ACE);
        Card second = new Card(Suit.SPADES, Number.FIVE);

        // Then
        assertTrue(first.strongerThan(second));
    }

    @Test
    public void strongerThan_ReturnsTrue_WhenOfDifferentSuits() {
        // Given
        Card first = new Card(Suit.SPADES, Number.TWO);
        Card second = new Card(Suit.HEARTS, Number.ACE);

        // Then
        assertTrue(first.strongerThan(second));
        assertTrue(second.strongerThan(first));
    }

    @Test
    public void strongerThan_ReturnsTrue_WhenFirstTrumpAndSecondNot() {
        // Given
        Card first = new Card(Suit.SPADES, Number.TWO);
        Card second = new Card(Suit.DIAMONDS, Number.ACE);

        // Then
        assertTrue(first.strongerThan(second, Suit.SPADES));
    }

    @Test
    public void strongerThan_ReturnsTrue_WhenSecondTrumpAndFirstNot() {
        // Given
        Card first = new Card(Suit.SPADES, Number.ACE);
        Card second = new Card(Suit.HEARTS, Number.KING);

        // Then
        assertFalse(first.strongerThan(second, Suit.HEARTS));
    }

    @Test
    public void strongerThan_IgnoresTrump_WhenBothTrump() {
        // Given
        Card first = new Card(Suit.SPADES, Number.FIVE);
        Card second = new Card(Suit.SPADES, Number.FOUR);

        // Then
        assertTrue(first.strongerThan(second, Suit.SPADES));
    }

    @Test
    public void strongerThan_IgnoresTrump_WhenNeitherTrump() {
        // Given
        Card first = new Card(Suit.SPADES, Number.FIVE);
        Card second = new Card(Suit.SPADES, Number.FOUR);

        // Then
        assertTrue(first.strongerThan(second, Suit.HEARTS));
    }
}