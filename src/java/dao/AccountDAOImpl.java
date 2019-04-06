/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.AccountEntity;
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
public class AccountDAOImpl implements AccountDAO{
    
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
    public void save(AccountEntity account) {
        account = em.merge(account);
        em.persist(account);
    }
    
    @Transactional
    @Override
    public void update(AccountEntity account) {
        em.merge(account);
    }
    
    @Transactional
    @Override
    public void delete(AccountEntity account) {
        account = em.merge(account);
        em.remove(account);
    }
    
    @Transactional
    @Override
    public AccountEntity find(long id) {
        return em.find(AccountEntity.class, id);
    }
    
    @Transactional
    @Override
    public List<AccountEntity> findAll() {
        Query q =em.createQuery("SELECT a FROM AccountEntity a");
        return q.getResultList();
    }
    
    @Transactional
    @Override
    public List<AccountEntity> findByUsername(String username) {
        Query q =em.createQuery("SELECT a FROM AccountEntity a WHERE a.username = '"+username+"'");
        return q.getResultList();
    }

    @Override
    public boolean isExist(String username) {
        Query q =em.createQuery("SELECT a FROM AccountEntity a WHERE a.username = '"+username+"'");        
        return q.getResultList().size() > 0 ? true : false;
    }

    @Override
    public AccountEntity findByUsernameAndPassword(String username, String password) {
        Query q =em.createQuery("SELECT a FROM AccountEntity a WHERE a.username = '"+username+"' AND a.password = '"+password+"'");        
        List result = q.getResultList();
        return !result.isEmpty() ? (AccountEntity)result.get(0) : null;
        
        
    }
    
    
}
