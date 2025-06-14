package com.example.xyzapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home_page extends AppCompatActivity {
    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enable edge to edge
        androidx.activity.EdgeToEdge.enable(this);

        setContentView(R.layout.activity_home_page);

        bnView = findViewById(R.id.bnView);

        // Set listener for navigation item selected (optional for now)
        bnView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation item clicks here
                int id = item.getItemId();
                if(id==R.id.home){

                } else if (id==R.id.booking) {

                }else if (id==R.id.referal){

                }else if (id==R.id.chat){

                }



                return false;
            }
        });

        // Apply window insets to BottomNavigationView to avoid overlap with system nav bar
        ViewCompat.setOnApplyWindowInsetsListener(bnView, (v, insets) -> {
            int bottomInset = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;

            // Set bottom padding for BottomNavigationView equal to system navigation bar height
            v.setPadding(
                    v.getPaddingLeft(),
                    v.getPaddingTop(),
                    v.getPaddingRight(),
                    bottomInset
            );

            // Return insets consumed so that default behavior doesn't apply padding twice
            return WindowInsetsCompat.CONSUMED;
        });
    }
}
