/*
package com.tourguideassistant.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tourguideassistant.domain.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDbHelper extends DatabaseHelper<UserEntity> implements IDbHelper<UserEntity> {
    public static final String TABLE_NAME = "User";
    public static final String COL_ID = "Id";
    public static final String COL_NAME = "Name";
    public static final String COL_USERNAME = "Username";
    public static final String COL_PASSWORD = "Password";
    public static final String COL_STARTING_POINT = "StartingPoint";

    public UserDbHelper(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT ," +
                "Username TEXT ," +
                "Password TEXT ," +
                "StartingPoint TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public UserEntity getById(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * " + " FROM " + TABLE_NAME + " WHERE " + COL_ID + " = '" + id + "'";

        if(id != null){
            Cursor cursor = db.rawQuery(query,null);
            cursor.close();
            return (UserEntity)cursor;
        }
        return null;
    }

    @Override
    public List<UserEntity> getAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * " + " FROM " + TABLE_NAME;
        ArrayList<UserEntity> userEntityArrayList = new ArrayList<>();
        Cursor data = db.rawQuery(query,null);

        if (data.getCount() == 0) {
            return userEntityArrayList;
        }

        //обект
        while (data.moveToNext()) {
            UserEntity userEntity = new UserEntity();
            userEntity.id = data.getInt(1);
            userEntity.name = data.getString(2);
            userEntity.username = data.getString(3);
            userEntity.password = data.getString(4);
            userEntity.startingPoint = data.getString(5);

            userEntityArrayList.add(userEntity);
        }
        data.close();
        return userEntityArrayList;
    }

    @Override
    public String add(UserEntity userEntity) {
        SQLiteDatabase db = this.getWritableDatabase(); // its going to create the database and the table
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, userEntity.getName());
        contentValues.put(COL_USERNAME, userEntity.getUsername());
        contentValues.put(COL_PASSWORD, userEntity.getPassword());
        contentValues.put(COL_STARTING_POINT, userEntity.getStartingPoint());
        long result = getWritableDatabase().insert(TABLE_NAME,null,contentValues) ;

        return String.valueOf(result);
    }

    @Override
    public int update(UserEntity userEntity) {
        SQLiteDatabase db = this.getWritableDatabase(); // its going to create the database and the table
        UserEntity userEntityEntity = this.getById(String.valueOf(userEntity.id));

        ContentValues contentValues = new ContentValues();
        String getUserBeanWhereClause = "_id = ?";

        if(userEntityEntity != null){
            contentValues.put(COL_NAME, userEntity.getName());
            contentValues.put(COL_USERNAME, userEntity.getUsername());
            contentValues.put(COL_PASSWORD, userEntity.getPassword());
            contentValues.put(COL_STARTING_POINT, userEntity.getStartingPoint());

            int affectedRows = getWritableDatabase().update(TABLE_NAME, contentValues, getUserBeanWhereClause, new String[]{String.valueOf(userEntity.id)});

            return affectedRows;
        }
        else {
            return 0;
        }
    }

    @Override
    public int deleteById(String id) {
        SQLiteDatabase db = this.getWritableDatabase(); // its going to create the database and the table
        UserEntity userEntityEntity = this.getById(id);

        ContentValues contentValues = new ContentValues();
        String getUserBeanWhereClause = "_id = ?";

        if(userEntityEntity != null){
            int affectedRows = getWritableDatabase().delete(TABLE_NAME, getUserBeanWhereClause, new String[]{id});

            return affectedRows;
        }
        else {
            return 0;
        }
    }
}
*/
