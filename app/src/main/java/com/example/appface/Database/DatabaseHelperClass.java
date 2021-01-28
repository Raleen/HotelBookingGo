package com.example.appface.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import com.example.appface.R;

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
            HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_DESC + " TEXT, " +
            HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_AVAILABILITY + " INTEGER)";

    private static final String SQL_DROP_HOTEL_ENTRY ="DROP TABLE IF EXISTS " + HotelTable.HotelTableInner.TABLE_NAME;

    public DatabaseHelperClass(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        int[] hotelImages = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};

        String[] hotelNames = {"Hotel Luneta", "Hotel Manila Manor", "Hotel The Heritage", "Hotel H2O"};

        String[] hotelPrices = {"100 Php", "200 Php", "350 Php", "500 Php"};

        String[] hotelDesc = {"This hotel is located on ten minutes from the center of the city.", "Big rooms, incredible comfort. Good service.", "Nice view looking at the center of the city. Really luxorious hotel.", "Comfortable rooms, big pool and really good service."};

        int[] availableRoomsCount = {5, 2, 3, 1};
        db.execSQL(SQL_CREATE_HOTEL_ENTRY);
        db.beginTransaction();
        for(int i = 0; i < hotelNames.length; i++)
        {
            ContentValues hotelEntities = new ContentValues();
            hotelEntities.put(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_IMAGE, hotelImages[i]);
            hotelEntities.put(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_NAME, hotelNames[i]);
            hotelEntities.put(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_PRICE, hotelPrices[i]);
            hotelEntities.put(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_ROOMS, availableRoomsCount[i]);
            hotelEntities.put(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_DESC, hotelDesc[i]);
            hotelEntities.put(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_AVAILABILITY, 1);
            db.insert(HotelTable.HotelTableInner.TABLE_NAME, null, hotelEntities);
            System.out.println(hotelDesc[i]);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_HOTEL_ENTRY);
        onCreate(db);
    }
}
