package com.example.appface;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import com.example.appface.Data.HotelEntity;
import com.example.appface.Database.DatabaseHelperClass;
import com.example.appface.Database.HotelTable;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class HotelActivity extends AppCompatActivity{

    Button buttonAccomodationFreeingDate;

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
        TextView hotelDesc = findViewById(R.id.hotelDescriptionId);
        buttonAccomodationFreeingDate = findViewById(R.id.dateOfAccomodationFreeingButtonId);

        MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("Select date for accomodation/leaving.");
        MaterialDatePicker materialDateRangePicker = builder.build();
        buttonAccomodationFreeingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDateRangePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

        materialDateRangePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Pair<Long, Long>>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onPositiveButtonClick(Pair<Long, Long> selection) {
                buttonAccomodationFreeingDate.setText("Acc:"+Instant.ofEpochMilli(selection.first).atZone(ZoneId.systemDefault()).toLocalDate()+"\nFre:"+Instant.ofEpochMilli(selection.second).atZone(ZoneId.systemDefault()).toLocalDate());
            }
        });

        //materialDateRangePicker.addOnNegativeButtonClickListener();
        HotelEntity hotelEntity = (HotelEntity)getIntent().getSerializableExtra("hotelEntity");
        int roomsCountVar = hotelEntity.getHotelRoomsCount();

        hotelImage.setImageResource(hotelEntity.getHotelImageOne());
        System.out.println(hotelEntity.getHotelImageOne());
        hotelText.setText(hotelEntity.getHotelName());
        hotelPrice.setText(hotelEntity.getHotelValue());
        roomsCount.setText(Integer.toString(roomsCountVar));
        hotelDesc.setText(hotelEntity.getHotelDescription());

        List<Integer> roomsAvailableForBooking = new ArrayList<Integer>();

        for (int i = 1; i <= roomsCountVar; i++)
        {
            roomsAvailableForBooking.add(i);// the number of rooms to be booked 1 2 3
        }

        ArrayAdapter roomsCountToBeBooked = new ArrayAdapter(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, roomsAvailableForBooking);

        roomsToBeBooked.setAdapter(roomsCountToBeBooked);



        if(hotelEntity.getIsAvailable() == 0)
        {
            hotelBookButton.setEnabled(false);
            hotelBookButton.setText("Sorry, we are out of rooms!");
        }


        hotelBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int roomsCountSelected = (int)roomsToBeBooked.getSelectedItem();
                int newRoomsCount = roomsCountVar - roomsCountSelected;
                hotelEntity.setHotelRoomsCount(newRoomsCount);
                ContentValues contentValues = new ContentValues();
                contentValues.put(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_ROOMS, hotelEntity.getHotelRoomsCount());
                if(newRoomsCount == 0)
                {
                    contentValues.put(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_AVAILABILITY, 0);
                    database.update(HotelTable.HotelTableInner.TABLE_NAME, contentValues, "_ID = ?", new String[]{Integer.toString(hotelEntity.getHotelId())});
                }
                else
                {
                    database.update(HotelTable.HotelTableInner.TABLE_NAME, contentValues, "_ID = ?", new String[]{Integer.toString(hotelEntity.getHotelId())});
                }
                Intent hotelRoomBooked = new Intent(getBaseContext(), HotelRoomBookedActivity.class);
                hotelRoomBooked.putExtra("bookedHotelEntity", hotelEntity);
                hotelRoomBooked.putExtra("bookedRooms", Integer.toString(roomsCountSelected));
                startActivity(hotelRoomBooked);
            }
        });
    }
}
