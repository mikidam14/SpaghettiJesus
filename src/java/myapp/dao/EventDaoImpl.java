/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
import myapp.model.Event;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michele
 */
@Repository("eventDao")
public class EventDaoImpl implements EventDao{
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public Event findById(int id) {
        return (Event) getSession().get(Event.class, id);
    }

    @Override
    public void saveEvent(Event event) {
        getSession().persist(event);        
    }

    @Override
    public void deleteEvent(int id) {
        Event e  = (Event) getSession().load(Event.class, id);
        if(e != null) getSession().delete(e);
    }

    @Override
    public List<Event> findAllEvents() {
        Criteria criteria = getSession().createCriteria(Event.class);
        return (List<Event>) criteria.list();
    }
    
}
