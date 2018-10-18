/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.ui;

import com.flooringmaster.dao.OrderDao;
import com.flooringmaster.dao.OrderDaoImpl;
import com.flooringmaster.dto.OrderImpl;
import com.flooringmaster.dto.Product;
import com.flooringmaster.dto.ProductImpl;
import com.flooringmaster.dto.StateTaxData;
import com.flooringmaster.dto.StateTaxDataImpl;
import java.awt.geom.Area;
import java.lang.Thread.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.flooringmaster.dto.Order;

/**
 *
 * @author LENOVO USER
 */
public class FlooringMasterViewImpl implements FlooringMasterView {

    UserIO io = new UserIOConsoleImpl();

    public int printMenuAndGetSelection() {
        io.print("please choose from these options!");
        io.print("* 1. Display Orders");
        io.print("*  * 2. Add an Order");
        io.print("* 3. Edit an Order");
        io.print("* 4. Remove an Order");
        io.print("* 5. Save Current Work");
        io.print("6. Quit");

        return io.readInt("Please Select From the Above Choices!", 1, 6);
    }

    public Order getNewOrderInfo(List<Product> products, List<StateTaxData> states) {
        LocalDate inputDate = AskForAdate();
        String inputCustomerName = io.readString("please enter Customer Name");

        StateTaxData inputState = getValidState(states);
        Product inputProduct = getProductChoice(products);
        BigDecimal inputArea = io.readBigDecimal("please Enter area");

        Order currentOrder
                = new OrderImpl(
                        inputCustomerName,
                        inputState.getStateName(),
                        inputState.getStateTaxRate(),
                        inputProduct.getProductType(),
                        inputArea,
                        inputProduct.getLaborCostPerSF(),
                        inputProduct.getCostPerSF(),
                        inputDate);

        return currentOrder;
    }

    public Order getNewEditedOrderInfo(List<Product> products, List<StateTaxData> states, Order currentOrder) {
      
     
        io.readString("Please hit enter to change the state and everything else: ");
        BigDecimal inputArea = io.readBigDecimal("please Enter the updated area");
        String inputCustomerName = io.readString("please enter the updated Customer Name");
        StateTaxData inputState = getEditedValidState(states);
        Product inputProduct = getEditedProductChoice(products);

        currentOrder.setCustomerName(inputCustomerName);
        if (inputProduct != null) {
            currentOrder.setProductType(inputProduct.getProductType());
            currentOrder.setCostPerSF(inputProduct.getCostPerSF());
            currentOrder.setLaborPerSF(inputProduct.getLaborCostPerSF());
            currentOrder.setArea(inputArea);

        }
        if (inputState != null) {
            currentOrder.setState(inputState.getStateName());
            currentOrder.setTaxRate(inputState.getStateTaxRate());
        }

        return currentOrder;
    }

    public void displayProductBanner() {
        io.print("===Display Product===");
    }

    public Product getProductChoice(List<Product> products) {
        Product output = null;
        boolean isValid = false;
        while (!isValid) {
            String userChoice = io.readString("please enter product type");

            List<Product> matchingProduct = products.stream()
                    .filter(i -> userChoice.equalsIgnoreCase(i.getProductType())).collect(Collectors.toList());

            if (matchingProduct.isEmpty()) {
                isValid = false;
                io.readString("please Enter a valid order");

            } else {
                output = matchingProduct.get(0);
                isValid = true;

            }

        }
        return output;
    }

    public Product getEditedProductChoice(List<Product> products) {
        Product output = null;
        boolean isValid = false;
        while (!isValid) {
            String userChoice = io.readString("please enter product type");
            if (userChoice.equals("")) {
                isValid = true;
            } else {
                List<Product> matchingProduct = products.stream()
                        .filter(i -> userChoice.equalsIgnoreCase(i.getProductType())).collect(Collectors.toList());

                if (matchingProduct.isEmpty()) {
                    isValid = false;
                    io.readString("please Enter a valid order");

                } else {
                    output = matchingProduct.get(0);
                    isValid = true;
                }
            }
        }
        return output;
    }

    public void displayProductList(List<Product> products) {
        for (Product currentProduct : products) {
            io.print(currentProduct.getProductType() + ": "
                    + currentProduct.getCostPerSF() + " "
                    + currentProduct.getLaborCostPerSF());
        }
        io.readString("Please hit enter to continue.");
    }

    public StateTaxData getValidState(List<StateTaxData> states) {
        StateTaxData output = null;
        boolean isValid = false;
        while (!isValid) {
            String userChoice = io.readString("please enter State Name");

            List<StateTaxData> matchingState = states.stream()
                    .filter(i -> userChoice.equalsIgnoreCase(i.getStateName())).collect(Collectors.toList());

            if (matchingState.isEmpty()) {
                isValid = false;
                io.readString("please Enter a valid state name");

            } else {
                output = matchingState.get(0);
                isValid = true;

            }

        }

        return output;

    }

    public StateTaxData getEditedValidState(List<StateTaxData> states) {
        StateTaxData output = null;
        boolean isValid = false;
        while (!isValid) {
            String userChoice = io.readString("please enter the updated state Name");
            if (userChoice.equals("")) {
                isValid = true;
            } else {
                List<StateTaxData> matchingState = states.stream()
                        .filter(i -> userChoice.equalsIgnoreCase(i.getStateName())).collect(Collectors.toList());

                if (matchingState.isEmpty()) {
                    isValid = false;

                } else {
                    output = matchingState.get(0);
                    isValid = true;

                }
            }
        }
        return output;

    }

    @Override
    public void displayCreateSuccessBanner() {
        io.print("order created");
        ///throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayCreateOrderBanner() {
        io.print("====New Order===");
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayListOfOrders() {
        io.print("===List of Orders===");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printAllItems(List<Order> allOrders) {
        allOrders.forEach(singleOrder -> displayOrderList(singleOrder));
        io.readString("Please Enter to Continue");

    }

    @Override
    public void displayOrderList(Order singleOrder) {
//         date,
//                     orderNumber, 
//                     customerName, 
//                     state, 
//                     taxRate,
//                     productType,
//                     area, 
//                     costPerSF, 
//                     laborPerSF
        if (singleOrder != null) {
            io.print("Date: " + singleOrder.getDate());
            io.print("Order Number: " + singleOrder.getOrderNumber());
            io.print("Costumer Name: " + singleOrder.getCustomerName());
            io.print("State Name: " + singleOrder.getState());
            io.print("TaxRate " + singleOrder.getTaxRate());
            io.print("Product Name: " + singleOrder.getProductType());
            io.print("Area: " + singleOrder.getArea());
            io.print("Cost Per Square Foot " + singleOrder.getCostPerSF());
            io.print("Labor Per Square Foot: " + singleOrder.getLaborPerSF());
            io.print("Total Material cost: " + singleOrder.getMaterialCost());
            io.print("Total labor Cost: " + singleOrder.getLaborCost());
            io.print("Tax Amount: " + singleOrder.getTax());
            io.print("Total Cost: " + singleOrder.getTotal());
        } else {
            io.print("No such a order Exist");
        }
    }

    public LocalDate AskForAdate() {
        return io.readLocalDate("Please Enter the date");

    }

    public int orderNumber() {
        return io.readInt("Please Enter the order number");
    }

    @Override
    public void diplayRemoveAnOrder() {
        io.print("===Remove An Order===");
    }

    @Override
    public void diplaySuccessRemoveAnOrder() {
        io.print("Order removed successfully");
    }

    @Override
    public void displayUnknownCommandBanner() {

        io.print("Unknown Command Entered!!!");
    }

    @Override
    public void displayExitBanner() {
        io.print("Good Bye");

    }

    @Override
    public void displayEditAnOrder() {
        io.print("===Edit An order==");
    }

    @Override
    public void displayEditAnOrderSuccessfully() {
        io.print("===Order Edited Successfully==");
    }

}
