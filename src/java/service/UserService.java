/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.PostEntity;
import entities.UserEntity;
import java.util.List;

/**
 *
 * @author THINKPAD T450
 */
public interface UserService {
    
    public void add(UserEntity user);
    public void remove(UserEntity userEntity);
    public void update(UserEntity user);
    public UserEntity getUserByID(long id);
    public List<UserEntity> search(UserEntity user);
    public List<UserEntity> search(UserEntity user, String username);
    public void addFriend(UserEntity user, UserEntity friend);
    public void removeFriend(UserEntity user, UserEntity friend);
    public void addPost(UserEntity user, PostEntity post);
    
    
}
