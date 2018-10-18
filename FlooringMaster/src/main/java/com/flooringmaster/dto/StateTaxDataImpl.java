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
public class StateTaxDataImpl implements StateTaxData{
    String stateName;
    private BigDecimal stateTaxRate;
    
    
    public StateTaxDataImpl(String stateName, BigDecimal stateTaxRate){
        this.stateName= stateName;
        this.stateTaxRate = stateTaxRate;
        
    }
    

   

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setStateTaxRate(BigDecimal stateTaxRate) {
        this.stateTaxRate = stateTaxRate;
    }
            
    

    @Override
    public String getStateName() {
        return stateName;
    }

    @Override
    public BigDecimal getStateTaxRate() {
        return stateTaxRate;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
