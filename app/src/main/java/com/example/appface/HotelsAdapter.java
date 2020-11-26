package com.example.appface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appface.Data.HotelEntity;

import java.util.List;

public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.ViewHolder> {

    private List<HotelEntity> listOfHotels;

    public HotelsAdapter(List<HotelEntity> listOfHotels){
        this.listOfHotels = listOfHotels;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView hotelNameView;
        public TextView hotelPriceView;
        public ImageButton hotelInfoButtonView;
        public ViewHolder(View hotelItemView){
            super(hotelItemView);
            hotelNameView = (TextView)hotelItemView.findViewById(R.id.hotelName);
            hotelPriceView = (TextView)hotelItemView.findViewById(R.id.hotelPrice);
            hotelInfoButtonView = (ImageButton)hotelItemView.findViewById(R.id.hotelInfoButton);
        }
    }



    @NonNull
    @Override
    public HotelsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflaterOfHotels = LayoutInflater.from(context);
        View hotelView = inflaterOfHotels.inflate(R.layout.hotel_item, parent, false);//adding items to a list view
        ViewHolder viewHolder = new ViewHolder(hotelView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HotelsAdapter.ViewHolder holder, int position) {
        HotelEntity hotelEntity = listOfHotels.get(position);//listOfHotels[0] - current one for display
        TextView hotelName = holder.hotelNameView;
        TextView hotelPrice = holder.hotelPriceView;
        hotelName.setText(hotelEntity.getHotelName());
        hotelPrice.setText(hotelEntity.getHotelValue());
    }

    @Override
    public int getItemCount() {
        return this.listOfHotels.size();
    }
}
