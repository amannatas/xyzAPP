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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button user_signup = findViewById(R.id.user_signup);
        Button engineer_signup = findViewById(R.id.engineer_signup);
        TextView login_btn = findViewById(R.id.login_btn);

        user_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext1 = new Intent(MainActivity.this, user_sign_up_page.class);

                startActivity(inext1);
            }
        });
        engineer_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext2 = new Intent(MainActivity.this, engineer_signup.class);

                startActivity(inext2);
            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent inext3 = new Intent(MainActivity.this, login_page.class);

                  startActivity(inext3);
            }

        });
    }
}