/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.PostEntity;
import java.util.List;

/**
 *
 * @author THINKPAD T450
 */
public interface PostService {
    
    public void addPost(PostEntity post);
    public void removePost(PostEntity post);
    public void update(PostEntity post);
    public List<PostEntity> getPosts(long user_id);
}
