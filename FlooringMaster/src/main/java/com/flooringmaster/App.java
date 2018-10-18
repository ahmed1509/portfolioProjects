/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster;

import com.flooringmaster.controller.FlooringMasterController;
import com.flooringmaster.controller.FlooringMasterControllerImpl;
import com.flooringmaster.dao.OrderAuditDaoFileImpl;
import com.flooringmaster.dao.OrderDao;
import com.flooringmaster.dao.OrderDaoAudit;
import com.flooringmaster.dao.OrderDaoImpl;
import com.flooringmaster.dao.ProductDao;
import com.flooringmaster.dao.ProductDaoImpl;
import com.flooringmaster.dao.TaxesDao;
import com.flooringmaster.dao.TaxesDaoImpl;
import com.flooringmaster.service.FlooringMasterService;
import com.flooringmaster.service.FlooringMasterServiceImpl;
import com.flooringmaster.ui.FlooringMasterView;
import com.flooringmaster.ui.FlooringMasterViewImpl;
import java.io.FileNotFoundException;

/**
 *
 * @author LENOVO USER
 */
public class App {
    public static void main(String[] args) throws FileNotFoundException{
        FlooringMasterView view = new FlooringMasterViewImpl();
        OrderDao orderdao = new OrderDaoImpl();
        TaxesDao states = new TaxesDaoImpl();
        ProductDao products = new ProductDaoImpl();
        OrderDaoAudit audit = new OrderAuditDaoFileImpl();
        FlooringMasterService service = new FlooringMasterServiceImpl(orderdao, states, products, audit);
        FlooringMasterController controller = new FlooringMasterControllerImpl(view, service);
        controller.run();
//     ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//     FlooringMasterController controller = ctx.getBean("controller", FlooringMasterController.class);
//     controller.run();
    }
    
}
