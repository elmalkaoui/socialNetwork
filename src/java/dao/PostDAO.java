/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.PostEntity;
import java.util.List;

/**
 *
 * @author THINKPAD T450
 */
public interface PostDAO {
    
    public void save(PostEntity post);
    public void update(PostEntity post);
    public void delete(PostEntity post);
    public PostEntity find(long id);
    public List<PostEntity> findAll();
    
}
