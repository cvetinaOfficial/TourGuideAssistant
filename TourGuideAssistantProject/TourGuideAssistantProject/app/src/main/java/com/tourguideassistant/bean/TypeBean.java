package com.tourguideassistant.bean;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.tourguideassistant.enumtypes.LandmarkType;

import java.io.Serializable;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "type")
public class TypeBean implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public Integer id;

    public LandmarkType type;

    @ForeignKey(entity = CategoryBean.class, parentColumns = "id", childColumns = "categoryId", onDelete = CASCADE)
    public Integer categoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LandmarkType getType() {
        return type;
    }
}
