/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvcproject.dao;

import com.sg.vendingmachinespringmvcproject.dto.Item;
import com.sg.vendingmachinespringmvcproject.dto.ItemImpl;
import com.sg.vendingmachinespringmvcproject.service.InSufficientMoney;
import com.sg.vendingmachinespringmvcproject.service.OutOfInventoryException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dsmelser
 */
@Repository
public class VmFileDaoImpl implements VmDao {

 File path ;
    
   
    private Map<String, Item> items = new HashMap<>();
   

    private static final String DELIMITER = ",";

    public VmFileDaoImpl() throws persistenceException, UnsupportedEncodingException {
//       path = new File(getClass().getClassLoader().getResource("inventory.txt").getFile());
//        path = new File(URLDecoder.decode(path.getAbsolutePath(), "utf-8"));
        
        String filePath = getClass().getClassLoader().getResource("inventory.txt").getFile();
        filePath =URLDecoder.decode(filePath, "utf-8");
        
        
        path = new File(filePath);
        LoadInventory();
    }

    private void LoadInventory() throws persistenceException {
        Scanner scanner;
        try {
            
            scanner = new Scanner(new BufferedReader(new FileReader(path)));

        } catch (FileNotFoundException e) {
            throw new persistenceException("-_- Couldn't Load Inventory data into Memory", e);
        }
        String currentLine;
        String[] currentIndex;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentIndex = currentLine.split(DELIMITER);

            String name = currentIndex[0];
            String inventory = currentIndex[1];
            int inventory2 = Integer.parseInt(inventory.trim());
            String pennies = currentIndex[2];
            int pennies2 = Integer.parseInt(pennies.trim());

            Item currentItem = new ItemImpl(name, inventory2, pennies2);
            items.put(currentItem.getName(), currentItem);

        }
        scanner.close();
    }

    private void writeVendor() throws persistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(path));
        } catch (IOException e) {
            throw new persistenceException(
                    "Could not save data.", e);
        }

        List<Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            out.println(currentItem.getName() + DELIMITER
                    + currentItem.getInventory() + DELIMITER
                    + currentItem.getPennies());

            out.flush();
        }
        out.close();

    }

    @Override
    public List<Item> getAllItems() throws persistenceException {
        return new ArrayList<Item>(items.values());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveItem(Item userChoice) throws InSufficientMoney, OutOfInventoryException, persistenceException {
        items.put(userChoice.getName(), userChoice);
        writeVendor();
    }
}
