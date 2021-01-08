package com.imagine.LiersPoker.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.imagine.LiersPoker.models.enums.Suite;

public class Card implements Comparable {
    @JsonProperty("rank")
    private Integer rank;
    @JsonProperty("suite")
    private Suite suite;
    @JsonProperty("img_path")
    private String img_path;

    public Card(Integer rank, Suite suite, String img_path) {
        this.rank = rank;
        this.suite = suite;
        this.img_path = img_path;
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

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
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
