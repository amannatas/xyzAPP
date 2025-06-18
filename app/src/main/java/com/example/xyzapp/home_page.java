package com.example.xyzapp;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class home_page extends AppCompatActivity {

    BottomNavigationView bnView;

    Map<String, Fragment> fragmentMap = new HashMap<>();
    Stack<String> fragmentStack = new Stack<>();
    String activeTag = "HOME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        androidx.activity.EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), true);

        bnView = findViewById(R.id.bnView);

        addFragment("HOME", new homeFragment());
        addFragment("BOOKING", new BookingFragment());
        addFragment("REFER", new ReferFragment());
        addFragment("CHAT", new ChatFragment());
        addFragment("PROFILE", new profileFragment());

        showFragment("HOME");

        bnView.setOnItemSelectedListener(item -> {
            String tag = getTagFromId(item.getItemId());
            if (!tag.equals(activeTag)) {
                showFragment(tag);
            }
            return true;
        });

        // Keyboard visibility handling
        View rootView = findViewById(android.R.id.content);
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(() -> {
            Rect r = new Rect();
            rootView.getWindowVisibleDisplayFrame(r);
            int screenHeight = rootView.getRootView().getHeight();
            int keypadHeight = screenHeight - r.bottom;

            if (keypadHeight > screenHeight * 0.15) {
                bnView.setVisibility(View.GONE);
            } else {
                bnView.setVisibility(View.VISIBLE);
            }
        });

        bnView.setSelectedItemId(R.id.home);
    }
    private void addFragment(String tag, Fragment fragment) {
        fragmentMap.put(tag, fragment);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment, tag)
                .hide(fragment)
                .commit();
    }
    private void showFragment(String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment showFrag = fragmentMap.get(tag);
        Fragment hideFrag = fragmentMap.get(activeTag);

        if (hideFrag != null) transaction.hide(hideFrag);
        if (showFrag != null) transaction.show(showFrag);

        transaction.commit();

        // Stack Logic (Don't add if already exists)
        fragmentStack.remove(tag);  // Remove if already exists (for reorder)
        fragmentStack.push(tag);    // Push on top

        activeTag = tag;
    }
    private String getTagFromId(int itemId) {
        if (itemId == R.id.home) return "HOME";
        else if (itemId == R.id.booking) return "BOOKING";
        else if (itemId == R.id.referal) return "REFER";
        else if (itemId == R.id.chat) return "CHAT";
        else if (itemId == R.id.account) return "PROFILE";
        else return "HOME";
    }
    @Override
    public void onBackPressed() {
        // Agar current fragment HOME hai, to app band karo
        if (activeTag.equals("HOME")) {
            super.onBackPressed(); // Exit app
            return;
        }
        // Nahi to stack se previous fragment dikhao
        if (fragmentStack.size() > 1) {
            fragmentStack.pop(); // Remove current
            String previousTag = fragmentStack.peek(); // Peek previous
            showFragment(previousTag);
            updateNavBarSelection(previousTag);
        } else {
            super.onBackPressed(); // Default behavior
        }
    }
    private void updateNavBarSelection(String tag) {
        if (tag.equals("HOME")) bnView.setSelectedItemId(R.id.home);
        else if (tag.equals("BOOKING")) bnView.setSelectedItemId(R.id.booking);
        else if (tag.equals("REFER")) bnView.setSelectedItemId(R.id.referal);
        else if (tag.equals("CHAT")) bnView.setSelectedItemId(R.id.chat);
        else if (tag.equals("PROFILE")) bnView.setSelectedItemId(R.id.account);
    }
}
