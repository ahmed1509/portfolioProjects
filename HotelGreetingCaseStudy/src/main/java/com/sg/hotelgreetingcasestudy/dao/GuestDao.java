/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hotelgreetingcasestudy.dao;

import com.sg.hotelgreetingcasestudy.dto.Guest;
import com.sg.hotelgreetingcasestudy.dto.Reservation;
import java.util.List;

/**
 *
 * @author LENOVO USER
 */
public interface GuestDao {
    public void readFromJsonFileForGuests();
       public Guest getGuest(Guest guestName);
       public List<Guest> getListOfGuests();
       public Reservation getReservation(int roomNumber);
       public List<Reservation> getListOfReservations();
}
