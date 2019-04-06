/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.FileDAO;
import entities.FileEntity;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author THINKPAD T450
 */
@Service
public class FileServiceImpl implements FileService {
    
    @Resource
    private FileDAO fileDAO;

    @Override
    public void addFile(FileEntity file) {
        fileDAO.save(file);
    }

    @Override
    public void removeFile(FileEntity file) {
        fileDAO.delete(file);
    }

    @Override
    public void updateFile(FileEntity file) {
        fileDAO.update(file);
    }

    @Override
    public FileEntity getFile(long id) {
        return fileDAO.find(id);
    }
    
}
