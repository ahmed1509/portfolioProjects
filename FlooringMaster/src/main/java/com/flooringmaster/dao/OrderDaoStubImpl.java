/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dao;

import com.flooringmaster.dto.Order;
import com.flooringmaster.dto.OrderImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO USER
 */
public class OrderDaoStubImpl implements OrderDao{
    Order onlyOrder;
        LocalDate date;
    int orderNumber;
    String customerName;
    String state;
    BigDecimal taxRate;
    String productType;
    BigDecimal area;
    BigDecimal costPerSF;
    BigDecimal laborPerSF;
    List<Order> orderList = new ArrayList<>();
    public OrderDaoStubImpl(){
        onlyOrder = new OrderImpl(date, orderNumber, customerName, state, taxRate, productType, area, costPerSF, laborPerSF);
        onlyOrder.setDate(LocalDate.of(2018, Month.SEPTEMBER, 17));
        onlyOrder.setOrderNumber(1);
        onlyOrder.setCustomerName("Ahmed");
        onlyOrder.setState("OH");
        onlyOrder.setTaxRate(new BigDecimal(56));
        onlyOrder.setProductType("Carpet");
        onlyOrder.setArea(new BigDecimal(10.00));
        onlyOrder.setCostPerSF(new BigDecimal("10.00"));
        onlyOrder.setLaborPerSF(new BigDecimal("10.00"));
    }
    @Override
    public Order getOneOrder(int orderNumber, LocalDate date) throws FileNotFoundException {
            if(onlyOrder.equals(onlyOrder.getOrderNumber())){
            return onlyOrder;
    }else{
            return null;
        }
    }

    @Override
    public List<Order> getListOfOrders(LocalDate date) throws FileNotFoundException {
        return orderList;
    }

    @Override
    public Order removeOrder(Order toRemove) throws IOException {
         if(onlyOrder.equals(onlyOrder.getOrderNumber())){
            return onlyOrder;
         }else{
            return null;
              }


    }

    @Override
    public Order editedOrder(Order toEdit) throws FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order addOrder(Order toAdd) throws IOException {

        if(onlyOrder.equals(onlyOrder.getOrderNumber())){
            return onlyOrder;
    }else{
            return null;
        }
    
    }
}
