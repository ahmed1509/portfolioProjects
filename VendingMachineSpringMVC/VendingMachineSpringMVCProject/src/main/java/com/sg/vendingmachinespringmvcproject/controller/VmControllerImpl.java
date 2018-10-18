package com.sg.vendingmachinespringmvcproject.controller;

import com.sg.vendingmachinespringmvcproject.dao.persistenceException;
import com.sg.vendingmachinespringmvcproject.dto.Change;
import com.sg.vendingmachinespringmvcproject.dto.ChangeImpl;
import com.sg.vendingmachinespringmvcproject.dto.Item;
import com.sg.vendingmachinespringmvcproject.service.InSufficientMoney;
import com.sg.vendingmachinespringmvcproject.service.OutOfInventoryException;
import com.sg.vendingmachinespringmvcproject.service.VmService;
import com.sg.vendingmachinespringmvcproject.service.VmServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dsmelser
 */
@Controller
public class VmControllerImpl {

    VmService service;

    public VmControllerImpl(VmService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllItems(Model model) {
        try {
            List<Item> allItems;
            allItems = service.getAllItems();
            model.addAttribute("allItems", allItems);

        } catch (persistenceException ex) {
            String displayErrorMessage = "File Not Loaded";
            model.addAttribute("display", displayErrorMessage);
        } catch (InSufficientMoney ex) {
            String displayErrorMessage = "InSufficient Money: Please Enter Enough Money to get the Item";
            model.addAttribute("displayErrorMessage", displayErrorMessage);
        } catch (OutOfInventoryException ex) {
            String displayErrorMessage = "Sorry: Item is out of Stoc. Try Again later";
            model.addAttribute("displayErrorMessage", displayErrorMessage);
        }

        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String vendTime(HttpServletRequest request, Model model) throws persistenceException, InSufficientMoney, OutOfInventoryException {
        try {
            List<Item> allItems = service.getAllItems();
            model.addAttribute("allItems", allItems);

            String userChoice = request.getParameter("itemName");
            if(userChoice.isEmpty() || userChoice ==""){
                String displayErrorMessage = "please enter an item";
                model.addAttribute("displayErrorMessage", displayErrorMessage);
            }else{
           
            List<Item> matchingItems = allItems.stream().filter(i -> userChoice.equalsIgnoreCase(i.getName())).collect(Collectors.toList());
            Item toReturn = matchingItems.get(0);
            model.addAttribute("toReturn", toReturn);
            
            String amount = request.getParameter("totalMoney");
             if(amount =="" || amount.equalsIgnoreCase("0")){
                String displayErrorMessage = "please enter some Money To vend an Item";
                model.addAttribute("displayErrorMessage", displayErrorMessage);
            }else{
            
            BigDecimal amountToConvert = new BigDecimal(amount);
            int totalMoney = amountToConvert.multiply(new BigDecimal(100)).intValue();
            
            
            
            Change vendTheItem = service.vendItem(totalMoney, toReturn);
            
            
           
            int returnDollar = vendTheItem.getDollars();
            int returnQuarter = vendTheItem.getQuaters();
            int returnDime = vendTheItem.getDimes();
            int returnNickel = vendTheItem.getNickles();
            
            
            model.addAttribute("vendTheItem", vendTheItem);
            model.addAttribute("returnDollar", returnDollar + " Dollars");
            model.addAttribute("returnQuarter", returnQuarter + " Quarters");
            model.addAttribute("returnDime", returnDime + " Dime");
            model.addAttribute("returnNickel", returnNickel + " Nicke");
            
            }}

        } catch (persistenceException ex) {
            String displayErrorMessage = "File Not Loaded";
            model.addAttribute("display", displayErrorMessage);
        } catch (InSufficientMoney ex) {
            String displayErrorMessage = "InSufficient Money: Please Enter Enough Money to get the Item";
            model.addAttribute("displayErrorMessage", displayErrorMessage);
        } catch (OutOfInventoryException ex) {
            String displayErrorMessage = "Sorry: Item is out of Stoc. Try Again later";
            model.addAttribute("displayErrorMessage", displayErrorMessage);
        }
        return "index";

    }
}
//    }
//
//    @Override
//    public void run() {
//        boolean keepGoing = true;
//
//        while (keepGoing) {
//            try {
//                //1. Display items
//                //  1.1 Get all items
//                List<Item> allItems = service.getAllItems();
//
//                //  1.2 Print details for each item.
//                view.printAllItems(allItems);
//
//                //2. Have User select item
//                Item userChoice = view.getUserChoice(allItems);
//
//                //3. Have User enter amount of money
//                int moneyInPennies = view.getMoneyInPennies();
//
//                //4. Vend the item
//                //  4.1 Adjust the inventory
//                //  4.2 calculate amount of change
//                Change changeReturned = service.vendItem(moneyInPennies, userChoice);
//
//                //5. "Return change" (print out change amounts)
//                view.returnChange(changeReturned);
//
//            } catch (persistenceException e) {
//                view.FileNotReadError(e.getMessage());
//            } catch (InSufficientMoney ex) {
//                view.InSufficientFundsError();
//            } catch (OutOfInventoryException ex) {
//                view.InventoryError();
//            }
//
//            //6. Loop to 1 until finished
//            keepGoing = view.askToKeepGoing();
//
//        }
//
//    }
//
//}
