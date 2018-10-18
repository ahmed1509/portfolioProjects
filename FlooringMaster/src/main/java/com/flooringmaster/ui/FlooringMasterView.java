/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.ui;

import com.flooringmaster.dto.Product;
import com.flooringmaster.dto.StateTaxData;
import java.util.List;
import com.flooringmaster.dto.Order;
import java.time.LocalDate;

/**
 *
 * @author LENOVO USER
 */
public interface FlooringMasterView {
   public Product getProductChoice(List<Product> products);
   public StateTaxData getValidState(List<StateTaxData> states);
    public int printMenuAndGetSelection();
    public Order getNewOrderInfo(List<Product>products, List<StateTaxData> states);

    public void displayCreateSuccessBanner();

    public void displayCreateOrderBanner();

    public void displayListOfOrders();

  
    public LocalDate AskForAdate();
     public int orderNumber();

    public void diplayRemoveAnOrder();

    public void diplaySuccessRemoveAnOrder();

    public void displayUnknownCommandBanner();

    public void displayExitBanner();
    public void printAllItems(List<Order> allOrders);
    public void displayOrderList(Order singleOrder);

    public void displayEditAnOrder();
    public void displayEditAnOrderSuccessfully();
    public Order getNewEditedOrderInfo(List<Product> products, List<StateTaxData> states,Order currentOrder);
    
}
