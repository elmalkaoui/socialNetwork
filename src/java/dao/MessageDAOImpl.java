/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.MessageEntity;
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
public class MessageDAOImpl implements MessageDAO {

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
    public void save(MessageEntity msg) {
        msg = em.merge(msg);
        em.persist(msg);
    }

    @Transactional
    @Override
    public void update(MessageEntity msg) {
        msg = em.merge(msg);
        em.persist(msg);
    }
    
    @Transactional
    @Override
    public void delete(MessageEntity msg) {
        em.remove(msg);
    }
    
    @Transactional
    @Override
    public MessageEntity find(long id) {
        return em.find(MessageEntity.class, id );
    }

    @Transactional
    @Override
    public List<MessageEntity> findAll(Long senderID, Long receiverID) {
        Query q = em.createNativeQuery("SELECT * FROM MessageEntity m WHERE m.sender_id = "+senderID+" AND m.receiver_id = "+receiverID+" OR m.sender_id = "+receiverID+" AND m.receiver_id = "+senderID, MessageEntity.class);
        return q.getResultList();
    }

}
