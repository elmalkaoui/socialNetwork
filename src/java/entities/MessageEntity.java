/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author THINKPAD T450
 */
@Entity
@XmlRootElement
public class MessageEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String message;
    
    @Column
    private LocalDateTime date;
    
    @Column
    private String fileLink;
    
    @Column
    private String fileType;
    
    @OneToOne( fetch = FetchType.EAGER )
    private UserEntity sender;
    
    @OneToOne( fetch = FetchType.EAGER )
    private UserEntity receiver;

    public MessageEntity() {
    }

    
    public MessageEntity(String message,String file, String contentType, UserEntity sender, UserEntity receiver) {
        this.message = message;
        this.fileLink = file;
        this.fileType = contentType;
        this.sender = sender;
        this.receiver = receiver;        
        date = LocalDateTime.now();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageEntity)) {
            return false;
        }
        MessageEntity other = (MessageEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MessageEntity[ id=" + id + " ]";
    }

    public String getMessage() {
        return message;
    }

    public UserEntity getSender() {
        return sender;
    }

    public UserEntity getReceiver() {
        return receiver;
    }  

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
           
}
