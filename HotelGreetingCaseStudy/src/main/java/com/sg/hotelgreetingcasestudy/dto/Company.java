/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hotelgreetingcasestudy.dto;

/**
 *
 * @author LENOVO USER
 */
public class Company {
   private int id;
   private String companyName;
   private String city;
   private String timeZone;

   
   public Company(String companyName, String city, String timeZone, int id){
       this.city = city;
       this.companyName = 
        this.timeZone = timeZone;
       this.id = id;
   }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
   
   
}
