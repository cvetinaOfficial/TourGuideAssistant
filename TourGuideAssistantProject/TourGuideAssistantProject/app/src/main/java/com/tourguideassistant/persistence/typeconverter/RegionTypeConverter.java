package com.tourguideassistant.persistence.typeconverter;

import androidx.room.TypeConverter;

import com.tourguideassistant.persistence.enumtypes.Region;

public class RegionTypeConverter {
    @TypeConverter
    public Region fromInteger(int regionNumber) {
        return  Region.values()[regionNumber];
    }

    @TypeConverter
    public int regionToInt(Region region) {
        return region.regionNumber;
    }
}
