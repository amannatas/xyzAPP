package com.example.xyzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class confirm_pages extends Fragment {

    public confirm_pages() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirm_pages, container, false);

        Button user_signup = view.findViewById(R.id.user_signup);
        user_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // NOTE: getActivity() is used instead of context
                Intent inext = new Intent(getActivity(), home_page.class);
                startActivity(inext);
            }
        });

        return view;
    }
}
