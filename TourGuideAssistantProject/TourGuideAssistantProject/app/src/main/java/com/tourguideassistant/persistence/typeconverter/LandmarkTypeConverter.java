package com.tourguideassistant.persistence.typeconverter;

import androidx.room.TypeConverter;

import com.tourguideassistant.persistence.enumtypes.LandmarkType;

public class LandmarkTypeConverter {
    @TypeConverter
    public LandmarkType fromInteger(int landmarkTypeNumber) {
        return  LandmarkType.values()[landmarkTypeNumber];
    }

    @TypeConverter
    public int landmarkTypeToInt(LandmarkType landmarkType) {
        return landmarkType.landmarkTypeNumber;
    }
}
