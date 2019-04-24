/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MessageDAO;
import entities.MessageEntity;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author THINKPAD T450
 */
@Service
public class MessageServiceImpl implements MessageService{
    
    @Resource
    private MessageDAO messageDAO;

    @Override
    public void addMessage(MessageEntity message) {
        messageDAO.save(message);
    }

    @Override
    public List<MessageEntity> getMessages(Long senderID, Long receiverID) {
        return messageDAO.findAll(senderID, receiverID);
    }
    
}
