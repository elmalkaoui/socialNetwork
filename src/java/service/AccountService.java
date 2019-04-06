/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.AccountEntity;

/**
 *
 * @author THINKPAD T450
 */
public interface AccountService {
    
    public void signUp(AccountEntity account);
    public AccountEntity signIn(String username, String password);
    public void Delete(AccountEntity account);
    public boolean isExist(String username);
    public void updateAccount(AccountEntity account);
    
}
