/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.UserEntity;
import dao.UserDAO;
import entities.PostEntity;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author THINKPAD T450
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Resource
    private UserDAO userDAO;

    @Override
    public void addFriend(UserEntity user, UserEntity friend) {
       userDAO.addFriend(user, friend);
       userDAO.update(user);
    }

    @Override
    public void removeFriend(UserEntity user, UserEntity friend) {
       userDAO.removeFriend(user, friend);
       userDAO.update(user);
    }

    @Override
    public UserEntity getUserByID(long id) {
        return userDAO.find(id);
    }

    @Override
    public List<UserEntity> search(UserEntity user) {
        return userDAO.findAll(user.getId());
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

    @Override
    public void addPost(UserEntity user, PostEntity post) {
        user.addPost(post);
        userDAO.update(user);
    }

    @Override
    public UserEntity getUserByUserName(String username) {
        return userDAO.findByUserName(username);
    }
      
    
}
