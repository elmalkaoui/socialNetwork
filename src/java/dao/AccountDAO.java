/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.AccountEntity;
import java.util.List;

/**
 *
 * @author THINKPAD T450
 */
public interface AccountDAO {
    
    public void save(AccountEntity account);
    public void update(AccountEntity account);
    public void delete(AccountEntity account);
    public boolean isExist(String username);
    public AccountEntity findByUsernameAndPassword(String username, String password);
    public AccountEntity find(long id);
    public List<AccountEntity> findAll();
    public List<AccountEntity> findByUsername(String username);
    
}
