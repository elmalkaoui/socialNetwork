/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.PostEntity;
import entities.UserEntity;
import java.util.List;

/**
 *
 * @author THINKPAD T450
 */
public interface UserDAO {
    
    public void save(UserEntity user);
    public void update(UserEntity user);
    public void delete(UserEntity user);
    public void addFriend(UserEntity user, UserEntity friend);
    public void removeFriend(UserEntity user, UserEntity friend);
    public void addPost(UserEntity user, PostEntity post);
    public UserEntity find(long id);
    public List<UserEntity> findAll(long id);
    public List<UserEntity> findByName(long id, String username);
    
}
