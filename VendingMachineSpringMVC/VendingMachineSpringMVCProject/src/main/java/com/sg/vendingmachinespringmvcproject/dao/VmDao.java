/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcproject.dao;

import com.sg.vendingmachinespringmvcproject.dto.Item;
import com.sg.vendingmachinespringmvcproject.service.InSufficientMoney;
import com.sg.vendingmachinespringmvcproject.service.OutOfInventoryException;
import java.util.List;

/**
 *
 * @author dsmelser
 */
public interface VmDao {

    public List<Item> getAllItems() throws persistenceException, InSufficientMoney, OutOfInventoryException;

    public void saveItem(Item userChoice) throws persistenceException, InSufficientMoney, OutOfInventoryException;

}
