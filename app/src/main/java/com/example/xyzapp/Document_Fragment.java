package com.example.xyzapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Document_Fragment extends Fragment {


    Button user_signup;
    public Document_Fragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_document, container, false);


        user_signup = view.findViewById(R.id.user_signup);

        user_signup.setOnClickListener(v -> {
            // ✅ Step 1: Bundle banao
            Bundle bundle = new Bundle();
            bundle.putString("source", "engineer_activity"); // yeh tumhara identity hoga
            bundle.putInt("container_id", R.id.fragment_engineer); // yeh tumhare activity ka frame ID

            // ✅ Step 2: OTP Fragment me bundle bheja
            OtpFragment otpFragment = new OtpFragment();
            otpFragment.setArguments(bundle);

            switchFragment(otpFragment ); // otp fragment par switch karega
        });

        return view;
    }
    private void switchFragment(Fragment fragment) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_engineer, fragment) // host activity me yeh FrameLayout ID hona chahiye
                .addToBackStack(null)
                .commit();
    }
}