
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dao;

import com.flooringmaster.dto.StateTaxData;
import com.flooringmaster.dto.StateTaxDataImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author LENOVO USER
 */
public class TaxesDaoImpl implements TaxesDao{
    private Map<String, StateTaxData> states = new HashMap<>();
     private static final String DELIMITER = ",";
     private static final String Tax_FILE = "data\\Taxes.txt";
     
     public TaxesDaoImpl() throws FileNotFoundException{
         readFile();
     }
     
    private void readFile() throws FileNotFoundException {     
    
     
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(Tax_FILE)));


        String currentLine;
        String currentIndex[];
        scanner.nextLine();
        while (scanner.hasNextLine()) {
  
            currentLine = scanner.nextLine();
            currentIndex = currentLine.split(DELIMITER);
            String stateName = currentIndex[0];
            BigDecimal stateTaxRate = new BigDecimal(currentIndex[1]);
            //setting name and state tax to index 0 and 1
            StateTaxData currentTax = new StateTaxDataImpl(stateName, stateTaxRate);
            states.put(currentTax.getStateName(), currentTax);
            
            //adding to
            
           
           
        }
        scanner.close();
    
}

    @Override
    public StateTaxData getStateName() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<StateTaxData> getAllStates(){
        return new ArrayList<StateTaxData>(states.values());
    }
//      public List<Product> getAllProducts() {
//        return new ArrayList<Product>(products.values());
//       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


    @Override
    public BigDecimal getStateTaxRate() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
