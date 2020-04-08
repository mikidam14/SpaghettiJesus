/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
import myapp.model.Team;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco
 */
@Repository("teamDao")
public class TeamDaoImpl implements TeamDao{
@Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public Team findById(int id) {
        return (Team) getSession().get(Team.class, id);
    }

    @Override
    public void saveTeam(Team team) {
        getSession().persist(team);
    }

    @Override
    public void deleteTeam(int id) {
        Team c = (Team) getSession().load(Team.class, id);
	if(c!=null) getSession().delete(c);
    }

    @Override
    public List<Team> findAllTeams() {
        Criteria criteria = getSession().createCriteria(Team.class);
        return (List<Team>) criteria.list();    
    }
    
}
