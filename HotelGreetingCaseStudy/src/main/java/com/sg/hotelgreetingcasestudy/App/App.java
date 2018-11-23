/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hotelgreetingcasestudy.App;

import com.sg.hotelgreetingcasestudy.Controller.Controller;
import com.sg.hotelgreetingcasestudy.dao.CompanyDao;
import com.sg.hotelgreetingcasestudy.dao.CompanyDaoImpl;
import com.sg.hotelgreetingcasestudy.dao.GuestDao;
import com.sg.hotelgreetingcasestudy.dao.GuestDaoImpl;
import com.sg.hotelgreetingcasestudy.view.UserIO;
import com.sg.hotelgreetingcasestudy.view.UserIOConsoleImpl;
import com.sg.hotelgreetingcasestudy.view.view;

/**
 *
 * @author LENOVO USER
 */
public class App {

    public static void main(String[] args){
        UserIO myIo = new UserIOConsoleImpl();
        view myView = new view(myIo);
        CompanyDao myDao = new CompanyDaoImpl();
        GuestDao guestDao = new GuestDaoImpl();
        Controller controller = new Controller(myDao, myView, guestDao);
        controller.run();
    }
}
