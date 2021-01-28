package com.example.appface.Database;

import android.provider.BaseColumns;

public final class HotelTable {
    private HotelTable() {}

    public static class HotelTableInner implements BaseColumns
    {
        public static final String TABLE_NAME = "HotelsTable";
        public static final String COLUMN_NAME_HOTEL_IMAGE = "HotelImage";
        public static final String COLUMN_NAME_HOTEL_NAME = "HotelName";
        public static final String COLUMN_NAME_HOTEL_DESC = "HotelDesc";
        public static final String COLUMN_NAME_HOTEL_PRICE = "HotelPrice";
        public static final String COLUMN_NAME_HOTEL_ROOMS = "HotelRooms";
        public static final String COLUMN_NAME_HOTEL_AVAILABILITY = "IsAvailable";
    }
}
