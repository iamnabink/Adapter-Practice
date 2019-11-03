package com.example.hotel.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel.Adapter.BookingAdapter;
import com.example.hotel.Adapter.HotelAdapter;
import com.example.hotel.Interface.AdapterListener;
import com.example.hotel.Models.Booking;
import com.example.hotel.Models.Hotel;
import com.example.hotel.R;
import com.example.hotel.activities.HotelDetailActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    HotelAdapter adapter;
    BookingAdapter bookingAdapter;
    ArrayList<Hotel> hotels=new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();
    RecyclerView recyclerView,recyclerViewBooking;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container,false);
        recyclerView=view.findViewById(R.id.recycle);
        recyclerViewBooking=view.findViewById(R.id.recyclev_booking);
        bookingAdapter=new BookingAdapter(bookings, getContext(), new AdapterListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), HotelDetailActivity.class);
                startActivity(intent);
            }
        });
        adapter=new HotelAdapter(hotels,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        recyclerViewBooking.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);
        recyclerViewBooking.setAdapter(bookingAdapter);
        loaddata();
        return view;
    }
    private void loaddata() {
     hotels.add(new Hotel(R.drawable.capital,"capital","Premium Hotels with spacious rooms."));
       hotels.add(new Hotel(R.drawable.premium,"Premium","Budget friendly hotels at prime location and premium amenities"));
       hotels.add(new Hotel(R.drawable.smart,"Smart","Budget friendly hotels with basic amenities like clean linen, Wifi, TV etc."));
      bookings.add(new Booking("Party's \nnot over yet!",R.drawable.party,"Find an toyo for your after-party."));
      bookings.add(new Booking("Nature \nat it's best",R.drawable.nature,"Breathtaking views await you."));
   bookings.add(new Booking("Taking \na business trip?",R.drawable.hotel,"Get an OYO in prime locations near you."));

    }
}
