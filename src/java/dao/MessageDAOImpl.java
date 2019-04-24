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

    @Override
    public void save(MessageEntity msg) {
        msg = em.merge(msg);
        em.persist(msg);
    }

    @Override
    public void update(MessageEntity msg) {
        msg = em.merge(msg);
        em.persist(msg);
    }

    @Override
    public void delete(MessageEntity msg) {
        em.remove(msg);
    }

    @Override
    public MessageEntity find(long id) {
        return em.find(MessageEntity.class, id );
    }

    @Override
    public List<MessageEntity> findAll(Long senderID, Long receiverID) {
        Query q = em.createQuery("SELECT m FROM MessageEntity m WHERE sender_id = "+senderID+" AND reciver_id = "+receiverID, MessageEntity.class);
        return q.getResultList();
    }

}
