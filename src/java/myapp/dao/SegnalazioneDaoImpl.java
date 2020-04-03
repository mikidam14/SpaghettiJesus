/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
import myapp.model.Segnalazione;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michele
 */
@Repository("segnalazioneDao")
public class SegnalazioneDaoImpl implements SegnalazioneDao{
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public Segnalazione findById(int id) {
        return (Segnalazione) getSession().get(Segnalazione.class, id);
    }

    @Override
    public void saveSegnalazione(Segnalazione segnalazione) {
        getSession().persist(segnalazione);
    }

    @Override
    public void deleteSeganalazione(int id) {
        Segnalazione s  = (Segnalazione) getSession().load(Segnalazione.class, id);
        if(s != null) getSession().delete(s);
    }

    @Override
    public List<Segnalazione> findAllSegnalazioni() {
        Criteria criteria = getSession().createCriteria(Segnalazione.class);
        return (List<Segnalazione>) criteria.list();
    }
    
}
