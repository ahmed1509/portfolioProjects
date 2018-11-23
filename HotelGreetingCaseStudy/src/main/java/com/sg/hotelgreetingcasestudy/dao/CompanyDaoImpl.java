/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hotelgreetingcasestudy.dao;

import com.sg.hotelgreetingcasestudy.dto.Company;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author LENOVO USER
 */
public class CompanyDaoImpl implements CompanyDao {

    private Map<String, Company> companies = new HashMap<>();

    public void readFromJsonFile() {
        JSONParser parser = new JSONParser();

        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("Companies.json"));

            for (Object o : a) {
                JSONObject jsonObject = (JSONObject) o;

                String companyName = (String) jsonObject.get("company").toString();
                String id = (String) jsonObject.get("id").toString();
                int companyId = Integer.parseInt(id);
                String city = (String) jsonObject.get("city").toString();
                String timeZone = (String) jsonObject.get("timezone").toString();
                
                
                
                Company currentCompany = new Company(companyName, city, timeZone, companyId);
                
                companies.put(currentCompany.getCompanyName(), currentCompany);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Could Not Found File");
        } catch (IOException ex) {
            System.out.println("Could Not Found File");
        } catch (org.json.simple.parser.ParseException ex) {
            System.out.println("Could Not Parse The File");
        }
    }

    @Override
    public List<Company> getListOfCompanies() {
        readFromJsonFile();
        return new ArrayList<>(companies.values());

    }

    @Override
    public Company getCompany(Company companyName) {
        return companies.get(companyName);
        
    }

}
