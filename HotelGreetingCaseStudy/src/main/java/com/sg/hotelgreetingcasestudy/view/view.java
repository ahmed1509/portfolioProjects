/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hotelgreetingcasestudy.view;

import com.sg.hotelgreetingcasestudy.dto.Company;
import com.sg.hotelgreetingcasestudy.dto.Guest;
import com.sg.hotelgreetingcasestudy.dto.Reservation;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author LENOVO USER
 */
public class view {

    UserIO io;

    public view(UserIO io) {
        this.io = io;
    }

    public void displayCompany(Company company) {
        if (company != null) {
            io.print("Company Name:  " + company.getCompanyName());
            io.print("City :  " + company.getCity());
            io.print("TimeZone:  " + company.getTimeZone());

        } else {
            io.print("It Doesn't Exist");
        }
        io.readString("Please Enter to Continue");
    }

    public void displayCompanyList(List<Company> listOfCompanies) {
        for (Company currentCompany : listOfCompanies) {
            io.print(currentCompany.getCompanyName() + ": "
                    + currentCompany.getCity() + " "
                    + currentCompany.getTimeZone() + " "
            );

        }
        io.readString("please Enter to Continue. ");
    }
    

    public void displayDisplayAllBanner() {
         io.print("===Display All Companies===");
    }

    public int printMenuAndGetSelection() {
        io.print("Choose from the bottom Options:");
        io.print("1. List Companies");
        io.print("2. list of Guests");
        io.print("3. Create New Message");
        io.print("4. View a Companies");
        io.print("5. Exit");

        return io.readInt("Please Select From the Above choices: ", 1, 6);
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command Entered!!!");
    }
    
    public Company getCompanyName( List<Company> companies){
        Company company = null;
        boolean isValid = false;
        while(!isValid){
            String userChoice = io.readString("Please Enter Company Name");
            List<Company> matchingCompany;
            matchingCompany = companies.stream()
                    .filter(i -> userChoice.contains(i.getCompanyName()))
                    .collect(Collectors.toList());
            
            if(matchingCompany.isEmpty()){
                isValid = false;
                io.readString("Please Enter a valid company");
            }else{
                company = matchingCompany.get(0);
            }
        }
        return company;
    }
     public Guest getGuestName(List<Guest> guests){
         Guest guest = null;
         boolean isValid = false;
         while(!isValid){
             String guestName = io.readString("Please Enter Guest Name");
             List<Guest> matchingGuest = guests.stream()
                     .filter(i -> guestName.matches(i.getFirstName()))
                     .collect(Collectors.toList());
             if(matchingGuest.isEmpty()){
                 isValid = false;
                 io.readString("Please Enter a valid name");
             }else{
                 guest = matchingGuest.get(0);
             }
         }
        return guest;
    }
     
      public void displayGuestList(List<Guest> listOfGuests) {
          listOfGuests.forEach((currentGuest) -> {
              io.print(currentGuest.getFirstName() + ": "
                      + currentGuest.getLastName()
              );
        });
        io.readString("please Enter to Continue. ");
    }

    public void displayGuestAllBanner() {
        io.print("===Display All Guests===");
    }
    public int getRoomNumber(Guest guest){
        return guest.getReservation().getRoomNumber();
    }
      

    
    public void displayMessage(Guest guest, Company company, Reservation reservation){
       io.print("Good Morning " + guest.getFirstName() + " and welcome to " + company.getCompanyName() +
               "! Room" + reservation.getRoomNumber() + " is now ready for you."
                       + "  Enjoy your stay, and let us know if you need anything.");
    }
}
