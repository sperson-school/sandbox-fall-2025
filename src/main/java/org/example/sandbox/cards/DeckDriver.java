package org.example.sandbox.cards;

public class DeckDriver {

    public static void main(String[] args) {
        Deck deck = new StandardDeck();
        System.out.println("Deck created: " + deck);

        deck.shuffle();
        System.out.println("Deck shuffled: " + deck);

        deck.cut(26);
        System.out.println("Deck cut at 26: " + deck);

        //deal a card
        Card dealtCard = deck.dealCard();
        System.out.println("Dealt card: " + dealtCard);
        System.out.println("Deck after dealing a card: " + deck);

    }
}
