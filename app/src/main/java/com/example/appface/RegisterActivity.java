package com.example.appface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText emailTextField = this.findViewById(R.id.emailRegisterText);
        EditText passwordTextField = this.findViewById(R.id.passwordRegisterText);
        EditText passwordConfirmTextField = this.findViewById(R.id.passwordConfirmRegisterText);
        Button registerButton = this.findViewById(R.id.registerButtonSubmit);

        Pattern passwordPattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])[a-zA-Z0-9]{6,20}$/gm");

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Matcher matcher = passwordPattern.matcher(passwordTextField.getText());
                System.out.println(matcher.matches());
                if(!matcher.matches())
                {
                    Toast passwordError = new Toast(getBaseContext());
                    passwordError.setText("Password must contain atleast one uppercase, lowercase char and a digit.");
                    passwordError.show();
                }
            }
        });

    }
}