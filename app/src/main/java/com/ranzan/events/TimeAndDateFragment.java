package com.ranzan.events;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TimeAndDateFragment extends Fragment implements CommunicationListener {
    private EditText startDate;
    private EditText endDate;
    private EditText startTime;
    private String title;
    private String description;
    private EditText endTime;
    private Button btnNext;
    private CommunicationListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("title");
        description = getArguments().getString("description");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_and_date, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    private void initViews(View view) {
        startDate = view.findViewById(R.id.startDate);
        endDate = view.findViewById(R.id.endDate);
        startTime = view.findViewById(R.id.startTime);
        endTime = view.findViewById(R.id.endTime);
        btnNext = view.findViewById(R.id.btnNext2);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("title", title);
                bundle.putString("description", description);
                bundle.putString("startDate", startDate.getText().toString());
                bundle.putString("endDate", endDate.getText().toString());
                bundle.putString("startTime", startTime.getText().toString());
                bundle.putString("endTime", endTime.getText().toString());
                PriceDetailsFragment fragment = new PriceDetailsFragment();
                if (listener != null) {
                    listener.launchFragment(bundle, fragment);
                }

            }
        });
    }

    @Override
    public void launchFragment(Bundle bundle, Fragment fragment) {

    }
}