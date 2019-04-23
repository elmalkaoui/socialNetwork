/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.NotificationEntity;
import java.util.List;

/**
 *
 * @author THINKPAD T450
 */
public interface NotificationDAO {
    
    public void save(NotificationEntity not);
    public void update(NotificationEntity not);
    public void delete(NotificationEntity not);
    public NotificationEntity find(long id);
    public List<NotificationEntity> findAll(Long userID);
}
