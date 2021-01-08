package com.imagine.LiersPoker.models;

import com.imagine.LiersPoker.models.enums.Suite;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameSession {
    Player players [];
    int startingPlayerIndex;
    int currentPlayerIndex;
    int prevPlayerIndex;
    int cardsNumber;
    Hand currentHand;
    List<Card> deck;

    public void initRound() {
        this.generateDeck();
        this.dealCards();
    }

    private void generateDeck() {
        List<Card> deck = new LinkedList<>();
        for (int indexRank = 2; indexRank <= 14; indexRank++) {
            for (Suite suite : Suite.values()) {
                deck.add(new Card(indexRank, suite, "assets/images/" + indexRank + suite + ".jpg"));
            }
        }
        Random rand = new Random();

        while (!deck.isEmpty()) {
            this.deck.add(deck.remove(rand.nextInt(deck.size())));
        }
    }

    private void dealCards() {
        for (Player player : this.players) {
            if (player != null) {
                player.cards = new LinkedList<>();
                for (int indexCard = 0; indexCard < player.cardsNumber; indexCard++) {
                    player.cards.add(deck.remove(0));
                }
            }
        }
    }

    public void raiseHand(Hand hand) {
        currentHand = hand;
        prevPlayerIndex = currentPlayerIndex;
        currentPlayerIndex = getNextPlayerIndex(currentPlayerIndex);
    }

    private int getNextPlayerIndex(int playerIndex) {
        int nextPlayerIndex = (playerIndex+1) % players.length;
        while (true) {
            if (players[nextPlayerIndex].cardsNumber != 0) {
                currentPlayerIndex = nextPlayerIndex;
                break;
            }
            nextPlayerIndex = (nextPlayerIndex+1) % players.length;
        }
        return nextPlayerIndex;
    }

    public void callBluff(int playerId) {
        if (checkHandValid()) {
            for (Player player : players) {
                if (player.id == playerId){
                    player.cardsNumber--;
                    break;
                }
            }

        }
        else {
            players[currentPlayerIndex].cardsNumber--;
        }

        startingPlayerIndex = getNextPlayerIndex(startingPlayerIndex);

        initRound();
    }


    private boolean checkHandValid() {
        int cardsRankCount [] = new int [15];
        for (Player player : players) {
            for (Card card : player.cards) {
                cardsRankCount[card.getRank()]++;
            }
        }
        for (Card card : currentHand.getCards()) {
            cardsRankCount[card.getRank()]--;
            if (cardsRankCount[card.getRank()] < 0) {
                return false;
            }
        }
        return true;
    }
}
