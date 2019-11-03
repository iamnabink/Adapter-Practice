package com.example.hotel.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hotel.Interface.AdapterListener;
import com.example.hotel.Models.Hotel;
import com.example.hotel.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class HotelDetailAdapter extends RecyclerView.Adapter<HotelDetailAdapter.DetailViewHolder> {
    ArrayList<Hotel> hotels;
    Context context;
    AdapterListener listener;

    public HotelDetailAdapter(ArrayList<Hotel> hotels, Context context, AdapterListener listener) {
        this.hotels = hotels;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_detail_activity,parent,false);
        DetailViewHolder viewHolder= new DetailViewHolder(view);
        return viewHolder; //we need view so we have to return viewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        //in this method bind data with respective component
        Hotel hotel = hotels.get(position);//get position of the value from the Hotel type arraylist
        holder.hotelImage.setImageResource(hotel.getImage());
        holder.hotelName.setText(hotels.get(position).getName());
        holder.hotelDesc.setText(hotel.getDescription());
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder{
        TextView hotelName,hotelDesc;
        CircleImageView hotelImage;
        public DetailViewHolder(@NonNull final View itemView) {
            super(itemView);
            hotelImage=itemView.findViewById(R.id.hotel_image_iv);
            hotelName=itemView.findViewById(R.id.hotel_name_tv);
            hotelDesc=itemView.findViewById(R.id.hotel_desc_tv);
            hotelImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(itemView,getPosition());
                }
            });
        }
    }
}
