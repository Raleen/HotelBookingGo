package com.example.appface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
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
    private OnItemClickListenerInterface onItemClickListener;

    public interface OnItemClickListenerInterface
    {
        void OnItemClick(int position);
    }

    public void OnItemClickListener(OnItemClickListenerInterface itemListener)
    {
        onItemClickListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView hotelNameView;
        public TextView hotelPriceView;
        public ImageView hotelImageView;
        public ViewHolder(View hotelItemView, OnItemClickListenerInterface onItemClickListener){
            super(hotelItemView);
            hotelImageView = (ImageView)hotelItemView.findViewById(R.id.hotelImageViewId);
            hotelNameView = (TextView)hotelItemView.findViewById(R.id.hotelName);
            hotelPriceView = (TextView)hotelItemView.findViewById(R.id.hotelPrice);

            hotelItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemClickListener != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            onItemClickListener.OnItemClick(position);
                        }
                    }
                }
            });

        }
    }



    @NonNull
    @Override
    public HotelsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflaterOfHotels = LayoutInflater.from(context);
        View hotelView = inflaterOfHotels.inflate(R.layout.hotel_item, parent, false);//adding items to a list view
        ViewHolder viewHolder = new ViewHolder(hotelView, onItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HotelsAdapter.ViewHolder holder, int position) {
        HotelEntity hotelEntity = listOfHotels.get(position);//listOfHotels[0] - current one for display
        ImageView hotelImage = holder.hotelImageView;
        TextView hotelName = holder.hotelNameView;
        TextView hotelPrice = holder.hotelPriceView;
        hotelImage.setImageResource(hotelEntity.getHotelImageOne());
        hotelName.setText(hotelEntity.getHotelName());
        hotelPrice.setText(hotelEntity.getHotelValue());
    }

    @Override
    public int getItemCount() {
        return this.listOfHotels.size();
    }
}
