/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dao;

/**
 *
 * @author LENOVO USER
 */
public interface TaxesAuditDao {
    public void writeAudit(String entry) throws OrderPersistenceException;
}
