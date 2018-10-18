/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dao;

import com.flooringmaster.dto.StateTaxData;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
public class TaxesDaoTest {
    TaxesDao taxes;
    public TaxesDaoTest() throws FileNotFoundException {
     taxes = new TaxesDaoImpl();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
         Files.copy(Paths.get("seedTaxes.txt"), Paths.get("Taxes.txt"), StandardCopyOption.REPLACE_EXISTING);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getStateName method, of class TaxesDao.
     */
    @Test
    public void testGetStateName() {
         List<StateTaxData> list =taxes.getAllStates();
        
        List<StateTaxData> toReturn = list.stream().filter( i -> i.getStateName().equalsIgnoreCase("OH")).collect(Collectors.toList());
        StateTaxData item = toReturn.get(0);
        assertEquals(new BigDecimal("6.25"), item.getStateTaxRate());
         assertEquals("OH", item.getStateName());
    }

    /**
     * Test of getStateTaxRate method, of class TaxesDao.
     */
    @Test
    public void testGetStateTaxRate() {
      List<StateTaxData> list =taxes.getAllStates();
        
        List<StateTaxData> toReturn = list.stream().filter( i -> i.getStateName().equalsIgnoreCase("OH")).collect(Collectors.toList());
        StateTaxData item = toReturn.get(0);
        assertEquals(new BigDecimal("6.25"), item.getStateTaxRate());
       
   
    }

    /**
     * Test of getAllStates method, of class TaxesDao.
     */
    @Test
    public void testGetAllStates() {
        List<StateTaxData> list =  taxes.getAllStates();
        assertEquals(4, list.size() );
    }

   
    
}
