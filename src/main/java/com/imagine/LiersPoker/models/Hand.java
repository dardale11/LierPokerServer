package com.imagine.LiersPoker.models;

import com.imagine.LiersPoker.models.enums.HandType;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Hand implements Comparable {
    private Map<HandType, LinkedList<Integer>> map;
    private HandType type;

    Hand(Card[] cards) {
        this.map = new HashMap<>();
        this.setHandFromCards(cards);
        this.setHandType();
    }

    private void setHandFromCards(Card[] cards) {
        int[] cardCount = new int[14];
        for (Card card : cards) {
            cardCount[card.getRank()]++;
        }
        for (int index = 1; index < 14; index ++) {
            HandType tempType;
            switch (cardCount[index]) {
                case 1:
                    tempType = HandType.SINGLE;
                    break;
                case 2:
                    tempType = HandType.PAIR;
                    break;
                case 3:
                    tempType = HandType.TRIPLET;
                    break;
                case 4:
                    tempType = HandType.FOURET;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + cardCount[index]);
            }
            LinkedList<Integer> tempList;
            if (map.containsValue(tempType)) {
                tempList = map.get(tempType);
                tempList.add(index);
                Collections.sort(tempList, Collections.reverseOrder());
                map.replace(tempType, tempList);
            } else {
                tempList = new LinkedList<>();
                tempList.add(index);
                Collections.sort(tempList, Collections.reverseOrder());
                map.put(tempType, tempList);
            }
        }
    }

    private void setHandType() {
        if (this.map.containsValue(HandType.FOURET)) {
            this.type = HandType.FOURET;
            return;
        }
        if (this.map.containsValue(HandType.TRIPLET) && this.map.containsValue(HandType.PAIR)) {
            this.type = HandType.FULL_HOUSE;
            return;
        }
        if (this.map.containsValue(HandType.TRIPLET)) {
            this.type = HandType.TRIPLET;
            return;
        }
        if (this.map.containsValue(HandType.PAIR)) {
            this.type = HandType.TWO_PAIRS;
            return;
        }
        if (this.map.containsValue(HandType.PAIR)) {
            this.type = HandType.PAIR;
            return;
        }
        this.type = HandType.SINGLE;
    }

    @Override
    public int compareTo(Object o) {
        return compareTo((Hand)o);
    }

    public int compareTo(Hand hand){
        if (this.type.getVal() - hand.type.getVal() != 0) {
            return this.type.getVal() - hand.type.getVal();
        }

        if (this.type == HandType.FOURET) {
            return this.map.get(HandType.FOURET).getFirst() - hand.map.get(HandType.FOURET).getFirst();
        }

        if (this.type == HandType.FULL_HOUSE || this.type == HandType.TRIPLET) {
            return this.map.get(HandType.TRIPLET).getFirst() - hand.map.get(HandType.TRIPLET).getFirst();
        }

        if (this.type == HandType.TWO_PAIRS) {
            if (this.map.get(HandType.PAIR).getFirst() - hand.map.get(HandType.PAIR).getFirst() != 0) {
                return this.map.get(HandType.PAIR).getFirst() - hand.map.get(HandType.PAIR).getFirst();
            }
            if (this.map.get(HandType.PAIR).get(1) - this.map.get(HandType.PAIR).get(1) != 0) {
                return this.map.get(HandType.PAIR).get(1) - this.map.get(HandType.PAIR).get(1);
            }

            if (this.map.get(HandType.SINGLE).size() > 0 && hand.map.get(HandType.SINGLE).size() > 0) {
                return this.map.get(HandType.SINGLE).getFirst() - hand.map.get(HandType.SINGLE).getFirst();
            }

            if (this.map.get(HandType.SINGLE).size() > 0 && hand.map.get(HandType.SINGLE).size() == 0) {
                return 1;
            }

            if (this.map.get(HandType.SINGLE).size() == 0 && hand.map.get(HandType.SINGLE).size() > 0) {
                return -1;
            }

            return 0;
        }

        if (this.type == HandType.PAIR) {
            if (this.map.get(HandType.PAIR).getFirst() - hand.map.get(HandType.PAIR).getFirst() != 0) {
                return this.map.get(HandType.PAIR).getFirst() - hand.map.get(HandType.PAIR).getFirst();
            }
        }

        for (int index = 0; index < Math.min(this.map.get(HandType.SINGLE).size(), hand.map.get(HandType.SINGLE).size()); index++) {
            if (this.map.get(HandType.SINGLE).get(index) != null && hand.map.get(HandType.SINGLE).get(index) != null && this.map.get(HandType.SINGLE).get(index) - hand.map.get(HandType.SINGLE).get(index) != 0) {
                return this.map.get(HandType.SINGLE).get(index) - hand.map.get(HandType.SINGLE).get(index);
            }
            if (this.map.get(HandType.SINGLE).get(index) != null && hand.map.get(HandType.SINGLE).get(index) == null) {
                return 1;
            }
            if (this.map.get(HandType.SINGLE).get(index) == null && hand.map.get(HandType.SINGLE).get(index) != null) {
                return -1;
            }

        }
        return 0;
    }
}
