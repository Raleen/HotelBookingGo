package com.example.appface.Data;

import java.util.Date;

public class HotelBookedEntity
{
    public int Id;
    public int userId;
    public int hotelId;
    public Date dateOfAccommodation;
    public Date dateOfLeaving;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public Date getDateOfAccommodation() {
        return dateOfAccommodation;
    }

    public void setDateOfAccommodation(Date dateOfAccommodation) {
        this.dateOfAccommodation = dateOfAccommodation;
    }

    public Date getDateOfLeaving() {
        return dateOfLeaving;
    }

    public void setDateOfLeaving(Date dateOfLeaving) {
        this.dateOfLeaving = dateOfLeaving;
    }
}
