package com.example.appface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView receivedText = this.findViewById(R.id.receivedText);

        String recText = getIntent().getStringExtra("text");

        receivedText.setText(recText);
    }
}