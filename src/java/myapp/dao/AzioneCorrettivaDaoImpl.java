/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
import myapp.model.AzioneCorrettiva;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michele
 */
@Repository("azionecorrettivaDao")
public class AzioneCorrettivaDaoImpl implements AzioneCorrettivaDao{
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public AzioneCorrettiva findById(int id) {
        return (AzioneCorrettiva) getSession().get(AzioneCorrettiva.class, id);
    }

    @Override
    public void saveAzioneCorrettiva(AzioneCorrettiva azionecorrettiva) {
        getSession().persist(azionecorrettiva);
    }

    @Override
    public void deleteAzioneCorrettiva(int id) {
        AzioneCorrettiva ac  = (AzioneCorrettiva) getSession().load(AzioneCorrettiva.class, id);
        if(ac != null) getSession().delete(ac);
    }

    @Override
    public List<AzioneCorrettiva> findAllAzioniCorrettive() {
        Criteria criteria = getSession().createCriteria(AzioneCorrettiva.class);
        return (List<AzioneCorrettiva>) criteria.list();
    }
    
    
}
