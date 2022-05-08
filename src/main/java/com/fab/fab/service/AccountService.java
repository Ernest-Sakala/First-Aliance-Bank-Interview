package com.fab.fab.service;

import java.time.LocalDateTime;
import java.util.List;

import com.fab.fab.model.AccountModel;
import com.fab.fab.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;


    public void addAccount(AccountModel accountModel){

        accountModel.setCreatedAt(LocalDateTime.now());
      
        
        accountRepository.save(accountModel);
    }


    public List<AccountModel> getAccounts(){
    
        return accountRepository.findAll();
     }

}
