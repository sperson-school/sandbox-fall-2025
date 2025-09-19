package org.example.sandbox.cards;

import java.util.Objects;

public class Card implements Comparable<Card> {
    private Suit suit;
    private FaceValue faceValue;

    private Card() {
        // Private constructor to prevent direct instantiation
    }

    public Card(Suit suit, FaceValue faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public FaceValue getFaceValue() {
        return faceValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && faceValue == card.faceValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, faceValue);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        sb.append(faceValue);
        sb.append(" of ").append(suit);
        sb.append(']');
        return sb.toString();
    }

    @Override
    public int compareTo(Card o) {
        if (o == null) {
            throw new NullPointerException("Cannot compare to null");
        }

        int suitComparison = this.suit.compareTo(o.suit);
        if (suitComparison != 0) {
            return suitComparison;
        }
        return this.faceValue.compareTo(o.faceValue);
    }
}
