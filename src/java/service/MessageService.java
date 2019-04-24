/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.MessageEntity;
import java.util.List;

/**
 *
 * @author THINKPAD T450
 */
public interface MessageService {
    
    public void addMessage(MessageEntity message);
    public List<MessageEntity> getMessages(Long senderID, Long receiverID);
}
