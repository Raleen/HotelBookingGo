package com.example.appface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.appface.Data.HotelEntity;
import com.example.appface.Database.DatabaseHelperClass;
import com.example.appface.Database.HotelTable;

import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        ArrayList<HotelEntity> hotels = new ArrayList<>();
        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(getBaseContext());

        SQLiteDatabase database = databaseHelperClass.getReadableDatabase();

        String sqlQuery = "SELECT * FROM "+ HotelTable.HotelTableInner.TABLE_NAME;

        Cursor selectAll = database.rawQuery(sqlQuery, null);

        while (selectAll.moveToNext())
        {
            HotelEntity hotelEntity = new HotelEntity();
            hotelEntity.setHotelId(selectAll.getInt(selectAll.getColumnIndex(HotelTable.HotelTableInner._ID)));
            hotelEntity.setHotelImage(selectAll.getInt(selectAll.getColumnIndex(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_IMAGE)));
            hotelEntity.setHotelName(selectAll.getString(selectAll.getColumnIndex(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_NAME)));
            hotelEntity.setHotelValue(selectAll.getString(selectAll.getColumnIndex(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_PRICE)));
            hotelEntity.setHotelRoomsCount(selectAll.getInt(selectAll.getColumnIndex(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_ROOMS)));
            hotelEntity.setIsAvailable(selectAll.getInt(selectAll.getColumnIndex(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_AVAILABILITY)));
            hotels.add(hotelEntity);
        }





        RecyclerView recViewHotels = (RecyclerView)findViewById(R.id.hotelsRecyclerViewId);

        HotelsAdapter hotelsAdapter = new HotelsAdapter(hotels);
        recViewHotels.setAdapter(hotelsAdapter);
        recViewHotels.setLayoutManager(new LinearLayoutManager(this));
        hotelsAdapter.OnItemClickListener(new HotelsAdapter.OnItemClickListenerInterface() {
            @Override
            public void OnItemClick(int position) {
                HotelEntity hotelReceived = hotels.get(position);
                Intent hotelIntent = new Intent(getBaseContext(), HotelActivity.class);
                hotelIntent.putExtra("hotelEntity", hotelReceived);
                startActivity(hotelIntent);
            }
        });
    }
}
