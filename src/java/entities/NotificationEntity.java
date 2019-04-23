/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author THINKPAD T450
 */
@Entity
public class NotificationEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne(fetch = FetchType.EAGER)
    private UserEntity sender;
    
    @OneToOne(fetch = FetchType.EAGER)
    private UserEntity receiver;
    
    @OneToOne(fetch = FetchType.EAGER)
    private PostEntity post;

    public NotificationEntity() {
    }
   
    public NotificationEntity(UserEntity sender, UserEntity receiver, PostEntity post) {
        this.sender = sender;
        this.receiver = receiver;
        this.post = post;
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
        if (!(object instanceof NotificationEntity)) {
            return false;
        }
        NotificationEntity other = (NotificationEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NotificationEntity[ id=" + id + " ]";
    }

    public UserEntity getSender() {
        return sender;
    }

    public UserEntity getReceiver() {
        return receiver;
    }

    public PostEntity getPost() {
        return post;
    }
    
}
