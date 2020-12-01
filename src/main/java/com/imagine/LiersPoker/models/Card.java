package com.imagine.LiersPoker.models;

import com.imagine.LiersPoker.models.enums.Suite;

public class Card implements Comparable {
    private Integer rank;
    private Suite suite;

    public Card(Integer rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    @Override
    public String toString() {
        return rank + " " + suite.getLabel();
    }


    @Override
    public int compareTo(Object o) {
        return compareTo((Card)o);
    }

    public int compareTo(Card card) {
        return rank - card.rank;
    }
}
