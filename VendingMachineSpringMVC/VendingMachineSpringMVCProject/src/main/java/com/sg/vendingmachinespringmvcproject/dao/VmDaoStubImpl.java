/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcproject.dao;

import com.sg.vendingmachinespringmvcproject.dto.Item;
import com.sg.vendingmachinespringmvcproject.dto.ItemImpl;
import com.sg.vendingmachinespringmvcproject.service.InSufficientMoney;
import com.sg.vendingmachinespringmvcproject.service.OutOfInventoryException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO USER
 */
public class VmDaoStubImpl implements VmDao {

    Item onlyItem;
    List<Item> itemList = new ArrayList();

    public VmDaoStubImpl() {
        onlyItem = new ItemImpl("snicker", 5, 5);

        itemList.add(onlyItem);

    }

    @Override
    public List<Item> getAllItems() throws persistenceException, InSufficientMoney, OutOfInventoryException {
        return itemList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveItem(Item userChoice) throws persistenceException, InSufficientMoney, OutOfInventoryException {
        //do nothing
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
