/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
import myapp.model.Settore;

/**
 *
 * @author michele
 */
public interface SettoreDao {
    Settore findById(int id);
    List<Settore> findAllSettori();
}
