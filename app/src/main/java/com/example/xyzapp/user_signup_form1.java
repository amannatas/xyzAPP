package com.example.xyzapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class user_signup_form1 extends Fragment {

    TextView login_btn;
    Button user_signup;

    public user_signup_form1() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_signup_form1, container, false);

        login_btn = view.findViewById(R.id.login_btn1);
        user_signup = view.findViewById(R.id.user_signup);

        login_btn.setOnClickListener(v -> {
            switchFragment(new LoginFragment()); // login fragment par switch karega
        });

        user_signup.setOnClickListener(v -> {
            // ✅ Step 1: Bundle banao
            Bundle bundle = new Bundle();
            bundle.putString("source", "engineer_activity"); // yeh tumhara identity hoga
            bundle.putInt("container_id", R.id.user_sign_up); // yeh tumhare activity ka frame ID

            // ✅ Step 2: OTP Fragment me bundle bheja
            OtpFragment otpFragment = new OtpFragment();
            otpFragment.setArguments(bundle);
            switchFragment(otpFragment); // otp fragment par switch karega
        });

        return view;
    }

    private void switchFragment(Fragment fragment) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.user_sign_up, fragment) // host activity me yeh FrameLayout ID hona chahiye
                .addToBackStack(null)
                .commit();
    }
}
