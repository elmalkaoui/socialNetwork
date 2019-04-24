/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.MessageEntity;
import java.util.List;

/**
 *
 * @author THINKPAD T450
 */
public interface MessageDAO {
    
    public void save(MessageEntity msg);
    public void update(MessageEntity msg);
    public void delete(MessageEntity msg);
    public MessageEntity find(long id);
    public List<MessageEntity> findAll(Long senderID, Long receiverID);
    
    
    
}
