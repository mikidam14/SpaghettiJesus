/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.dao.SettoreDao;
import myapp.model.Settore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author michele
 */
@Service("settoreService")
@Transactional
public class SettoreServiceImpl implements SettoreService{
    @Autowired
    private SettoreDao dao;
    
    @Override
    public Settore findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Settore> findAllSettori() {
        return dao.findAllSettori();
    }
    
}
