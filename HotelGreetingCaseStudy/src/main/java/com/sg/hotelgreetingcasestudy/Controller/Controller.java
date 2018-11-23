/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hotelgreetingcasestudy.Controller;

import com.sg.hotelgreetingcasestudy.dao.CompanyDao;
import com.sg.hotelgreetingcasestudy.dao.GuestDao;
import com.sg.hotelgreetingcasestudy.dto.Company;
import com.sg.hotelgreetingcasestudy.dto.Guest;
import com.sg.hotelgreetingcasestudy.dto.Reservation;
import com.sg.hotelgreetingcasestudy.view.UserIO;
import com.sg.hotelgreetingcasestudy.view.view;
import java.util.List;

/**
 *
 * @author LENOVO USER
 */
public class Controller {

    UserIO io;
    view view;
    CompanyDao companyDao;
    GuestDao guestDao;

    public Controller(CompanyDao dao, view view, GuestDao guestDao) {
        this.companyDao = dao;
        this.view = view;
        this.guestDao = guestDao;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listAllCompanies();
                    break;
                case 2:
                    listOfAllGuests();
                    break;
                case 3:
                    createMessage();
                    break;
                case 4:
                    viewACompany();
                    break;
                default:
                    unknownCommand();
            }

        }

    }

    private void createMessage() {
        List<Company> listOfCompanies = companyDao.getListOfCompanies();
        Company companyName = view.getCompanyName(listOfCompanies);
        Company companyName2 = companyDao.getCompany(companyName);
        List<Guest> listOfGuests = guestDao.getListOfGuests();
        Guest guestName = view.getGuestName(listOfGuests);
        Guest guestName2 = guestDao.getGuest(guestName);
        int roomNumber = view.getRoomNumber(guestName);
        Reservation reservation = guestDao.getReservation(roomNumber);
        view.displayMessage(guestName2, companyName2, reservation);
    }

    private void listAllCompanies() {
        view.displayDisplayAllBanner();
        List<Company> listOfCompanies = companyDao.getListOfCompanies();
        view.displayCompanyList(listOfCompanies);
    }

    private void viewACompany() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void listOfAllGuests() {
        view.displayGuestAllBanner();
        List<Guest> listOfGuets = guestDao.getListOfGuests();
        view.displayGuestList(listOfGuets);
    }

}
