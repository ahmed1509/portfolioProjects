/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newdvdproject.dao;

import com.newdvdproject.dto.Dvd;
import java.util.List;

/**
 *
 * @author LENOVO USER
 */
public interface ClassDvdDao {
    Dvd addDvd(String title, Dvd dvd) throws ClassDvdDaoException;
    List<Dvd> getallDvds()throws ClassDvdDaoException;
    Dvd getDvd(String title)throws ClassDvdDaoException;
    Dvd removeDvd(String title)throws ClassDvdDaoException;
    Dvd editDvd(String title)throws ClassDvdDaoException;
    
    
}
