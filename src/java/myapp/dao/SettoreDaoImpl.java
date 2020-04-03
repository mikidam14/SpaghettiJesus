/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
import myapp.model.Settore;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michele
 */
@Repository("settoreDao")
public class SettoreDaoImpl implements SettoreDao{
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public Settore findById(int id) {
        return (Settore) getSession().get(Settore.class, id);
    }

    @Override
    public List<Settore> findAllSettori() {
        Criteria criteria = getSession().createCriteria(Settore.class);
        return (List<Settore>) criteria.list();
    }
    
}
