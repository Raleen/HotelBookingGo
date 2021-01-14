package com.example.appface.Data;

import android.net.Uri;

import java.io.Serializable;

public class HotelEntity implements Serializable {

    public int hotelImageOne;//url to the real image inside of a folder on the server
    public String hotelName;
    public String hotelValue;
    public int hotelRoomsCount;
    public boolean isAvailable;


    private void setHotelImageOne(int hotelImageOne) {
        this.hotelImageOne = hotelImageOne;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelValue() {
        return hotelValue;
    }

    public void setHotelValue(String hotelValue) {
        this.hotelValue = hotelValue;
    }

    public int getHotelImageOne()
    {
        return hotelImageOne;
    }

    public void setHotelImage(int hotelImage) { this.hotelImageOne = hotelImage; }

    public int getHotelRoomsCount() {
        return hotelRoomsCount;
    }

    public void setHotelRoomsCount(int hotelRoomsCount) {
        this.hotelRoomsCount = hotelRoomsCount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    
}
