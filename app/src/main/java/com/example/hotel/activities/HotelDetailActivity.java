package com.example.hotel.activities;

import android.os.Bundle;
import android.view.View;

import com.example.hotel.Adapter.HotelDetailAdapter;
import com.example.hotel.Interface.AdapterListener;
import com.example.hotel.Models.Hotel;
import com.example.hotel.R;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HotelDetailActivity extends AppCompatActivity {
    ArrayList<Hotel> hotels = new ArrayList<>(); //initialize array so that we can add values to arraylist
    RecyclerView recyclerView;
    HotelDetailAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_detail_activity);
        recyclerView = findViewById(R.id.detail_recycler_v);
        adapter= new HotelDetailAdapter(hotels, getApplicationContext(), new AdapterListener() {
            @Override
            public void onClick(View view, int position) {
                //open new activity or whatever you like to do
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
        loadData();
    }

    private void loadData() {
        hotels.add(new Hotel(R.drawable.capital,"Hotel Mahraja Pvt Ltd","Find the best place to enjoy"));
        hotels.add(new Hotel(R.drawable.hotel,"Hotel Nabraaj Pvt Ltd","Find the best place to enjoy"));
        hotels.add(new Hotel(R.drawable.nature,"Hotel Daaaka Pvt Ltd","Find the best place to enjoy"));
        hotels.add(new Hotel(R.drawable.party,"Hotel lufffy Pvt Ltd","Find the best place to enjoy"));
        hotels.add(new Hotel(R.drawable.premium,"Hotel Zorro senpai Pvt Ltd","Find the best place to enjoy"));
        hotels.add(new Hotel(R.drawable.smart,"Hotel Ussoppp Pvt Ltd","Find the best place to enjoy"));
        hotels.add(new Hotel(R.drawable.party,"Hotel lufffy Pvt Ltd","Find the best place to enjoy"));
        hotels.add(new Hotel(R.drawable.premium,"Hotel Zorro senpai Pvt Ltd","Find the best place to enjoy"));
        hotels.add(new Hotel(R.drawable.smart,"Hotel Ussoppp Pvt Ltd","Find the best place to enjoy"));
    }
}
