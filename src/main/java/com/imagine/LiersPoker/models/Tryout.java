package com.imagine.LiersPoker.models;

public class Tryout {
    Card cards[];

    public Tryout(Card[] cards) {
        this.cards = cards;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
}
