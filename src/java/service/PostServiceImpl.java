/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PostDAO;
import entities.PostEntity;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author THINKPAD T450
 */
@Service
public class PostServiceImpl implements PostService {
    
    @Resource
    private PostDAO postDAO;

    @Override
    public void addPost(PostEntity post) {
        postDAO.save(post);
    }

    @Override
    public void removePost(PostEntity post) {
        postDAO.delete(post);
    }

    @Override
    public void update(PostEntity post) {
        postDAO.update(post);
    }

    @Override
    public List<PostEntity> getPosts(long user_id) {
        return postDAO.findAll();
    }
    
    
}
