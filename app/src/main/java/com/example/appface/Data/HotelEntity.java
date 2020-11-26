package com.example.appface.Data;

public class HotelEntity {

    public String hotelImage;//url to the real image inside of a folder on the server
    public String hotelName;
    public String hotelValue;

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

}
