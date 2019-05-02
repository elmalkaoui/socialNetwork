/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author THINKPAD T450
 */
@Entity
@XmlRootElement
public class PostEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String content;
    
    @Column 
    private String fileLink;
    
    @Column 
    private String fileType;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_fk")
    private UserEntity author;
    
    
    
    public PostEntity() {
    }
        
    public PostEntity(String content, String fileLink, String type, UserEntity user) {
        this.content = content;
        this.fileLink = fileLink;
        this.fileType = type;
        this.author = user;
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
        if (!(object instanceof PostEntity)) {
            return false;
        }
        PostEntity other = (PostEntity) object;
        if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PostEntity[ id=" + id + " ]";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileLink() {
        return fileLink;
    }

    public String getFileType() {
        return fileType;
    }

    public UserEntity getAuthor() {
        return author;
    }
    
}
