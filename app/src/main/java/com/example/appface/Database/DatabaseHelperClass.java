package com.example.appface.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "HotelDatabase.db";

    private static final String SQL_CREATE_HOTEL_ENTRY = "CREATE TABLE " +
            HotelTable.HotelTableInner.TABLE_NAME +
            " (" +
            HotelTable.HotelTableInner._ID + " INTEGER PRIMARY KEY, " +
            HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_IMAGE + " INTEGER, " +
            HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_NAME + " TEXT, " +
            HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_PRICE + " TEXT, " +
            HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_ROOMS + " INTEGER, " +
            HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_AVAILABILITY + " INTEGER)";

    private static final String SQL_DROP_HOTEL_ENTRY ="DROP TABLE IF EXISTS " + HotelTable.HotelTableInner.TABLE_NAME;

    public DatabaseHelperClass(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_HOTEL_ENTRY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_HOTEL_ENTRY);
        onCreate(db);
    }
}
