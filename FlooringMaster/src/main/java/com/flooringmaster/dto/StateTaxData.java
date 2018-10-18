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
public interface StateTaxData {
    public String getStateName();
    public BigDecimal getStateTaxRate();
    public void setStateName(String stateName);
    public void setStateTaxRate(BigDecimal stateTaxRate);
}
