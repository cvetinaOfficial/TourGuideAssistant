package com.tourguideassistant.persistence.typeconverter;

import androidx.room.TypeConverter;

import com.tourguideassistant.persistence.enumtypes.Category;

public class CategoryTypeConverter {
    @TypeConverter
    public Category fromInteger(int categoryNumber) {
        return  Category.values()[categoryNumber];
    }

    @TypeConverter
    public int categoryToInt(Category category) {
        return category.categoryNumber;
    }
}
