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
public interface Item {
    String getName();
    int getInventory();
    int getPennies();
    public void setInventory(int inventory);
    public void setPennies(int pennies);
    
    
}
