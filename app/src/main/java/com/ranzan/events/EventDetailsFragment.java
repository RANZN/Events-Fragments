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

public class EventDetailsFragment extends Fragment implements CommunicationListener {
    private EditText title;
    private EditText description;
    private Button btnNext;
    private CommunicationListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_details, container, false);
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
        title = view.findViewById(R.id.title);
        description = view.findViewById(R.id.description);
        btnNext = view.findViewById(R.id.btnNext1);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("title", title.getText().toString());
                bundle.putString("description", description.getText().toString());
                TimeAndDateFragment fragment = new TimeAndDateFragment();
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