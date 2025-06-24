package com.example.xyzapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class LoginFragment extends Fragment {


    Button user_login;
    public LoginFragment() {
        // Required empty public constructor
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);


        user_login = view.findViewById(R.id.user_login);

        user_login.setOnClickListener(v -> {
            // ✅ Step 1: Bundle banao
            Bundle bundle = new Bundle();
            bundle.putString("source", "login_activity"); // yeh tumhara identity hoga
            bundle.putInt("container_id", R.id.Login_activity); // yeh tumhare activity ka frame ID

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
                .replace(R.id.Login_activity, fragment) // host activity me yeh FrameLayout ID hona chahiye
                .addToBackStack(null)
                .commit();
    }
}