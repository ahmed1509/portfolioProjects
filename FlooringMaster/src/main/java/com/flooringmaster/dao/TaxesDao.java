/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dao;

import com.flooringmaster.dto.StateTaxData;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author LENOVO USER
 */
public interface TaxesDao {
   public StateTaxData getStateName();
   public BigDecimal getStateTaxRate();
   public List<StateTaxData> getAllStates();
}
