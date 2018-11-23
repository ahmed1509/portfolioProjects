/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hotelgreetingcasestudy.dao;

import com.sg.hotelgreetingcasestudy.dto.Company;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;

/**
 *
 * @author LENOVO USER
 */
public interface CompanyDao {
       public void readFromJsonFile();
       public Company getCompany(Company companyName);
       public List<Company> getListOfCompanies();
}
