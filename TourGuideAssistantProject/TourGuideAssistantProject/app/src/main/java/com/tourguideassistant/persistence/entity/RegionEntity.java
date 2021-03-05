package com.tourguideassistant.persistence.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.tourguideassistant.persistence.enumtypes.Region;

@Entity(tableName = "region")
public class RegionEntity {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private Region regionType;

    public RegionEntity() {};

    public RegionEntity (@NonNull Region regionType){
        this.regionType = regionType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Region getRegionType() {
        return regionType;
    }

    public void setRegionType(Region regionType) {
        this.regionType = regionType;
    }
}
