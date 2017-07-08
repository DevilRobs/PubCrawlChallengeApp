package com.example.rober.pubcrawlchallengeapp;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rober on 08.07.2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Tasks.db";
    public static final String TABLE_NAME = "tasks_table";
    public static final String COL_0 = "ID";
    public static final String COL_1 = "GERMAN";
    public static final String COL_2 = "ENGLISH";
    public static final String COL_3 = "POINTS";
    public static final String COL_4 = "MEN";
    public static final String COL_5 = "WOMEN";
    public static final String COL_6 = "INTROVERTED";
    public static final String COL_7 = "EXTROVERTED";
    public static final String COL_8 = "SEXUAL";
    public static final String COL_9 = "SENSELESS";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        //Creates the database
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create the table
        db.execSQL("create table "+ TABLE_NAME +" ("
                + COL_0 +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_1 +" TEXT, " + COL_2 +" TEXT, " + COL_3 + " INTEGER, "+ COL_4 + " BOOLEAN, "+ COL_5 + " BOOLEAN, "+ COL_6 + " BOOLEAN, "+ COL_7 + " BOOLEAN, "+ COL_8 + " BOOLEAN, "+ COL_9 + " BOOLEAN)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
