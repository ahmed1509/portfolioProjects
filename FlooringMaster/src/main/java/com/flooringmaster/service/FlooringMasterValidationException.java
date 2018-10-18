/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.service;

/**
 *
 * @author LENOVO USER
 */
public class FlooringMasterValidationException extends Exception {
    
  
    public FlooringMasterValidationException (String message){
        super();
    }
    public FlooringMasterValidationException (String message, Throwable cause){
        super(message,cause);
    }
    
}

