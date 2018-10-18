/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcproject.dao;

import com.sg.vendingmachinespringmvcproject.dto.Item;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import static java.rmi.server.RMIClassLoader.getClassLoader;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
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
public class VmFileDaoImplTest {
    VmDao vmDao;
    @Inject
    public VmFileDaoImplTest() throws persistenceException, UnsupportedEncodingException{
        this.vmDao= new VmFileDaoImpl();
    }
    File path;
    
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
     * Test of getAllItems method, of class VmFileDaoImpl.
     */
    @Test
    public void testGetAllItems() throws Exception {
     List<Item> itemList =vmDao.getAllItems();
     
     List<Item> testInput= itemList.stream().filter(i -> 
             i.getName().equalsIgnoreCase("snicker"))
                     .collect(Collectors.toList());

     Item cheetos = testInput.get(0);
     assertEquals(400,cheetos.getPennies());
     assertEquals(2,cheetos.getInventory());
    }

    /**
     * Test of saveItem method, of class VmFileDaoImpl.
     */
    @Test
    public void testSaveItem() throws Exception {
        List<Item> itemList =vmDao.getAllItems();
     
     List<Item> testInput= itemList.stream().filter(i -> 
             i.getName().equalsIgnoreCase("snicker"))
                     .collect(Collectors.toList());

     Item cheetos = testInput.get(0);
     assertEquals(2,cheetos.getInventory());
     cheetos.setInventory(2);
     
     vmDao.saveItem(cheetos);
     List<Item> makeSure = itemList.stream().filter(i -> i.getName().equalsIgnoreCase("snicker")).collect(Collectors.toList());
      cheetos = makeSure.get(0);
     assertEquals(2,cheetos.getInventory());
        
    }
    
}

