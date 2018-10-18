/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vendingmachinedemo;

import com.sg.vendingmachinespringmvcproject.controller.VmController;
import com.sg.vendingmachinespringmvcproject.dao.VmAuditDao;
import com.sg.vendingmachinespringmvcproject.dao.VmAuditDaoFileImpl;
import com.sg.vendingmachinespringmvcproject.dao.VmDao;
import com.sg.vendingmachinespringmvcproject.dao.VmFileDaoImpl;
import com.sg.vendingmachinespringmvcproject.dao.persistenceException;
import com.sg.vendingmachinespringmvcproject.service.VmService;
import com.sg.vendingmachinespringmvcproject.service.VmServiceImpl;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author dsmelser
 */
//public class App {
//    
//    public static void main( String[] args)throws persistenceException{
//        //VmView view = new VmViewImpl();
//        //VmDao dao = new VmFileDaoImpl();
//        //VmAuditDao myVmAuditDao = new VmAuditDaoFileImpl();
//        //VmService service = new VmServiceImpl(dao, myVmAuditDao);
//        //VmController controller = new VmControllerImpl(service, view);
//        //controller.run();
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        VmController controller = context.getBean("VmController", VmController.class);
//        controller.run();
//    }
//    
//}
