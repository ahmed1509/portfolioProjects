/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newdvdproject.dao;

import com.newdvdproject.dto.Dvd;
import com.newdvdproject.dao.ClassDvdDao;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author LENOVO USER
 */
public class ClassDvdDaoFileImpl implements ClassDvdDao {
    private Map<String, Dvd> dvds = new HashMap<>();
    @Override
    public Dvd addDvd(String title, Dvd dvd) throws ClassDvdDaoException {
        Dvd newDvd = dvds.put(title, dvd);
        writeDvd();
        return newDvd;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dvd> getallDvds() throws ClassDvdDaoException {
        loadDvd();
        return new ArrayList<Dvd>(dvds.values());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dvd getDvd(String title)throws ClassDvdDaoException {
        loadDvd();
        return dvds.get(title);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dvd removeDvd(String title)throws ClassDvdDaoException {
        Dvd removeDvd = dvds.remove(title);
        writeDvd();
        return removeDvd;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dvd editDvd(String title) throws ClassDvdDaoException{
        Dvd editDvd = dvds.get(title);
        writeDvd();
        return editDvd;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static final String DVD_FILE= "dvd.txt";
    public static final String DELIMITER = "::";
    private void loadDvd() throws ClassDvdDaoException{
        Scanner scanner;
        try{
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        }catch (FileNotFoundException e){
            throw new ClassDvdDaoException("-_- Couldn't Load roster data into memory", e);
        }
        String currentLine;
        String[] currentTokens;
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Dvd currentDvd = new Dvd(currentTokens[0]);
            
            currentDvd.setReleaseDate(currentTokens[1]);
            currentDvd.setMpaaRating(currentTokens[2]);
            currentDvd.setDirectorsName(currentTokens[3]);
            currentDvd.setStudio(currentTokens[4]);
            currentDvd.setUserRating(currentTokens[5]);
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();
    }
    
    private void writeDvd() throws ClassDvdDaoException{
        PrintWriter out;
        
          try {
	        out = new PrintWriter(new FileWriter(DVD_FILE));
	    } catch (IOException e) {
	        throw new ClassDvdDaoException(
	                "Could not save student data.", e);
	    }
          
          List<Dvd> dvdList = this.getallDvds();
          for(Dvd currentDvd : dvdList){
              out.print(currentDvd.getTitle() + DELIMITER
              + currentDvd.getReleaseDate() + DELIMITER
              + currentDvd.getMpaaRating() + DELIMITER
              + currentDvd.getDirectorsName() + DELIMITER
              + currentDvd.getStudio() + DELIMITER
              + currentDvd.getUserRating());
              
              out.flush();
          }
          out.close();
    }
    
    
}
