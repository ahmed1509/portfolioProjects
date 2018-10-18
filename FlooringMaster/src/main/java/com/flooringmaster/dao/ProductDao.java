/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flooringmaster.dao;

import java.math.BigDecimal;
import java.util.List;
import com.flooringmaster.dto.Product;

/**
 *
 * @author LENOVO USER
 */
public interface ProductDao {
    public List<Product> getAllProducts();
    public Product getProduct();
    
    
}
