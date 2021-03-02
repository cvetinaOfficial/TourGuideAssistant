package com.tourguideassistant.dbhelper;

import android.database.Cursor;

import java.util.List;

public interface IDbHelper<T> {
    public T getById(String id);

    public List<T> getAll();

    public String add(T cursor);

    //public void addRange(List<ClassT> cursorList);

    public int update(T cursor);

    public int deleteById(String id);

}
