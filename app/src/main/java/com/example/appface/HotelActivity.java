package com.example.appface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appface.Data.HotelEntity;

public class HotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        ImageView hotelImage = findViewById(R.id.particularHotelImageViewId);
        TextView hotelText = findViewById(R.id.hotelNameId);
        TextView hotelPrice = findViewById(R.id.hotelPriceId);
        Button hotelBookButton = findViewById(R.id.bookHotelButtonId);

        HotelEntity hotelEntity = (HotelEntity)getIntent().getSerializableExtra("hotelEntity");

        hotelImage.setImageResource(hotelEntity.getHotelImageOne());
        hotelText.setText(hotelEntity.getHotelName());
        hotelPrice.setText(hotelEntity.getHotelValue());
        hotelBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicked");
            }
        });
    }
}
