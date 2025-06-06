package com.example.xyzapp;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class engineer_signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_engineer_signup);

        ScrollView rootLayout = findViewById(R.id.main); // ScrollView ka ID
        View bottomSpace = findViewById(R.id.bottom_space); // View jise resize karna hai

        rootLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                rootLayout.getWindowVisibleDisplayFrame(r);

                int screenHeight = rootLayout.getRootView().getHeight();
                int keypadHeight = screenHeight - r.bottom;

                if (keypadHeight > screenHeight * 0.15) {
                    // ✅ Keyboard is open
                    bottomSpace.getLayoutParams().height = keypadHeight;
                    bottomSpace.requestLayout();
                } else {
                    // ✅ Keyboard is closed
                    bottomSpace.getLayoutParams().height = 50; // default bottom padding
                    bottomSpace.requestLayout();
                }
            }
        });
    }
}
