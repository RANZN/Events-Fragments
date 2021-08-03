package com.ranzan.events;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PriceDetailsFragment extends Fragment {
    private EditText currency;
    private EditText price;
    private Button btnNext;
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price_details, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("title");
        description = getArguments().getString("description");
        startDate = getArguments().getString("startDate");
        endDate = getArguments().getString("endDate");
        startTime = getArguments().getString("startTime");
        endTime = getArguments().getString("endTime");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        currency = view.findViewById(R.id.currency);
        price = view.findViewById(R.id.price);
        btnNext = view.findViewById(R.id.btnNext3);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Data data = new Data(title, description, startDate, endDate, startTime,
                        endTime, currency.getText().toString(), price.getText().toString());
                Intent intent = new Intent(getActivity(), PreviewActivity.class);
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });
    }
}