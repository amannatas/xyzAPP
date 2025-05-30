package com.example.xyzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class user_sign_up_page extends AppCompatActivity {
    TextView login_btn;
    Button user_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_sign_up_page);

        login_btn = findViewById(R.id.login_btn1);
        user_signup = findViewById(R.id.user_signup);

        login_btn.setOnClickListener(new View.OnClickListener(
                ) {
            @Override
            public void onClick(View v) {
                Intent inext1 = new Intent(user_sign_up_page.this, login_page.class);
                startActivity(inext1);

            }
        });
        user_signup.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View v) {
                Intent inext2 = new Intent(user_sign_up_page.this, otp_page.class);
                startActivity(inext2);

            }
        });

    }
}