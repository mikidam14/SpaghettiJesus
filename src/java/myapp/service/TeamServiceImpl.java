/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.dao.TeamDao;
import myapp.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */
@Service("teamService")
public class TeamServiceImpl implements TeamService{
    @Autowired
    private TeamDao dao;
    
    @Override
    public Team findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Team> findAllTeams() {
        return dao.findAllTeams();
    }
    
}
