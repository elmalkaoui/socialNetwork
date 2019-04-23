/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.NotificationDAO;
import entities.NotificationEntity;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author THINKPAD T450
 */

@Service
public class NotificationServiceImpl implements NotificationService{
    
    @Resource
    private NotificationDAO notificationDAO;
    
    @Override
    public boolean addNotification(NotificationEntity not) {
        notificationDAO.save(not);
        return true;
    }

    @Override
    public List<NotificationEntity> getNotifications(Long userID) {
        return notificationDAO.findAll(userID);
    }
    
}
