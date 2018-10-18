/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 *
 * @author LENOVO USER
 */
public class OrderImpl implements Order{
    LocalDate date;
    int orderNumber;
    String customerName;
    String state;
    BigDecimal taxRate;
    String productType;
    BigDecimal area;
    BigDecimal costPerSF;
    BigDecimal laborPerSF;


    public OrderImpl( 
            LocalDate date,
            int orderNumber, 
            String customerName, 
            String state, 
            BigDecimal taxRate,
            String productType, 
            BigDecimal area, 
            BigDecimal costPerSF, 
            BigDecimal laborPerSF ) {
         this.state = state;
        this.area = area;
        this.taxRate = taxRate;
        this.costPerSF = costPerSF;
        this.laborPerSF = laborPerSF;
        this.productType = productType;
        this.customerName = customerName;
        this.orderNumber = orderNumber;
        this.date = date;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        public OrderImpl( 
            String customerName, 
            String state, 
            BigDecimal taxRate,
            String productType, 
            BigDecimal area, 
            BigDecimal costPerSF, 
            BigDecimal laborPerSF,
            LocalDate date) {
            
         this.state = state;
        this.area = area;
        this.taxRate = taxRate;
        this.costPerSF = costPerSF;
        this.laborPerSF = laborPerSF;
        this.productType = productType;
        this.customerName = customerName;
        this.date = date;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

  

    

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getCostPerSF() {
        return costPerSF;
    }

    public void setCostPerSF(BigDecimal CostPerSF) {
        this.costPerSF = CostPerSF;
    }

    public BigDecimal getLaborPerSF() {
        return laborPerSF;
    }

    public void setLaborPerSF(BigDecimal laborPerSF) {
        this.laborPerSF = laborPerSF;
    }

    public BigDecimal getMaterialCost() {
        return costPerSF.multiply(area).setScale(2, RoundingMode.HALF_UP);
    }

  

    public BigDecimal getLaborCost() {
        return laborPerSF.multiply(area).setScale(2, RoundingMode.HALF_UP);
    }

   

    public BigDecimal getTax() {
        return getLaborCost().add(getMaterialCost()).multiply(taxRate).divide( new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);
    }

  
    public BigDecimal getTotal() {
        return getLaborCost().add(getTax().add(getMaterialCost())).setScale(2, RoundingMode.HALF_UP);
    }

 

   
    
    
}
