/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.PostEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author THINKPAD T450
 */
@Repository
public class PostDAOImpl implements PostDAO{
    
    @PersistenceContext(unitName = "facebookPU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(PostEntity post) {
        post = em.merge(post);
        em.persist(post);
    }

    @Override
    public void update(PostEntity post) {
        post = em.merge(post);
        em.persist(post);
    }

    @Override
    public void delete(PostEntity post) {
        post = em.merge(post);
        em.remove(post);
    }

    @Override
    public PostEntity find(long id) {
        return em.find(PostEntity.class, id);
    }

    @Override
    public List<PostEntity> findAll() {
        Query q =em.createQuery("SELECT p FROM PostEntity p");
        return q.getResultList();
    }
            
            
    
    
}
