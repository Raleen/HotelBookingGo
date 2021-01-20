package com.example.appface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appface.Data.HotelEntity;

public class HotelRoomBookedActivity extends AppCompatActivity {

    ImageView hotelBookedImage;
    TextView hotelNameBooked;
    TextView hotelPriceBooked;
    TextView hotelRoomsCountBooked;
    Button hotelBookedHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_room_booked);

        hotelBookedImage = findViewById(R.id.hotelBookedImageViewId);
        hotelNameBooked = findViewById(R.id.hotelBookedNameId);
        hotelPriceBooked = findViewById(R.id.hotelBookedPriceId);
        hotelRoomsCountBooked = findViewById(R.id.hotelRoomsBookedCountId);
        hotelBookedHomeButton = findViewById(R.id.hotelBookedHomeButtonId);


        HotelEntity receivedBookedHotel = (HotelEntity)getIntent().getSerializableExtra("bookedHotelEntity");
        String numberOfRoomsBooked = getIntent().getStringExtra("bookedRooms");
        System.out.println("here");
        System.out.println(numberOfRoomsBooked);
        hotelBookedImage.setImageResource(receivedBookedHotel.getHotelImageOne());
        hotelNameBooked.setText(receivedBookedHotel.getHotelName());
        hotelPriceBooked.setText(receivedBookedHotel.getHotelValue());
        hotelRoomsCountBooked.setText(numberOfRoomsBooked);
        hotelBookedHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHome = new Intent(getBaseContext(), MainActivity.class);
                startActivity(moveToHome);
            }
        });

    }
}