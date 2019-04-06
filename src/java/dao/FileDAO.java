/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.FileEntity;

/**
 *
 * @author THINKPAD T450
 */
public interface FileDAO {
    
    public void save(FileEntity file);
    public void update(FileEntity file);
    public void delete(FileEntity file);
    public FileEntity find(long id);
}
