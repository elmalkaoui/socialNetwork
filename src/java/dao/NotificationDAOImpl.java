/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.NotificationEntity;
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
public class NotificationDAOImpl implements NotificationDAO{
    
    
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
    public void save(NotificationEntity not) {
        not = em.merge(not);
        em.persist(not);
    }

    @Transactional    
    @Override
    public void update(NotificationEntity not) {
        not = em.merge(not);
        em.persist(not);
    }
    
    @Transactional
    @Override
    public void delete(NotificationEntity not) {
        em.remove(not);
    }
    
    @Transactional
    @Override
    public NotificationEntity find(long id) {
        return em.find(NotificationEntity.class, id);
    }

    @Transactional    
    @Override
    public List<NotificationEntity> findAll(Long userID) {
        Query q = em.createNativeQuery("SELECT * from NotificationEntity n where n.receiver_id = "+userID, NotificationEntity.class);
        List<NotificationEntity> list = q.getResultList();
        System.out.println("dao.NotificationDAOImpl.findAll() - list size : "+list.size());
        return list;
    }
    
}
