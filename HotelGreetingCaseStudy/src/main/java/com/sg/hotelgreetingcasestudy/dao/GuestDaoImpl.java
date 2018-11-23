/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hotelgreetingcasestudy.dao;

import com.sg.hotelgreetingcasestudy.dto.Guest;
import com.sg.hotelgreetingcasestudy.dto.Reservation;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author LENOVO USER
 */
public class GuestDaoImpl implements GuestDao {

    private Map<String, Guest> guests = new HashMap<>();
    private Map<Integer, Reservation> reservations = new HashMap<Integer, Reservation>();

    @Override
    public void readFromJsonFileForGuests() {
        JSONParser parser = new JSONParser();

        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("Guests.json"));
//            Object obj = parser.parse(new FileReader("Companies.json"));

            for (Object o : a) {

                JSONObject jsonObject = (JSONObject) o;

                String firstName = (String) jsonObject.get("firstName").toString();
                String lastName = (String) jsonObject.get("lastName").toString();
                String id = (String) jsonObject.get("id").toString();
                int guestId = Integer.parseInt(id);

                Guest currentGuest = new Guest(firstName, lastName, guestId);
                guests.put(currentGuest.getFirstName(), currentGuest);
                for (Object secondObject : a) {

                    JSONObject jsonObject2 = (JSONObject) secondObject;

                    //String firstName = (String) jsonObject.get("reservation").toString();
                    String stringRoomNumber = (String) jsonObject2.get("roomNumber").toString();
                    int roomNumber = Integer.parseInt(stringRoomNumber);
                    String stringStartTimeStamp = (String) jsonObject2.get("startTimestamp").toString();
                    int startTimeStamp = Integer.parseInt(stringStartTimeStamp);
                    String stringEndTimeStamp = (String) jsonObject2.get("endTimestamp").toString();
                    int endTimeStamp = Integer.parseInt(stringEndTimeStamp);
                    Reservation currentReservation = new Reservation(roomNumber, startTimeStamp, endTimeStamp);
                    reservations.put(currentReservation.getRoomNumber(), currentReservation);
                    currentGuest.setReservation(currentReservation);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Could Not Found File");
        } catch (IOException ex) {
            System.out.println("Could Not Found File");
        } catch (org.json.simple.parser.ParseException ex) {
            System.out.println("Could Not Parse The File");
        }
    }

    @Override
    public List<Guest> getListOfGuests() {
        readFromJsonFileForGuests();
        return new ArrayList<>(guests.values());
    }

    @Override
    public Guest getGuest(Guest guestName
    ) {

        return guests.get(guestName);
    }

    @Override
    public Reservation getReservation(int roomNumber) {
        return reservations.get(roomNumber);
    }

    @Override
    public List<Reservation> getListOfReservations() {
        readFromJsonFileForGuests();
        return new ArrayList<>(reservations.values());
    }

}
