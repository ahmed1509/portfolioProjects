/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.controller;

import com.flooringmaster.dao.OrderPersistenceException;
import com.flooringmaster.dto.Order;
import com.flooringmaster.dto.Product;
import com.flooringmaster.dto.StateTaxData;
import com.flooringmaster.service.FlooringMasterService;
import com.flooringmaster.service.FlooringMasterServiceImpl;
import com.flooringmaster.ui.FlooringMasterView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO USER
 */
public class FlooringMasterControllerImpl implements FlooringMasterController {
    //FlooringMasterView view = new FlooringMasterViewImpl();
    //OrderDao orderDao = new OrderDaoImpl();
    
    //UserIO io = new UserIOConsoleImpl();
    FlooringMasterView view;
    FlooringMasterService service;
    public FlooringMasterControllerImpl (FlooringMasterView view, FlooringMasterService service){
        this.view = view;
                this.service = service;
    }
    
    
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        while(keepGoing){
            try {
                menuSelection = getMenuSelection();
                switch(menuSelection){
                    case 1:
                        listOrders();
                        break;
                    case 2:
                        createAnOrder();
                        break;
                    case 3:
                        editAnOrder();
                        break;
                    case 4:
                        removeAnOrder();
                        break;
                    case 5:
                        saveCurrentWork();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                        
                }
            } catch (Exception ex) {
                Logger.getLogger(FlooringMasterControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      private void createAnOrder() throws Exception{
        view.displayCreateOrderBanner();
        List<Product> products = service.getAllProducts();
        List<StateTaxData> states = service.getAllStates();
        Order newOrder = view.getNewOrderInfo(products, states);
        service.addOrder(newOrder);
        view.displayCreateSuccessBanner();
    }
      
       private void listOrders() throws FileNotFoundException {
        LocalDate date = view.AskForAdate();
        List<Order> allItems =service.getListOfOrders(date);
        view.printAllItems(allItems);
        
      
        
    }

    private void editAnOrder() throws Exception {
        view.displayEditAnOrder();
        LocalDate date = view.AskForAdate();
        int orderNumber = view.orderNumber();
        Order existenceOrder = service.getOneOrder(orderNumber, date);
        List<Product> products = service.getAllProducts();
        List<StateTaxData> states = service.getAllStates();
        
        Order editedOrder =view.getNewEditedOrderInfo(products, states, existenceOrder);
        service.getEditedOrder(editedOrder);
        view.displayEditAnOrderSuccessfully();
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void removeAnOrder() throws IOException, OrderPersistenceException {
        view.diplayRemoveAnOrder();
        LocalDate date = view.AskForAdate();
        int orderNumber = view.orderNumber();
        Order toRemove = service.getOneOrder(orderNumber, date);
        service.getRemoveOrder(toRemove);
         view.diplaySuccessRemoveAnOrder();
       
    }

    private void saveCurrentWork() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
       private void exitMessage(){
        view.displayExitBanner();
    }
      
}
