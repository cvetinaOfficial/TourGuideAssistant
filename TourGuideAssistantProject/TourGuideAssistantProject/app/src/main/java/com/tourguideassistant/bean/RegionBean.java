package com.tourguideassistant.bean;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.tourguideassistant.enumtypes.Region;

@Entity(tableName = "region")
public class RegionBean {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    public Region regionType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Region getRegionType() {
        return regionType;
    }
}
