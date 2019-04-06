/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.FileEntity;

/**
 *
 * @author THINKPAD T450
 */
public interface FileService {
    
    public void addFile(FileEntity file);
    public void removeFile(FileEntity file);
    public void updateFile(FileEntity file);
    public FileEntity getFile(long id);
    
}
