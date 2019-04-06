/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.UserEntity;
import dao.UserDAO;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import util.Util;

/**
 *
 * @author THINKPAD T450
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Resource
    private UserDAO userDAO;

    @Override
    public void addFriend(UserEntity friend) {
    }

    @Override
    public void removeFriend(UserEntity friend) {

    }

    @Override
    public UserEntity getUserByID(long id) {
        return userDAO.find(id);
    }

    @Override
    public List<UserEntity> search(UserEntity user) {
        return Util.externJoin(userDAO.findAll(user.getId()), user.getFriends());
    }

    @Override
    public List<UserEntity> search(UserEntity user, String username) {
    return userDAO.findByName(user.getId(), username);
    }

    @Override
    public void add(UserEntity user) {
        userDAO.save(user);
    }

    @Override
    public void remove(UserEntity user) {
        userDAO.delete(user);
    }

    @Override
    public void update(UserEntity user) {
        userDAO.update(user);
    }
    
    
       
}
