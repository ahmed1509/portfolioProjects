/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hotelgreetingcasestudy.dto;

/**
 *
 * @author LENOVO USER
 */
public class Reservation {
    private int roomNumber;
    private int startTimeStamp;
    private int endTimeStamp;
    
    public Reservation (int roomNumber, int startTimeStamp, int endTimeStamp){
    this.roomNumber = roomNumber;
    this.endTimeStamp = endTimeStamp;
    this.startTimeStamp = startTimeStamp;
}

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(int startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public int getEndTimeStamp() {
        return endTimeStamp;
    }

    public void setEndTimeStamp(int endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }
    
    
}
