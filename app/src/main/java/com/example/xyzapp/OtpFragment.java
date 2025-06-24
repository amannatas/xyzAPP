package com.example.xyzapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OtpFragment extends Fragment {

    String source = "";
    int containerId;

    public OtpFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_otp, container, false);

        // ✅ Bundle data get karo
        if (getArguments() != null) {
            source = getArguments().getString("source", "unknown");
            containerId = getArguments().getInt("container_id", R.id.fragment_engineer);
        }

        Button verifyOtp = view.findViewById(R.id.verify_otp);

        verifyOtp.setOnClickListener(v -> {

            // ✅ Source ke hisaab se action (optional)
            Toast.makeText(getContext(), "Source: " + source, Toast.LENGTH_SHORT).show();

            // ✅ Fragment switch
            switchFragment(new confirm_pages());
        });

        return view;
    }

    private void switchFragment(Fragment fragment) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(null)
                .commit();
    }
}
