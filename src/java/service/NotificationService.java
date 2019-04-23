/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.NotificationEntity;
import java.util.List;

/**
 *
 * @author THINKPAD T450
 */
public interface NotificationService {
    
    public boolean addNotification(NotificationEntity not);
    public List<NotificationEntity> getNotifications(Long userID);
    
}
