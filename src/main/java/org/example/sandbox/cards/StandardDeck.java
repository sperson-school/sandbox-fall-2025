package org.example.sandbox.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandardDeck implements Deck {

    private List<Card> cards;

    public StandardDeck() {
        this.cards = newDeck();

    }

    private List<Card> newDeck() {

        List<Card> newDeck = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (FaceValue faceValue : FaceValue.values()) {
                newDeck.add(new Card(suit, faceValue));
            }
        }

        return newDeck;
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public void cut(int index) {

        List<Card> top = new ArrayList<>(cards.subList(0, index));
        List<Card> bottom = new ArrayList<>(cards.subList(index, cards.size()));

        cards.clear();
        cards.addAll(bottom);
        cards.addAll(top);
    }

    @Override
    public Card dealCard() {
        return this.cards.remove(0);
    }

    @Override
    public Card turnOverTopCard() {
        return this.cards.get(0);
    }

    @Override
    public int cardsRemaining() {
        return this.cards.size();
    }

    @Override
    public int search(Card card) {
        return this.cards.indexOf(card);
    }

    @Override
    public void newOrder() {
        Collections.sort(cards);
    }

    @Override
    public void placeCardOnBottom(Card card) {
        cards.add(card);
    }

    @Override
    public void placeCardOnTop(Card card) {
        cards.add(0, card);
    }

    @Override
    public int size() {
        return this.cards.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StandardDeck{");
        sb.append("cards=").append(cards);
        sb.append('}');
        return sb.toString();
    }
}
