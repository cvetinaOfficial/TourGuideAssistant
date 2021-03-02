package com.tourguideassistant.typeconverter;

import androidx.room.TypeConverter;

import com.tourguideassistant.enumtypes.LandmarkType;

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
