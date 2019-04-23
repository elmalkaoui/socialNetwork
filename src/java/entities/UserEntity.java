/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import util.Util;

/**
 *
 * @author THINKPAD T450
 */
@Entity
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String firstname;
    
    @Column
    private String lastname;
    
    @Column
    private String birthdate;

    @Column
    private String imageLink;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    name="user_friend",//correspond à la liste d'amis.
    joinColumns=@JoinColumn(name="user_id", unique = false),
    inverseJoinColumns=@JoinColumn(name="friend_id", unique= false)
    )
    private List<UserEntity> friends = new ArrayList<UserEntity>();
    
    @OneToMany(fetch = FetchType.EAGER)
    private List<PostEntity> posts = new ArrayList<PostEntity>();
    
    
    public UserEntity() {
    }

    public UserEntity(String firstname, String lastname, String birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate; 
        this.imageLink = "https://s3.eu-west-3.amazonaws.com/projectaaw/default-profil.png";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public List<UserEntity> getFriends() {
        return friends;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void addPost(PostEntity postEntity){
        posts.add(postEntity);
    }
    
    public void addFriend(UserEntity friend){
        friends.add(friend);
    }
    
    public void removeFriend(UserEntity friend){
        friends.remove(Util.getPosition(friends, friend.getId()));
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getImageLink() {
        return imageLink;
    }

    @Override
    public String toString() {
        return firstname+" "+lastname;
    }
    
    
}
