package com.tourguideassistant.bean;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "user")
public class UserBean implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public Integer id;
    public String name;
    public String username;
    public String password;
    public String startingPoint;

    public UserBean() { }

    public UserBean(Integer id, String name, String username, String password, String startingPoint) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.startingPoint = startingPoint;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }
}
