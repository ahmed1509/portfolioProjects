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
public interface VmAuditDao {
    public void writeAuditEntry(String entry) throws persistenceException;
    
    
}
