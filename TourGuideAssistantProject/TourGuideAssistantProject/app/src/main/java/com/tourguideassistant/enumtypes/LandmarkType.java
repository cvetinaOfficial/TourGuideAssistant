package com.tourguideassistant.enumtypes;

public enum LandmarkType {
    Peak(0),
    Cave(1),
    Lake(2),
    Monument(3),
    Museum(4),
    Fortress(5);

    public final int landmarkTypeNumber;

    LandmarkType(int landmarkTypeNumber) {
        this.landmarkTypeNumber = landmarkTypeNumber;
    }
}
