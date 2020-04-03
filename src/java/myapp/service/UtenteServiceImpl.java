/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.dao.UtenteDao;
import myapp.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author michele
 */
@Service("utenteService")
@Transactional
public class UtenteServiceImpl implements UtenteService{
    @Autowired
    private UtenteDao dao;
    
    @Override
    public Utente findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Utente> findAllUtenti() {
        return dao.findAllUtenti();
    }
    
}
