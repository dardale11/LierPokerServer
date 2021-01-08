package com.imagine.LiersPoker.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.imagine.LiersPoker.models.enums.HandType;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Hand implements Comparable {
    @JsonProperty("cards")
    private Card cards [];

    public Hand() {
        this.cards = new Card[5];
    }

    public Hand(Card[] cards) {
        this.cards = cards;
    }

    private int getHandScore() {
        int ans = 0;
        int cardCount [] = new int[15];
        for (Card card : cards) {
            cardCount[card.getRank()]++;
        }

        for (int index = 1; index < 15; index++) {
            ans += Math.pow(10, cardCount[index]) * index;
        }

       return ans;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    @Override
    public int compareTo(Object o) {
        return this.compareTo((Hand) o);
    }


    private int compareTo(Hand secondHand){
        return this.getHandScore() - secondHand.getHandScore();
    }
}
