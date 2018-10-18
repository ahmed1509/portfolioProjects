/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.flooringmaster.dto.Product;
import com.flooringmaster.dto.ProductImpl;
import com.flooringmaster.ui.UserIO;
import com.flooringmaster.ui.UserIOConsoleImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.flooringmaster.dto.Order;

/**
 *
 * @author LENOVO USER
 */
public class ProductDaoImpl implements ProductDao{
    UserIO io = new UserIOConsoleImpl();
    
    public ProductDaoImpl() throws FileNotFoundException{
        readFile();
    }

     private Map<String, Product> products = new HashMap<>();
     private static final String DELIMITER = ",";
     private static final String PRODUCT_FILE = "data\\Products.txt";
    private Object productType;


    private void readFile() throws FileNotFoundException {
        
        
        Scanner scanner = null;
   
        scanner = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE)));
       

        String currentLine;
        String currentIndex[];
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentIndex = currentLine.split(DELIMITER);
        
            
            BigDecimal laborCostPerSF = new BigDecimal (currentIndex[1]);
            BigDecimal costPerSF = new BigDecimal (currentIndex[2]);
            String productType = currentIndex[0];
            Product currentProduct = new ProductImpl(productType, laborCostPerSF, costPerSF);
          
            
            products.put(currentProduct.getProductType(), currentProduct);
            
            
           
           
        }
        scanner.close();
    }
    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<Product>(products.values());
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Product getProduct(){
       return products.get(productType);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
