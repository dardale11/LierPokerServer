package com.imagine.LiersPoker.models;

import com.imagine.LiersPoker.models.enums.Suite;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameSession {
    List<Player> players;
    int currentPlayer;
    int cardsNumber;
    List<Card> deck;

    public void initRound() {
        this.generateDeck();
        this.dealCards();
    }

    private void generateDeck() {
        List<Card> deck = new LinkedList<>();
        for (int indexRank = 1; indexRank <= 13; indexRank++) {
            for (Suite suite : Suite.values()) {
                deck.add(new Card(indexRank, suite));
            }
        }
        Random rand = new Random();

        while (deck.size() > 0) {
            this.deck.add(deck.remove(rand.nextInt(deck.size())));
        }
    }

    private void dealCards() {
        for (Player player : this.players) {
            player.cards = new LinkedList<>();
            for (int indexCard = 0; indexCard < player.cardsNumber; indexCard++) {
                player.cards.add(deck.remove(0));
            }
        }
    }
}
