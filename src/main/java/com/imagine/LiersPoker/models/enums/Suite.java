package com.imagine.LiersPoker.models.enums;

public enum Suite {
    C("CLUB"),
    D("DIAMOND"),
    H("HEART"),
    S("SPADE");

    private String label;

    Suite(String label) {
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }
}
