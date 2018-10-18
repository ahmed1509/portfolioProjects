/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcproject.dao;

/**
 *
 * @author LENOVO USER
 */
public class persistenceException extends Exception {

    public persistenceException(String message) {
        super(message);
    }

    public persistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
