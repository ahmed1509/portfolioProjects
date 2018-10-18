package com.sg.vendingmachinespringmvcproject.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author LENOVO USER
 */
public class ChangeImpl implements Change {

    int dollars;
    int quaters;
    int dimes;
    int nickles;
    int pennies;

    public ChangeImpl(int pennies) {
        dollars = pennies / 100;
        pennies = pennies % 100;

        quaters = pennies / 25;
        pennies = pennies % 25;

        dimes = pennies / 10;
        pennies = pennies % 10;

        nickles = pennies / 5;
        pennies = pennies % 5;

        this.pennies = pennies;

    }

    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public int getQuaters() {
        return quaters;
    }

    public void setQuaters(int quaters) {
        this.quaters = quaters;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    @Override
    public int getPennies() {
        return pennies;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNickles() {
        return nickles;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNickles(int nickles) {
        this.nickles = nickles;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

}
