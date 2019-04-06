/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.FileEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author THINKPAD T450
 */
@Repository
public class FileDAOImpl implements FileDAO{
    
    
     @PersistenceContext(unitName = "facebookPU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
     
     
    @Override
    public void save(FileEntity file) {
        file = em.merge(file);
        em.persist(file);
    }

    @Override
    public void update(FileEntity file) {
         file = em.merge(file);
         em.persist(file);
    }

    @Override
    public void delete(FileEntity file) {
        file = em.merge(file);
        em.remove(file);
    }

    @Override
    public FileEntity find(long id) {
        return em.find(FileEntity.class, id);
    }
    
    
}
