package com.lcdaponte.awsrekognition.app.handler.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FaceDetailsResponse {

    @JsonProperty("age_range")
    private AgeRange ageRange;

    @JsonProperty("smile")
    private Boolean smile;

    @JsonProperty("sunglasses")
    private Boolean sunglasses;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("beard")
    private Boolean beard;

    @JsonProperty("brightness")
    private Double brightness;

    public FaceDetailsResponse() {
    }

    public Boolean getSmile() {
        return smile;
    }

    public void setSmile(Boolean smile) {
        this.smile = smile;
    }

    public Boolean getSunglasses() {
        return sunglasses;
    }

    public void setSunglasses(Boolean sunglasses) {
        this.sunglasses = sunglasses;
    }

    public AgeRange getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(AgeRange ageRange) {
        this.ageRange = ageRange;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getBeard() {
        return beard;
    }

    public void setBeard(Boolean beard) {
        this.beard = beard;
    }

    public Double getBrightness() {
        return brightness;
    }

    public void setBrightness(Double brightness) {
        this.brightness = brightness;
    }
}
