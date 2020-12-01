package com.imagine.LiersPoker.models.enums;

public enum HandType {
    SINGLE(0),
    PAIR(1),
    TWO_PAIRS(2),
    TRIPLET(3),
    FULL_HOUSE(4),
    FOURET(5);

    private int val;
    HandType(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
