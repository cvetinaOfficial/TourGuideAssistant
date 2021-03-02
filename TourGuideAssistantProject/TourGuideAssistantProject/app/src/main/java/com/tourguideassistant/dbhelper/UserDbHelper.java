package com.tourguideassistant.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tourguideassistant.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class UserDbHelper extends DatabaseHelper<UserBean> implements IDbHelper<UserBean> {
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
    public UserBean getById(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * " + " FROM " + TABLE_NAME + " WHERE " + COL_ID + " = '" + id + "'";

        if(id != null){
            Cursor cursor = db.rawQuery(query,null);
            cursor.close();
            return (UserBean)cursor;
        }
        return null;
    }

    @Override
    public List<UserBean> getAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * " + " FROM " + TABLE_NAME;
        ArrayList<UserBean> userBeanArrayList = new ArrayList<>();
        Cursor data = db.rawQuery(query,null);

        if (data.getCount() == 0) {
            return userBeanArrayList;
        }

        //обект
        while (data.moveToNext()) {
            UserBean userBean = new UserBean();
            userBean.id = data.getInt(1);
            userBean.name = data.getString(2);
            userBean.username = data.getString(3);
            userBean.password = data.getString(4);
            userBean.startingPoint = data.getString(5);

            userBeanArrayList.add(userBean);
        }
        data.close();
        return userBeanArrayList;
    }

    @Override
    public String add(UserBean userBean) {
        SQLiteDatabase db = this.getWritableDatabase(); // its going to create the database and the table
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,userBean.getName());
        contentValues.put(COL_USERNAME,userBean.getUsername());
        contentValues.put(COL_PASSWORD,userBean.getPassword());
        contentValues.put(COL_STARTING_POINT, userBean.getStartingPoint());
        long result = getWritableDatabase().insert(TABLE_NAME,null,contentValues) ;

        return String.valueOf(result);
    }

    @Override
    public int update(UserBean userBean) {
        SQLiteDatabase db = this.getWritableDatabase(); // its going to create the database and the table
        UserBean userBeanEntity = this.getById(String.valueOf(userBean.id));

        ContentValues contentValues = new ContentValues();
        String getUserBeanWhereClause = "_id = ?";

        if(userBeanEntity != null){
            contentValues.put(COL_NAME,userBean.getName());
            contentValues.put(COL_USERNAME,userBean.getUsername());
            contentValues.put(COL_PASSWORD,userBean.getPassword());
            contentValues.put(COL_STARTING_POINT, userBean.getStartingPoint());

            int affectedRows = getWritableDatabase().update(TABLE_NAME, contentValues, getUserBeanWhereClause, new String[]{String.valueOf(userBean.id)});

            return affectedRows;
        }
        else {
            return 0;
        }
    }

    @Override
    public int deleteById(String id) {
        SQLiteDatabase db = this.getWritableDatabase(); // its going to create the database and the table
        UserBean userBeanEntity = this.getById(id);

        ContentValues contentValues = new ContentValues();
        String getUserBeanWhereClause = "_id = ?";

        if(userBeanEntity != null){
            int affectedRows = getWritableDatabase().delete(TABLE_NAME, getUserBeanWhereClause, new String[]{id});

            return affectedRows;
        }
        else {
            return 0;
        }
    }
}
