/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcproject.service;

/**
 *
 * @author LENOVO USER
 */
public class OutOfInventoryException extends Exception {
    public OutOfInventoryException(String message){
        super();
    }
    public OutOfInventoryException(String message, Throwable cause){
        super(message,cause);
    }
    
}
