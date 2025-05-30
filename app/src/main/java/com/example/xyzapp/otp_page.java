package com.example.xyzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class otp_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otp_page);
        Button verify_otp = findViewById(R.id.verify_otp);
        verify_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext = new Intent(otp_page.this, confirm_page.class);
                startActivity(inext);

            }
            });
    }
}