/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dao;

import java.time.LocalDate;
import java.util.List;
import com.flooringmaster.dto.Product;
import com.flooringmaster.dto.Order;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author LENOVO USER
 */
public interface OrderDao {
    
     public Order getOneOrder(int orderNumber, LocalDate date) throws FileNotFoundException;
    List<Order> getListOfOrders(LocalDate date)throws FileNotFoundException ;
    public Order removeOrder(Order toRemove) throws IOException;
     public Order editedOrder(Order toEdit) throws FileNotFoundException, IOException;
    Order addOrder(Order toAdd) throws IOException;
    
}
