package com.example.appface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.appface.Data.HotelEntity;
import com.example.appface.Database.DatabaseHelperClass;
import com.example.appface.Database.HotelTable;

import java.util.ArrayList;
import java.util.List;

public class HotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(getBaseContext());
        SQLiteDatabase database = databaseHelperClass.getWritableDatabase();

        ImageView hotelImage = findViewById(R.id.particularHotelImageViewId);
        TextView hotelText = findViewById(R.id.hotelNameId);
        TextView hotelPrice = findViewById(R.id.hotelPriceId);
        TextView roomsCount = findViewById(R.id.roomsCountId);
        Button hotelBookButton = findViewById(R.id.bookHotelButtonId);
        Spinner roomsToBeBooked = findViewById(R.id.roomsToBeBookedId);

        HotelEntity hotelEntity = (HotelEntity)getIntent().getSerializableExtra("hotelEntity");
        int roomsCountVar = hotelEntity.getHotelRoomsCount();

        hotelImage.setImageResource(hotelEntity.getHotelImageOne());
        System.out.println(hotelEntity.getHotelImageOne());
        hotelText.setText(hotelEntity.getHotelName());
        hotelPrice.setText(hotelEntity.getHotelValue());
        roomsCount.setText(Integer.toString(roomsCountVar));

        List<Integer> roomsAvailableForBooking = new ArrayList<Integer>();

        for (int i = 1; i <= roomsCountVar; i++)
        {
            roomsAvailableForBooking.add(i);// the number of rooms to be booked 1 2 3
        }

        ArrayAdapter roomsCountToBeBooked = new ArrayAdapter(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, roomsAvailableForBooking);

        roomsToBeBooked.setAdapter(roomsCountToBeBooked);



        hotelBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int roomsCountSelected = (int)roomsToBeBooked.getSelectedItem();
                int newRoomsCount = roomsCountVar - roomsCountSelected;
                hotelEntity.setHotelRoomsCount(newRoomsCount);
                ContentValues contentValues = new ContentValues();
                contentValues.put(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_ROOMS, hotelEntity.getHotelRoomsCount());
                database.update(HotelTable.HotelTableInner.TABLE_NAME, contentValues, "_ID = ?", new String[]{Integer.toString(hotelEntity.getHotelId())});
                Intent hotelRoomBooked = new Intent(getBaseContext(), HotelRoomBookedActivity.class);
                hotelRoomBooked.putExtra("bookedHotelEntity", hotelEntity);
                hotelRoomBooked.putExtra("bookedRooms", Integer.toString(roomsCountSelected));
                startActivity(hotelRoomBooked);
            }
        });
    }
}
