/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dao;

import com.flooringmaster.dto.Order;
import com.flooringmaster.dto.Product;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
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
public class ProductDaoTest {

    ProductDao product;

    public ProductDaoTest() throws FileNotFoundException {
        product = new ProductDaoImpl();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        Files.copy(Paths.get("seedProduct.txt"), Paths.get("product.txt"), StandardCopyOption.REPLACE_EXISTING);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllProducts method, of class ProductDao.
     */
    @Test
    public void testGetAllProducts() {
        List<Product> list = product.getAllProducts();
        assertEquals(4, list.size());
    }

    /**
     * Test of getProduct method, of class ProductDao.
     */
    @Test
    public void testGetProduct() {

        List<Product> list = product.getAllProducts();

        List<Product> testInput = list.stream().filter(i -> i.getProductType().equalsIgnoreCase("Carpet")).collect(Collectors.toList());
        Product toReturn = testInput.get(0);
        assertEquals("Carpet", toReturn.getProductType());
        assertEquals(new BigDecimal("2.10"), toReturn.getCostPerSF());
        assertEquals(new BigDecimal("2.25"), toReturn.getLaborCostPerSF());

    }

}
