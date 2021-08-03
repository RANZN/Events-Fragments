package com.ranzan.events;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PreviewActivity extends AppCompatActivity {
    private TextView title;
    private TextView description;
    private TextView startDate;
    private TextView endDate;
    private TextView startTime;
    private TextView endTime;
    private TextView currency;
    private TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
        setData();
    }

    private void setData() {
        Data data = (Data) getIntent().getSerializableExtra("data");
        title.setText(data.getTitle());
        description.setText(data.getDescription());
        startDate.setText(data.getStartDate());
        endDate.setText(data.getEndDate());
        startTime.setText(data.getStartTime());
        endTime.setText(data.getEndTime());
        currency.setText(data.getCurrency());
        price.setText(data.getPrice());


    }

    private void initViews() {
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);
        startTime = findViewById(R.id.startTime);
        endTime = findViewById(R.id.endTime);
        currency = findViewById(R.id.currency);
        price = findViewById(R.id.price);

    }
}