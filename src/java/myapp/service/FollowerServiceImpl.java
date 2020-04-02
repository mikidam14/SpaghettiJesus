/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.dao.FollowerDao;
import myapp.model.Follower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author michele
 */
@Service("followerService")
@Transactional
public class FollowerServiceImpl implements FollowerService{
    @Autowired
    private FollowerDao dao;

    @Override
    public Follower findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveFollower(Follower follower) {
        dao.saveFollower(follower);
    }

    @Override
    public void updateFollower(Follower follower) {
        Follower f = dao.findById(follower.getId());
        if(f != null){
            f.setUsername(follower.getUsername());
            f.setPassword(follower.getPassword());
            f.setEmail(follower.getEmail());
        }
    }

    @Override
    public void deleteFollower(int id) {
        dao.deleteFollower(id);
    }

    @Override
    public List<Follower> findAllFollowers() {
        return dao.findAllFollowers();
    }
}
