package com.javaclimb.livewhere.domain;

import java.io.Serializable;

public class LandMark implements Serializable {
    private String landmark;
    private Integer landmarkId;
    private String city;

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public Integer getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(Integer landmarkId) {
        this.landmarkId = landmarkId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
