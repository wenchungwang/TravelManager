package com.travel_world.travelmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Student on 2018/1/23.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "traveldata.sqlite";
    final static int VERSION = 1;

    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE \"traveldata\" ( `_id` INTEGER, `startTime` TEXT, `name` TEXT, `startLocation` TEXT, `destinationTime` TEXT, `destinationLocation` TEXT, `Weblocation` TEXT, `note` TEXT , PRIMARY KEY(`_id`) )");
//        sqLiteDatabase.execSQL("CREATE TABLE \"traveldata\" ( `_id` INTEGER, `name` TEXT, `score` INTEGER, PRIMARY KEY(`_id`) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}