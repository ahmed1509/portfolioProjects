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
public interface Product {
    public String getProductType();
    public void setProductType(String productType);
    public BigDecimal getLaborCostPerSF();
    public void setLaborCostPerSF(BigDecimal laborCostPerSF);
    public BigDecimal getCostPerSF ();
    public void setCostPerSF(BigDecimal CostPerSF);
  
}
