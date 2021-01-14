package com.example.appface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.appface.Data.HotelEntity;

import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        int[] hotelImages = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};

        String[] hotelNames = {"Hotel Luneta", "Hotel Manila Manor", "Hotel The Heritage", "Hotel H2O"};

        String[] hotelPrices = {"100 Php", "200 Php", "350 Php", "500 Php"};

        int[] availableRoomsCount = {5, 2, 3, 1};

        ArrayList<HotelEntity> hotels = new ArrayList<>();

        RecyclerView recViewHotels = (RecyclerView)findViewById(R.id.hotelsRecyclerViewId);
        for(int i=0; i < hotelNames.length; i++) {
            HotelEntity hotel = new HotelEntity();
            hotel.setHotelImage(hotelImages[i]);
            hotel.setHotelName(hotelNames[i]);
            hotel.setHotelValue(hotelPrices[i]);
            hotel.setHotelRoomsCount(availableRoomsCount[i]);
            hotel.setAvailable(true);
            hotels.add(hotel);
        }
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
