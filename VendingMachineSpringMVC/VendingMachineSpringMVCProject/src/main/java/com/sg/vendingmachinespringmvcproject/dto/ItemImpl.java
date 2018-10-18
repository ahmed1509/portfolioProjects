/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcproject.dto;

/**
 *
 * @author LENOVO USER
 */
public class ItemImpl implements Item {

    String name;
    int inventory;
    int pennies;
    public  ItemImpl(String name, int inventory, int pennies) {
        this.name = name;
        this.inventory = inventory;
        this.pennies = pennies;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
    }

   

    @Override
    public String getName() {
        return name;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getInventory() {
        return inventory;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPennies() {
        return pennies;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }
    
    @Override
    public String toString()
    {
    return "Product Name: " + name + " In Stock: " + inventory + " Cost: " + pennies;
    
}

}
