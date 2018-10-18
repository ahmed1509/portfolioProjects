/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.service;

import com.flooringmaster.dao.OrderDao;
import com.flooringmaster.dao.OrderDaoAudit;
import com.flooringmaster.dao.OrderPersistenceException;
import com.flooringmaster.dao.ProductDao;
import com.flooringmaster.dao.TaxesDao;
import com.flooringmaster.dto.Order;
import com.flooringmaster.dto.Product;
import com.flooringmaster.dto.StateTaxData;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author LENOVO USER
 */
public class FlooringMasterServiceImpl implements FlooringMasterService{
    OrderDao orderDao;
    TaxesDao statesDao;
    ProductDao productsDao;
    OrderDaoAudit audit;
    public FlooringMasterServiceImpl(OrderDao oDao, TaxesDao sDao, ProductDao pDao, OrderDaoAudit orderAudit){
        orderDao = oDao;
        statesDao = sDao;
        productsDao = pDao;
        audit = orderAudit;
        
    }



    

    @Override
    public List<Order> getListOfOrders(LocalDate date)throws FileNotFoundException  {
        return orderDao.getListOfOrders(date);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order addOrder(Order toAdd) throws IOException, OrderPersistenceException  {
        Order addAnOrder = orderDao.addOrder(toAdd);
        audit.writeAudit("Order Number "  + toAdd.getOrderNumber() + " created");
        return addAnOrder;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Order getRemoveOrder(Order toRemove) throws IOException, OrderPersistenceException{
        
        Order remove = orderDao.removeOrder(toRemove);
        audit.writeAudit("Order Number "  + toRemove.getOrderNumber() + " created");
        return remove;
    }

    @Override
    public Order getOneOrder(int orderNumber, LocalDate date) throws FileNotFoundException {
        
        return orderDao.getOneOrder(orderNumber, date);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order getEditedOrder( Order toEdit) throws IOException {
     
        Order editAnOrder = orderDao.editedOrder(toEdit);
        return editAnOrder;
    }

    @Override
    public List<Product> getAllProducts() {
        return productsDao.getAllProducts();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StateTaxData> getAllStates() {
        return statesDao.getAllStates();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
