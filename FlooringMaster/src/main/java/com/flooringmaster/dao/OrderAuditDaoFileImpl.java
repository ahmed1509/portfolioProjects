/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO USER
 */
public class OrderAuditDaoFileImpl implements OrderDaoAudit{
public static final String AUDIT_FILE = "orderAudit_txt";

    @Override
    public void writeAudit(String entry) throws OrderPersistenceException {
        PrintWriter out;
        
    try {
        out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
    } catch (IOException ex) {
        throw new OrderPersistenceException(" Could not Persist Audit Information", ex);
    }
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
    
}
