/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.service;

import com.flooringmaster.dao.OrderPersistenceException;
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
public interface FlooringMasterService {
    public List<Order> getListOfOrders(LocalDate date)throws FileNotFoundException ;
    public Order getOneOrder(int orderNumber, LocalDate date) throws FileNotFoundException ;
    public Order addOrder(Order toAdd)throws Exception, OrderPersistenceException;
    public Order getRemoveOrder(Order toRemove) throws IOException, OrderPersistenceException;
    public Order getEditedOrder( Order toEdit) throws IOException, OrderPersistenceException;


    public List<Product> getAllProducts();

    public List<StateTaxData> getAllStates();
}
