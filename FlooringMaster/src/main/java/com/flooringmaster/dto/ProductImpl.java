/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dto;

import java.math.BigDecimal;

/**
 *
 * @author LENOVO USER
 */
public class ProductImpl implements Product{
    String productType;
    
    BigDecimal laborCostPerSF;
    BigDecimal costPerSF;
    
public ProductImpl(  String productType, BigDecimal laborCostPerSF,
    BigDecimal costPerSF){
    this.costPerSF = costPerSF;
    this.laborCostPerSF= laborCostPerSF;
    this.productType= productType;
}

    public ProductImpl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productName) {
        this.productType = productType;
    }

 

    public BigDecimal getLaborCostPerSF() {
        return laborCostPerSF;
    }

    public void setLaborCostPerSF(BigDecimal laborCostPerSF) {
        this.laborCostPerSF = laborCostPerSF;
    }

    public BigDecimal getCostPerSF() {
        return costPerSF;
    }

    public void setCostPerSF(BigDecimal costPerSF) {
        this.costPerSF = costPerSF;
    }



    
}
