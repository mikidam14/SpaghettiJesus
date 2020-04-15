/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
import myapp.model.Utente;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michele
 */
@Repository("utenteDao")
public class UtenteDaoImpl implements UtenteDao{
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public Utente findById(String id) {
        return (Utente) getSession().get(Utente.class, id);
    }

    @Override
    public List<Utente> findAllUtenti() {
        Criteria criteria = getSession().createCriteria(Utente.class);
        return (List<Utente>) criteria.list();
    }
    
}
