package com.example.appface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView receivedText = this.findViewById(R.id.receivedText);
        Button loginButton = this.findViewById(R.id.loginButtonId);

        String recText = getIntent().getStringExtra("text");

        receivedText.setText(recText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHotels = new Intent(getBaseContext(), HotelsActivity.class);
                startActivity(intentHotels);
            }
        });
    }
}