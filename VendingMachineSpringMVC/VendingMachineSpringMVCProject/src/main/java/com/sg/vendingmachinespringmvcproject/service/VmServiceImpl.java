/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcproject.service;

import com.sg.vendingmachinespringmvcproject.dao.VmAuditDao;
import com.sg.vendingmachinespringmvcproject.dao.VmDao;
import com.sg.vendingmachinespringmvcproject.dao.VmFileDaoImpl;
import com.sg.vendingmachinespringmvcproject.dao.persistenceException;
import com.sg.vendingmachinespringmvcproject.dto.Change;
import com.sg.vendingmachinespringmvcproject.dto.ChangeImpl;
import com.sg.vendingmachinespringmvcproject.dto.Item;
import com.sg.vendingmachinespringmvcproject.dto.ItemImpl;
import com.sg.vendingmachinespringmvcproject.io.UserIO;
import com.sg.vendingmachinespringmvcproject.io.UserIOConsoleImpl;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author dsmelser
 */
@Service
public class VmServiceImpl implements VmService {

    VmDao dao;
    private VmAuditDao auditDao;
    
    @Inject
    public VmServiceImpl(VmDao dao, VmAuditDao auditDao) throws persistenceException, UnsupportedEncodingException {
        this.auditDao = auditDao;
        this.dao = new VmFileDaoImpl();
    }

    VmServiceImpl(VmDao dao) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public List<Item> getAllItems() throws persistenceException,InSufficientMoney, OutOfInventoryException{
        return dao.getAllItems();
    }

//    private boolean validateInventory(Item userChoice) {
//        boolean validated = false;
//        if (userChoice != null) {
//            if (userChoice.getInventory() > 0) {
//                //return validated = true;
//            } else {
//                //return validated = false;
//            }
//
//        } else {
//            throw new IllegalArgumentException("Got null for userChoice in ");
//        }
//        
//        return validated;
//
//    }

//    public boolean priceCheck(int moneyInPennies, Item userChoice) {
//        boolean validated;
//        if (moneyInPennies >= userChoice.getPennies()) {
//            return validated = true;
//        } else {
//            return validated = false;
//        }
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public Change vendItem(int moneyInPennies, Item userChoice) throws InSufficientMoney , OutOfInventoryException , persistenceException{
        if(userChoice == null){
            throw new IllegalArgumentException("Got null for userChoice in ");
        }
        
        if(userChoice.getInventory() <= 0){
            throw new OutOfInventoryException("Sorry, it's out of the store!");
            
        }
        if(moneyInPennies <  userChoice.getPennies()){
            throw new InSufficientMoney("Not Enough Money");
        }
        int change = moneyInPennies - userChoice.getPennies();
        Change changeReturned = new ChangeImpl(change);
        
        userChoice.setInventory(userChoice.getInventory()-1);
        
        dao.saveItem(userChoice);
        //auditDao.writeAuditEntry("Product Name: " + userChoice.getName() + " was bought");
        return changeReturned;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
