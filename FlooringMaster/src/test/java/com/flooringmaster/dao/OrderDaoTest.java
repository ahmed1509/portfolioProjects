/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dao;

import com.flooringmaster.dto.Order;
import com.flooringmaster.dto.OrderImpl;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LENOVO USER
 */
public class OrderDaoTest {

    OrderDao orderdao;

    public OrderDaoTest() {
        this.orderdao = new OrderDaoImpl();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
//        LocalDate date = LocalDate.of(2018, Month.SEPTEMBER, 17);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        Files.copy(Paths.get("seed.txt"), Paths.get("data\\Orders_09182018.txt"), StandardCopyOption.REPLACE_EXISTING);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getOneOrder method, of class OrderDao.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetOneOrder() throws Exception {
        LocalDate date = LocalDate.of(2018, 9, 18);
        List<Order> list = orderdao.getListOfOrders(date);

        List<Order> testInput = list.stream().filter(i -> i.getOrderNumber() == 1).collect(Collectors.toList());
        Order order = testInput.get(0);
        assertEquals(1, order.getOrderNumber()); 
        assertEquals("Wise", order.getCustomerName());
        assertEquals("OH", order.getState());
        assertEquals(new BigDecimal("6.25"), order.getTaxRate());
        assertEquals("Wood", order.getProductType());
        assertEquals(new BigDecimal("100.00"), order.getArea());
        assertEquals(new BigDecimal("5.15"), order.getCostPerSF());
        assertEquals(new BigDecimal("4.75"), order.getLaborPerSF());
        assertEquals(new BigDecimal("515.00"), order.getMaterialCost());
        assertEquals(new BigDecimal("475.00"), order.getLaborCost());
        assertEquals(new BigDecimal("61.88"), order.getTax());
        assertEquals(new BigDecimal("1051.88"), order.getTotal());
    }

    /**
     * Test of getListOfOrders method, of class OrderDao.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetListOfOrders() throws Exception {
        LocalDate date = LocalDate.of(2018, 9, 18);
        List<Order> list = orderdao.getListOfOrders(date);
        assertEquals(1, list.size());
    }

    /**
     * Test of removeOrder method, of class OrderDao.
     *
     * @th
     * rows java.lang.Exception
     */
    @Test
    public void testRemoveOrder() throws Exception {
        LocalDate date = LocalDate.of(2018, 9, 18);
        List<Order> listOfOrders = orderdao.getListOfOrders(date);

        List<Order> toRemove = listOfOrders.stream().filter(o -> o.getOrderNumber() == 1).collect(Collectors.toList());
        Order remove = toRemove.get(0);
        orderdao.removeOrder(remove);
        
        List<Order> validationList = orderdao.getListOfOrders(date);
        
        assertEquals(0, validationList.size());
    }

    /**
     * Test of editedOrder method, of class OrderDao.
     */
    @Test
    public void testEditedOrder() throws Exception {
        LocalDate date = LocalDate.of(2018, 9, 18);
        List<Order> list = orderdao.getListOfOrders(date);
        int orderNumber = 1;
        List<Order> LookUpOrderNumber = list.stream().filter(i -> i.getOrderNumber() ==1).collect(Collectors.toList());
        String customerName = "yahooo";
        String state = "OH";
        BigDecimal taxRate = new BigDecimal("10.00");
        String productType = "Carpet";
        BigDecimal area = new BigDecimal("10.00");
        BigDecimal costPerSF = new BigDecimal("5.00");
        BigDecimal laborPerSF = new BigDecimal("10.00");
        OrderDao orderDao = new OrderDaoImpl();
        Order toEdit = new OrderImpl(date, orderNumber, customerName, state, taxRate, productType, area, costPerSF, laborPerSF);
       
        orderDao.editedOrder(toEdit);
       
        
        //1. grab order to edit
        //2. alter order properties
        //3. persist changes in dao
        
        //4. grab order again
        //5. validate that newly grabbed order's properties match your edits
        assertEquals(1, toEdit.getOrderNumber());
        assertEquals("yahooo", toEdit.getCustomerName());
        assertEquals("OH", toEdit.getState());
        assertEquals(new BigDecimal("10.00"), toEdit.getTaxRate() );
        assertEquals("Carpet", toEdit.getProductType() );
        assertEquals(new BigDecimal("10.00"), toEdit.getArea());
        assertEquals(new BigDecimal("5.00"), toEdit.getCostPerSF());
        assertEquals(new BigDecimal("10.00"), toEdit.getLaborPerSF());
                
        //throw new UnsupportedOperationException();

    }

    /**
     * Test of addOrder method, of class OrderDao.
     */
    @Test
    public void testAddOrder() throws Exception {

        LocalDate date = LocalDate.of(2018, Month.SEPTEMBER, 17);
        int orderNumber = 1;
        String customerName = "Ahmed";
        String state = "OH";
        BigDecimal taxRate = new BigDecimal("10.00");
        String productType = "Carpet";
        BigDecimal area = new BigDecimal("10.00");
        BigDecimal costPerSF = new BigDecimal("5.00");
        BigDecimal laborPerSF = new BigDecimal("10.00");
        //List<Order> orderList = new ArrayList<>();

        OrderDao orderDao = new OrderDaoImpl();
        Order onlyOrder = new OrderImpl(date, orderNumber, customerName, state, taxRate, productType, area, costPerSF, laborPerSF);
        //List<Order> listOfOrders = orderList;
        //listOfOrders.add(onlyOrder);
        //orderList.add(onlyOrder);
        //orderdao.OrderWriteToFile();

        orderdao.addOrder(onlyOrder);
        
        assertEquals(30, onlyOrder.getOrderNumber());
        assertEquals("Ahmed", onlyOrder.getCustomerName());
        assertEquals("OH", onlyOrder.getState());
        assertEquals(new BigDecimal("10.00"), onlyOrder.getTaxRate());
        assertEquals("Carpet", onlyOrder.getProductType());
        assertEquals(new BigDecimal("10.00"), onlyOrder.getArea());
        assertEquals(new BigDecimal("5.00"), onlyOrder.getCostPerSF());
        assertEquals(new BigDecimal("10.00"), onlyOrder.getLaborPerSF());
        
        //need to grab the order again and verify its properties
        //throw new UnsupportedOperationException();

    }

}
