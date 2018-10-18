/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newdvdproject.controller;

import com.newdvdproject.dao.ClassDvdDao;
import com.newdvdproject.dao.ClassDvdDaoException;
import com.newdvdproject.dao.ClassDvdDaoFileImpl;
import com.newdvdproject.ui.ClassDvdView;
import com.newdvdproject.dto.Dvd;
import com.newdvdproject.ui.UserIO;
import com.newdvdproject.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author LENOVO USER
 */
public class ClassDvdController {
    
    
    private UserIO io;
    ClassDvdView view;
    ClassDvdDao dao;
    
  
    
    public ClassDvdController(ClassDvdDao dao, ClassDvdView view) {
    this.dao = dao;
    this.view = view;
}
    
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
        while(keepGoing){
         
            menuSelection = getMenuSelection();
            
            switch(menuSelection){
                 case 1:
	                    listDvds();
	                    break;
	                case 2:
	                   createDvd();
	                    break;
	                case 3:
	                    viewDvd();
	                    break;
	                case 4:
	                    removeDvd();
	                    break;
	                case 5:
                            editDvd();
                            break;
                        case 6:    
	                    keepGoing = false;
	                    break;
	                default:
	                    unknownCommand();
        }
    
}
        exitMessage();
}catch(ClassDvdDaoException e){
    view.displayErrorMessage(e.getMessage());
    
}
    }
    
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }
    
    private void createDvd()throws ClassDvdDaoException{
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }
    private void listDvds()throws ClassDvdDaoException{
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getallDvds();
        view.displayDvdList(dvdList);
    }
    private void viewDvd()throws ClassDvdDaoException{
        view.displayDisplayDvdBanner();
        String title = view.getTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }
    private void removeDvd()throws ClassDvdDaoException{
        view.displayRemoveDvdBanner();
        String title = view.getTitleChoice();
        dao.removeDvd(title);
        view.displayRemoveSuccessBanner();
    }
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    private void exitMessage(){
        view.displayExitBanner();
    }
       public void editDvd()throws ClassDvdDaoException{
        view.displayEditDvdBanner();
        String title = view.getTitleChoice();
        Dvd editedDvd = view.getNewEditDvdInfo();
        dao.addDvd(editedDvd.getTitle(), editedDvd);
        Dvd dvd = dao.removeDvd(title);
        view.displayEditDvdSuccessBanner();
        
    }
}
