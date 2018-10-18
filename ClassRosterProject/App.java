/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classroster;

import classroster.dao.ClassRosterAuditDao;
import classroster.dao.ClassRosterAuditDaoFileImpl;
import com.classroster.ui.ClassRosterView;
import com.classroster.ui.UserIOConsoleImpl;
import classroster.dao.ClassRosterDaoFileImpl;
import com.classroster.ui.UserIO;
import classroster.dao.ClassRosterDao;
import com.classroster.controller.ClassRosterController;
import com.classroster.service.ClassRosterServiceLayer;
import com.classroster.service.ClassRosterServiceLayerImpl;

/**
 *
 * @author LENOVO USER
 */

public class App {
	    
	   /* public static void main(String[] args) {
	        ClassRosterController controller = new ClassRosterController();
	        controller.run();
	    }   
*/
     public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
         ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        ClassRosterController controller = 
        new ClassRosterController(myService, myView);
        controller.rum();
}
	}
	
    
