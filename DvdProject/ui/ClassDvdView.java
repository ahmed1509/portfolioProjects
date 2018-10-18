/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newdvdproject.ui;

import com.newdvdproject.ui.UserIOConsoleImpl;
import com.newdvdproject.ui.UserIO;
import com.newdvdproject.dto.Dvd;
import java.util.List;

/**
 *
 * @author LENOVO USER
 */
public class ClassDvdView {
    UserIO io;
    
      public ClassDvdView(UserIO io){
        this.io=io;
    }
    public int printMenuAndGetSelection(){
         io.print("Choose from the bottom Options:");
            io.print("1. List Dvds");
	    io.print("2. Create New Dvd");
	    io.print("3. View a Dvd");
	    io.print("4. Remove a Dvd");
            io.print("5. Edit a Dvd");
	    io.print("6. Exit");
            
            return io.readInt("Please Select From the Above choices: ", 1, 6);
    }
    public Dvd getNewDvdInfo(){
        String title = io.readString("Please Enter the Dvd Title: ");
        String releaseDate = io.readString("Please Enter the release year: ");
	String mpaaRating = io.readString("Please Enter the MPAA Rating: ");
	String directorsName = io.readString("Please Enter The Directors Name: ");
        String studio = io.readString("Please Enter the Studio Name: ");
        String userRating = io.readString("Anything else you woluld like to add:  ");
        
        Dvd currentDvd = new Dvd(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirectorsName(directorsName);
        currentDvd.setStudio(studio);
        currentDvd.setUserRating(userRating);
        return currentDvd;
    }
    public void displayCreateDvdBanner(){
        io.print("===Create Student====");
    }
    public void displayCreateSuccessBanner(){
        io.readString("Dvd Successfully Created. Please Enter to Continue: ");
    }
    public void displayDvdList(List<Dvd> dvdList){
        for(Dvd currentDvd : dvdList){
            io.print(currentDvd.getTitle()+ ": "
              + currentDvd.getReleaseDate() + " "
              + currentDvd.getMpaaRating() + " "
              + currentDvd.getDirectorsName() + " "
              + currentDvd.getStudio() + " "
              + currentDvd.getUserRating());
                   
        }
        io.readString("please Enter to Continue. ");
    }
    
    public void displayDisplayAllBanner(){
        io.print("===Display All DVDs===");
    }
    public void displayDisplayDvdBanner(){
        io.print("===Display A DVD====");
    }
    public String getTitleChoice(){
        return io.readString("please Enter the Title");
    }
    public void displayDvd(Dvd dvd){
        if(dvd !=null){
            io.print("Title Name:  " + dvd.getTitle());
            io.print( "Release Date:  " + dvd.getReleaseDate());
            io.print("MPAA RATING:  " + dvd.getMpaaRating());
            io.print("Directors Name:   " + dvd.getDirectorsName());
            io.print("Studio Name: " +dvd.getStudio());
            io.print("Comments:  " +dvd.getUserRating());
        } else {
            io.print("It Doesn't Exist");
            
        }
        io.readString("Please Enter to Continue");
    }
    
    public void displayRemoveDvdBanner(){
        io.print("===Remove A DVD===");
    }
    public void displayRemoveSuccessBanner(){
        io.readString("DVD Successfully removed. Please hit Enter to Continue: ");
    }
    public void displayExitBanner(){
        io.print("Good Bye");
    }
    public void displayUnknownCommandBanner(){
        io.print("Unknown Command Entered!!!");
    }
    
    public void displayEditDvdBanner(){
        io.print("===Edit A DVD==");
    }
    public void displayEditDvdSuccessBanner(){
        io.readString("Dvd Edited Successfully. Please hit a key to continue");
    }
   public Dvd getNewEditDvdInfo(){
        String title = io.readString("Pleas Update the Dvd Title");
        String releaseDate= io.readString("Please Enter the Updated release date");
        String mpaaRating = io.readString("please Enter The updated MPAA Rating");
        String directorName = io.readString("Please Enter the updated Directors Name");
        String studio = io.readString("Please Enter the updated Studios Name");
        String userRating = io.readString("Please Enter the updated User rating");
        Dvd currentDvd = new Dvd(title);
        currentDvd.setDirectorsName(directorName);
        currentDvd.setStudio(studio);
        currentDvd.setUserRating(userRating);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setReleaseDate(releaseDate);
        
        return currentDvd;
        
    }
   public void displayErrorMessage(String errorMsg){
       io.print("====Error====");
       io.print(errorMsg);
   }
}
