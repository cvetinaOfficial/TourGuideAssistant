package com.tourguideassistant.typeconverter;

import androidx.room.TypeConverter;

import com.tourguideassistant.enumtypes.Category;

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
