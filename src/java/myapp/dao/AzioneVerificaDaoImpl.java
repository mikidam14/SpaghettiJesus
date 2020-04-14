/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
import myapp.model.AzioneVerifica;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author marco
 */
@Repository("azioneverificaDao")
public class AzioneVerificaDaoImpl implements AzioneVerificaDao{
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public AzioneVerifica findById(int id) {
        return (AzioneVerifica) getSession().get(AzioneVerifica.class, id);
    }

    @Override
    public void saveAzioneVerifica(AzioneVerifica azioneverifica) {
        getSession().persist(azioneverifica);
    }

    @Override
    public void deleteAzioneVerifica(int id) {
        AzioneVerifica ac  = (AzioneVerifica) getSession().load(AzioneVerifica.class, id);
        if(ac != null) getSession().delete(ac);
    }

    @Override
    public List<AzioneVerifica> findAllAzioniVerifica() {
        Criteria criteria = getSession().createCriteria(AzioneVerifica.class);
        return (List<AzioneVerifica>) criteria.list();
    }
    
    
}
