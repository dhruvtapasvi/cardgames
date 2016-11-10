package Cards;

/**
 * Created by dhruvtapasvi on 07/11/2016.
 */
public enum Number {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    private static final Number[] numbers = values();
    private static final int numNumbers = numbers.length;

    public boolean hasNext() {
        return ordinal() != numNumbers;
    }

    public Number next() {
        return numbers[(ordinal() + 1) % numNumbers];
    }

    public boolean hasPrevious() {
        return ordinal() != 0;
    }

    public Number previous() {
        return ordinal() == 0 ? numbers[numNumbers - 1] : numbers[ordinal() - 1];
    }

    public boolean strongerThan(Number n) {
        return strength() - n.strength() > 0;
    }

    public int strength() {
        return (this == ACE) ? numNumbers : ordinal();
    }
}
