/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author LENOVO USER
 */
public interface Order {
    public LocalDate getDate();
    public int getOrderNumber();
     public String getCustomerName();
     public String getState();
      public BigDecimal getTaxRate();
      public String getProductType();
      public BigDecimal getArea();
      public BigDecimal getCostPerSF();
      public BigDecimal getLaborPerSF();
      public BigDecimal getMaterialCost();
      public BigDecimal getLaborCost();
      public BigDecimal getTax();
      public BigDecimal getTotal();
      

    public void setOrderNumber(int i);
     public void setDate(LocalDate date);
    public void setCustomerName(String customerName);
     public void setState(String state);
     public void setTaxRate(BigDecimal taxRate);
     public void setProductType(String productType);
     public void setArea(BigDecimal area);
     public void setCostPerSF(BigDecimal CostPerSF);
     public void setLaborPerSF(BigDecimal laborPerSF);
}   
