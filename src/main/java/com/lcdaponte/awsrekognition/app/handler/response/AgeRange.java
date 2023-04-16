package com.lcdaponte.awsrekognition.app.handler.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AgeRange {

    @JsonProperty("low")
    private Integer low;
    @JsonProperty("high")
    private Integer high;

    public AgeRange(Integer low, Integer high) {
        this.low = low;
        this.high = high;
    }

    public Integer getLow() {
        return low;
    }

    public void setLow(Integer low) {
        this.low = low;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }
}
