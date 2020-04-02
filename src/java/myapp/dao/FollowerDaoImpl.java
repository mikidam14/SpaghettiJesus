/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
import myapp.model.Follower;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michele
 */
@Repository("followerDao")
public class FollowerDaoImpl implements FollowerDao{
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Follower findById(int id) {
        return (Follower) getSession().get(Follower.class, id);
    }

    @Override
    public void saveFollower(Follower follower) {
        getSession().persist(follower);
    }

    @Override
    public void deleteFollower(int id) {
        Follower f = (Follower) getSession().load(Follower.class, id);
        if(f != null) getSession().delete(f);
    }

    @Override
    public List<Follower> findAllFollowers() {
        Criteria criteria = getSession().createCriteria(Follower.class);
        return (List<Follower>) criteria.list();
    }
}
