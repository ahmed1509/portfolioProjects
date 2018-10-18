/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dao;

import java.time.LocalDate;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Scanner;
import com.flooringmaster.dto.OrderImpl;
import com.flooringmaster.ui.UserIO;
import com.flooringmaster.ui.UserIOConsoleImpl;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import com.flooringmaster.dto.Order;
import java.io.File;

/**
 *
 * @author LENOVO USER
 */
public class OrderDaoImpl implements OrderDao {

    UserIO io = new UserIOConsoleImpl();
    //private ArrayList<Orders> orders = new ArrayList();
//private Map<, Orders> orders = new HashMap<>();

//private static final String ORDER_FILE = "orders.txt";
    private static final String DELIMITER = ",";

    private void OrderWriteToFile(List<Order> orders, LocalDate date) throws IOException {
        PrintWriter out = null;

        String fileNameToWriteTo = convertDateToFile(date);

        out = new PrintWriter(new FileWriter(fileNameToWriteTo));

        out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,"
                + "CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total");
        for (Order currentOrder : orders) {
            out.println(currentOrder.getOrderNumber() + DELIMITER
                    + currentOrder.getCustomerName() + DELIMITER
                    + currentOrder.getState() + DELIMITER
                    + currentOrder.getTaxRate() + DELIMITER
                    + currentOrder.getProductType() + DELIMITER
                    + currentOrder.getArea() + DELIMITER
                    + currentOrder.getCostPerSF() + DELIMITER
                    + currentOrder.getLaborPerSF() + DELIMITER
                    + currentOrder.getMaterialCost() + DELIMITER
                    + currentOrder.getLaborCost() + DELIMITER
                    + currentOrder.getTax() + DELIMITER
                    + currentOrder.getTotal() + DELIMITER);

            out.flush();
        }
        out.close();

    }

    @Override
    public Order getOneOrder(int orderNumber, LocalDate date) throws FileNotFoundException {
        List<Order> orders = getListOfOrders(date);
        Order toReturn = null;
        boolean isValid = false;
        while (!isValid) {
            int userChoice = io.readInt("please enter the order number");
            List<Order> matchingOrder = orders.stream().filter(i -> userChoice == (i.getOrderNumber())).collect(Collectors.toList());
            if (matchingOrder.isEmpty()) {
                isValid = false;
                io.readString("please Enter a valid order");

            } else {
                toReturn = matchingOrder.get(0);
                isValid = true;

            }
        }
        return toReturn;
    }

    @Override
    public List<Order> getListOfOrders(LocalDate date) throws FileNotFoundException {
        List<Order> orders = new ArrayList();
        String fileName = convertDateToFile(date);
        File existFileChecker = new File(fileName);

        if (existFileChecker.exists()) {

            Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));

            String currentLine;
            String currentIndex[];

            scanner.nextLine();
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                currentIndex = currentLine.split(DELIMITER);

                //String dat = currentIndex[0];
                //LocalDate date = LocalDate.parse(date2,DateTimeFormatter.ofPattern("MMddyyyy"));
                String orderNumber1 = currentIndex[0];
                int orderNumber = Integer.parseInt(orderNumber1);

                String customerName = currentIndex[1];

                String state = currentIndex[2];

                String taxRate1 = currentIndex[3];
                BigDecimal taxRate = new BigDecimal(taxRate1);
                //LocalDate localDate1 = LocalDate.parse("2017/05/12",DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                String productType = currentIndex[4];

                String area1 = currentIndex[5];
                BigDecimal area = new BigDecimal(area1);

                String cost = currentIndex[6];
                BigDecimal costPerSF = new BigDecimal(cost);

                String labor = currentIndex[7];
                BigDecimal laborPerSF = new BigDecimal(labor);

                String material = currentIndex[8];
                BigDecimal materialCost = new BigDecimal(material);

                String laborCost1 = currentIndex[9];
                BigDecimal laborCost = new BigDecimal(laborCost1);

                String tax1 = currentIndex[10];
                BigDecimal tax = new BigDecimal(tax1);

                String totalCost = currentIndex[11];
                BigDecimal total = new BigDecimal(totalCost);

                Order currentItem = new OrderImpl(
                        date,
                        orderNumber,
                        customerName,
                        state,
                        taxRate,
                        productType,
                        area,
                        costPerSF,
                        laborPerSF
                );

                orders.add(currentItem);
            }
            scanner.close();
        }
        return orders;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order removeOrder(Order toRemove) throws IOException {
        List<Order> oldList = getListOfOrders(toRemove.getDate());

        List<Order> newList
                = oldList
                        .stream()
                        .filter(i -> toRemove.getOrderNumber() != i.getOrderNumber())
                        .collect(Collectors.toList());
        OrderWriteToFile(newList, toRemove.getDate());

        return toRemove;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order editedOrder(Order toEdit) throws FileNotFoundException, IOException {

//       int orderNumber = toEdit.getOrderNumber();
        List<Order> oldList = getListOfOrders(toEdit.getDate());

        List<Order> filteredOrders = oldList.stream().filter(i -> toEdit.getOrderNumber() != i.getOrderNumber()).collect(Collectors.toList());

        filteredOrders.add(toEdit);
        OrderWriteToFile(filteredOrders, toEdit.getDate());

//         if(findOrder.isEmpty()){
//             toEdit.setOrderNumber(1);
//         }else{
//             toEdit.setOrderNumber(findOrder.stream().mapToInt(i -> i.getOrderNumber() + 1).max().getAsInt());
//         }
//        
//         
//         oldList.remove(toEdit.getDate());
//         findOrder.add(toEdit);
//         OrderWriteToFile(findOrder, toEdit.getDate());
        return toEdit;
    }

    private String convertDateToFile(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ".\\data\\Orders_" + date.format(formatter) + ".txt";
    }

    @Override
    public Order addOrder(Order toAdd) throws IOException {

        //1. get all orders for the same day (so we can re-write the whole file
        List<Order> listOfOrders = getListOfOrders(toAdd.getDate());

        //2. Adjust the order number
        //      if no other orders - 1
        //      otherwise - max of the existing orders + 1
        //3. Add order to the list
        //4. Send list off to be written to the file
        if (listOfOrders.isEmpty()) {
            toAdd.setOrderNumber(1);
        } else {
            toAdd.setOrderNumber(listOfOrders.stream().mapToInt(o -> o.getOrderNumber() + 1).max().getAsInt());
        }
        listOfOrders.add(toAdd);
        OrderWriteToFile(listOfOrders, toAdd.getDate());

        return toAdd;
    }

}
