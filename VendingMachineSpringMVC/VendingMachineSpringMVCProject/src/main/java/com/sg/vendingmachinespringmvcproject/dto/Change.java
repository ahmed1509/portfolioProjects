/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcproject.dto;

/**
 *
 * @author dsmelser
 */
public interface Change {
    int getDollars();
    int getQuaters();
    int getPennies();
    int getNickles();
    int getDimes();
}
