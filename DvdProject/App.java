/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newdvdproject;

import com.newdvdproject.controller.ClassDvdController;
import com.newdvdproject.dao.ClassDvdDao;
import com.newdvdproject.dao.ClassDvdDaoFileImpl;
import com.newdvdproject.ui.ClassDvdView;
import com.newdvdproject.ui.UserIO;
import com.newdvdproject.ui.UserIOConsoleImpl;

/**
 *
 * @author LENOVO USER
 */
public class App {
    
	    
	    public static void main(String[] args) {
                UserIO myIo = new UserIOConsoleImpl();
                ClassDvdView myView = new ClassDvdView(myIo);
                ClassDvdDao myDao = new ClassDvdDaoFileImpl();
	        ClassDvdController controller = new ClassDvdController(myDao, myView);
	        controller.run();
	    
	}
}
