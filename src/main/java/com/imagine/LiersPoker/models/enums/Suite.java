package com.imagine.LiersPoker.models.enums;

public enum Suite {
    CLUB("C"),
    DIAMOND("D"),
    HEART("H"),
    SPADE("S");

    private String label;

    Suite(String label) {
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }
}
