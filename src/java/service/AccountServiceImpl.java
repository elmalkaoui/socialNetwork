/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AccountDAO;
import entities.AccountEntity;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author THINKPAD T450
 */
@Service
public class AccountServiceImpl implements AccountService{
    
        
    @Resource
    private AccountDAO accountDAO;
    
    @Override
    public void signUp(AccountEntity account) {
        accountDAO.save(account);
    }

    @Override
    public void Delete(AccountEntity account) {
        accountDAO.delete(account);
    }

    @Override
    public boolean isExist(String username) {
        return accountDAO.isExist(username);
    }

    @Override
    public AccountEntity signIn(String username, String password) {
         return accountDAO.findByUsernameAndPassword(username, password);
    }

    @Override
    public void updateAccount(AccountEntity account) {
        accountDAO.update(account);
    }
    
}
