package com.tourguideassistant.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class DatabaseHelper<T> extends SQLiteOpenHelper implements IDbHelper<T> {
    public static final String DATABASE_NAME = "TourGuideAssistant.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }
}


