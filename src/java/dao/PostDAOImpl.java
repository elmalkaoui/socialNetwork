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
    public List<PostEntity> findAll(Long user_id){
        Query q =em.createNativeQuery("SELECT p.* FROM PostEntity p, USERENTITY u WHERE p.user_fk = u.ID AND u.ID = "+user_id+"\nUNION\n" +
        "SELECT p.* FROM PostEntity p, USERENTITY u, USER_FRIEND uf WHERE p.user_fk = u.ID AND u.ID in (SELECT friend_id FROM USER_FRIEND WHERE user_id = "+user_id+")"
                + "ORDER by ID DESC", PostEntity.class);
        return q.getResultList();
    }
    
    
    
    
}
