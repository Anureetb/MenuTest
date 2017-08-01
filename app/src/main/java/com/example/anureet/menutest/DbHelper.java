package com.example.anureet.menutest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anureet on 07-07-2017.
 */

class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="collective.db";
    public static final String TABLE_NAME ="collective_bill";
    public static final String COL_1 ="Who_Paid";
    public static final String  COL_2="For_whom";
    public static final String COL_3 ="How_much ";
    public static final String COL_4 ="Purpose";
    public static final String COL_5 ="When";
   // public static final String COL_6 ="CStatus";






    public DbHelper(Context context) {
        super(context ,DATABASE_NAME ,null , 1);
//        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table" + TABLE_NAME + "(Who_Paid TEXT , For_whom TEXT , How_much INTEGER , Purpose TEXT ,When INTEGER )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST" + TABLE_NAME);
        onCreate(db);
    }
    public Boolean insertData(String who_paid ,String for_whom , String How_much , String purpose , String when ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1 , who_paid);
        contentValues.put(COL_2 , for_whom);
        contentValues.put(COL_3 , How_much);
        contentValues.put(COL_4 , purpose);
        contentValues.put(COL_5 , when);
       // contentValues.put(COL_6 , CStatus);
       long result = db.insert(TABLE_NAME , null , contentValues);
        if( result == -1) {
            return false;
        }
            else{
                return true;
            }



    }
}
