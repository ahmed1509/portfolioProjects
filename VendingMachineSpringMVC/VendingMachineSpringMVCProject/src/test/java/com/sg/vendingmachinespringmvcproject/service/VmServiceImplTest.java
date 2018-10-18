/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcproject.service;

import com.sg.vendingmachinespringmvcproject.dao.VmAuditDao;
import com.sg.vendingmachinespringmvcproject.dao.VmAuditDaoFileImpl;
import com.sg.vendingmachinespringmvcproject.dao.VmDao;
import com.sg.vendingmachinespringmvcproject.dao.VmDaoStubImpl;
import com.sg.vendingmachinespringmvcproject.dao.persistenceException;
import com.sg.vendingmachinespringmvcproject.dto.Change;
import com.sg.vendingmachinespringmvcproject.dto.Item;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LENOVO USER
 */
public class VmServiceImplTest{
     
    VmDao dao;
    VmService service;
    VmAuditDao audit = new VmAuditDaoFileImpl();
    public VmServiceImplTest() throws persistenceException, UnsupportedEncodingException{
      this.service = new VmServiceImpl(dao, audit);
      this.dao= new VmDaoStubImpl();
       
    }
    
    
   
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
         String filePath = getClass().getClassLoader().getResource("inventory.txt").getFile();
        filePath =URLDecoder.decode(filePath, "utf-8");
       
       File seedPath = new File(filePath);
        
        Files.copy(Paths.get(seedPath.getAbsolutePath()), Paths.get("inventory.txt"), StandardCopyOption.REPLACE_EXISTING);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllItems method, of class VmServiceImpl.
     */
    @Test
    public void testGetAllItems() throws Exception {
         List<Item> itemList =service.getAllItems();
     
     List<Item> testInput= itemList.stream().filter(i -> 
             i.getName().equalsIgnoreCase("snicker"))
                     .collect(Collectors.toList());

     Item snickers = testInput.get(0);
     assertEquals(400,snickers.getPennies());
     assertEquals(1,snickers.getInventory());
        
        
    }

    /**
     * Test of priceCheck method, of class VmServiceImpl.
     */
   
   

    /**
     * Test of vendItem method, of class VmServiceImpl.
     */
    @Test
    public void testVendItem() throws Exception {
        List<Item> allItems = service.getAllItems();
         List<Item> filteredItems = allItems.stream()
               .filter(i -> i.getName().equalsIgnoreCase("snicker"))
               .collect(Collectors.toList());
       Item snicker = filteredItems.get(0);
       
       try {

           Change testChange = service.vendItem(400, snicker);
           assertEquals(0, testChange.getDollars());
           assertEquals(0, testChange.getQuaters());
           assertEquals(0, testChange.getDimes());
           assertEquals(0, testChange.getNickles());
           assertEquals(0, testChange.getPennies());
        
        
    }catch(InSufficientMoney e){
        fail("throw not Enough Money");
        
    }
       try{
           service.vendItem(0, snicker);
           fail("Exception should be thrown due to no enough Money");
       }
        catch(InSufficientMoney | OutOfInventoryException e){
            
        }
       try{
           snicker.setInventory(0);
           service.vendItem(5, snicker);
           fail("should throw OutOfInventoryException");
       }catch(InSufficientMoney | OutOfInventoryException e){
           
       }
           
       
    }
    
}
