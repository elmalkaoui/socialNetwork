/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.PostEntity;
import entities.UserEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author THINKPAD T450
 */

@Repository
public class UserDAOImpl implements UserDAO{
    
    @PersistenceContext(unitName = "facebookPU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    @Transactional
    @Override
    public void save(UserEntity user) {
        user = em.merge(user);
        em.persist(user);
    }

    @Transactional
    @Override
    public void update(UserEntity user) {
        UserEntity usr = em.merge(user);
    }
    
    @Transactional
    @Override
    public void delete(UserEntity user) {
        user = em.merge(user);
        em.remove(user);
    }
    
    @Transactional
    @Override
    public UserEntity find(long id) {
        return em.find(UserEntity.class, id);
    }
    
    @Transactional
    @Override
    public List<UserEntity> findAll(long id) {
        Query q =em.createQuery("SELECT u FROM UserEntity u WHERE u.id != "+id);
        return q.getResultList();
    }
    
    @Transactional
    @Override
    public List<UserEntity> findByName(long id, String name) {
        Query q =em.createQuery("SELECT u FROM UserEntity u where u.firstname = '"+name+"' OR u.lastname = '"+name+"' AND u.id !="+id);
        return q.getResultList();
    }  

    @Override
    public void addFriend(UserEntity user, UserEntity friend) {
        user.addFriend(friend);
    }

    @Override
    public void addPost(UserEntity user, PostEntity post) {
        user.addPost(post);
    }

    @Override
    public void removeFriend(UserEntity user, UserEntity friend) {
        user.removeFriend(friend);
    }
    
    
    
}
