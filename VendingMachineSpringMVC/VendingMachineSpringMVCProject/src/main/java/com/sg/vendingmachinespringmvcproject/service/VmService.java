/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcproject.service;

import com.sg.vendingmachinespringmvcproject.dao.persistenceException;
import com.sg.vendingmachinespringmvcproject.dto.Change;
import com.sg.vendingmachinespringmvcproject.dto.Item;
import java.util.List;

/**
 *
 * @author dsmelser
 */
public interface VmService {

    public List<Item> getAllItems()throws persistenceException,InSufficientMoney, OutOfInventoryException;

 
     
    public Change vendItem(int moneyInPennies, Item userChoice) throws InSufficientMoney, OutOfInventoryException, persistenceException;

  
    
}
