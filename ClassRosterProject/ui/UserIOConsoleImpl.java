/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classroster.ui;

/**
 *
 * @author LENOVO USER
 */


import com.classroster.ui.UserIO;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author dsmelser
 */
public class UserIOConsoleImpl implements UserIO {

    Scanner reader = new Scanner( System.in );
    
    @Override
    public void print(String message) {
         System.out.println(message);
         
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double readDouble(String prompt) {
        double toReturn = Double.NaN;
        System.out.println( prompt );
        
        //we want to loop until the input is valid
        //(aka we want to loop while the input is not valid)
        boolean validInput = false;
        while( !validInput )
        {
            try
            {
                //retrieve a line from the user
                String toCheck = reader.nextLine();
                toReturn = Double.parseDouble( toCheck );
                
                //if we get to this line, that means
                //that parseDouble() didn't throw an exception
                validInput = true;
            }
            catch(NumberFormatException e)
            {
                //if we hit this catch block, that means
                //that the user failed to enter something
                //that could be parsed as a double
                System.out.println("Please enter a valid number.");
            }
                
        }

        
        return toReturn;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        
        double toReturn = Double.NaN;
        
        boolean isValid = false;
        while( !isValid )
        {
            toReturn = readDouble( prompt );
            
            if( toReturn < min || toReturn > max)
            {
                System.out.println( "Please enter a number between " + min + " and " + max + ".");
            }
            else
            {
                isValid = true;
            }
        }
        
        return toReturn;
       
    }

    @Override
    public float readFloat(String prompt) {
        float  userReturn= Float.NaN;
        System.out.println(prompt);
        
        boolean rightNumber = false;
        while(!rightNumber){
            try{
                String check = reader.nextLine();
                userReturn = Float.parseFloat(check);
                
                rightNumber = true;
            }
            catch(NumberFormatException e){
                System.out.println("please Enter a valid Number");
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }return userReturn;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float  userReturn= Float.NaN;
        boolean isItValid = false;
        while(!isItValid){
            userReturn = readFloat(prompt);
            if(userReturn < min || userReturn > max){
                System.out.println("Please Enter a num between " + min + " and " + max + ".");
            }
            else {isItValid = true;
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        return userReturn;
    }

    @Override
    public int readInt(String prompt) {
         int  userReturn= Integer.MIN_VALUE;
        System.out.println(prompt);
        
             boolean rightNumber = false;
        while(!rightNumber){
            try{
                String check = reader.nextLine();
                userReturn = Integer.parseInt(check);
                
                rightNumber = true;
            }
            catch(NumberFormatException e){
                System.out.println("please Enter a valid Number");
        }
        
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    return userReturn;
    }
   

    @Override
    public int readInt(String prompt, int min, int max) {
        int  userReturn=Integer.MIN_VALUE ;
        boolean isItValid = false;
        while(!isItValid){
            userReturn = readInt(prompt);
            if(userReturn < min || userReturn > max){
                System.out.println("Please Enter a num between " + min + " and " + max + ".");
            }
            else {
                isItValid = true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        }return userReturn;
    }
    @Override
    public long readLong(String prompt) {
            Long  userReturn= Long.MIN_VALUE;
        System.out.println(prompt);
        
             boolean rightNumber = false;
        while(!rightNumber){
            try{
                String check = reader.nextLine();
                userReturn = Long.parseLong(check);
                
                rightNumber = true;
            }
            catch(NumberFormatException e){
                System.out.println("please Enter a valid Number");
        }
        
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    return userReturn;
    }
    @Override
    public long readLong(String prompt, long min, long max) {
       long  userReturn=Long.MIN_VALUE ;
        boolean isItValid = false;
        while(!isItValid){
            userReturn = readLong(prompt);
            if(userReturn < min || userReturn > max){
                System.out.println("Please Enter a num between " + min + " and " + max + ".");
            }
            else {
                isItValid = true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        }return userReturn;
    }

    @Override
    public String readString(String prompt) {
          System.out.println(prompt);
        String read = reader.nextLine();
        return read;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


   
}    
    
