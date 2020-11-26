package com.example.appface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appface.Data.HotelEntity;

import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        ArrayList<HotelEntity> hotels = new ArrayList<>();

        RecyclerView recViewHotels = (RecyclerView)findViewById(R.id.hotelsRecyclerViewId);


        for(int i = 0; i < 10; i++) {
            HotelEntity hotelEntity = new HotelEntity();
            hotelEntity.setHotelName("Hotel "+i);
            hotelEntity.setHotelValue("100"+i);
            hotels.add(hotelEntity);
        }

        System.out.println(hotels);
        HotelsAdapter hotelsAdapter = new HotelsAdapter(hotels);
        recViewHotels.setAdapter(hotelsAdapter);
        recViewHotels.setLayoutManager(new LinearLayoutManager(this));
    }
}