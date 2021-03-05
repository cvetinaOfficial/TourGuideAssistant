package com.tourguideassistant.persistence.enumtypes;

public enum Category {
    Natural(0),
    Historical(1),
    Cultural(2),
    Anthropogenic(3);

    public final int categoryNumber;

    Category(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }
}
