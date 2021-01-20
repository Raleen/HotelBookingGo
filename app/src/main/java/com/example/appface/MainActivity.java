package com.example.appface;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appface.Database.DatabaseHelperClass;
import com.example.appface.Database.HotelTable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(getBaseContext());

        Button loginButton;
        Button registerButton;

        loginButton = this.findViewById(R.id.loginButton);
        registerButton = this.findViewById(R.id.registerButton);

        //SQLiteDatabase database = databaseHelperClass.getWritableDatabase();

        int[] hotelImages = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};

        String[] hotelNames = {"Hotel Luneta", "Hotel Manila Manor", "Hotel The Heritage", "Hotel H2O"};

        String[] hotelPrices = {"100 Php", "200 Php", "350 Php", "500 Php"};

        int[] availableRoomsCount = {5, 2, 3, 1};

        //getBaseContext().deleteDatabase("HotelDatabase.db");
        /*
        database.beginTransaction();
        for(int i = 0; i < hotelNames.length; i++)
        {
            ContentValues hotelEntities = new ContentValues();
            hotelEntities.put(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_IMAGE, hotelImages[i]);
            hotelEntities.put(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_NAME, hotelNames[i]);
            hotelEntities.put(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_PRICE, hotelPrices[i]);
            hotelEntities.put(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_ROOMS, availableRoomsCount[i]);
            hotelEntities.put(HotelTable.HotelTableInner.COLUMN_NAME_HOTEL_AVAILABILITY, 1);
            database.insert(HotelTable.HotelTableInner.TABLE_NAME, null, hotelEntities);
        }
        database.setTransactionSuccessful();
        database.endTransaction();
        */
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(getBaseContext(), LoginActivity.class);
                loginIntent.putExtra("text", "Hello world");
                startActivity(loginIntent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

    }

}