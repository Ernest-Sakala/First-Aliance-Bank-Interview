package com.fab.fab.service;

import java.time.LocalDateTime;
import java.util.List;
import com.fab.fab.model.AccountChangeModel;
import com.fab.fab.repository.AccountChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountChangeService {
    
    @Autowired
    private AccountChangeRepository accountChangeRepository;


    public void addAccountChange(AccountChangeModel accountChangeModel){

        accountChangeModel.setCreatedAt(LocalDateTime.now());
       
     
        accountChangeRepository.save(accountChangeModel);
    }


    public List<AccountChangeModel> getAccountchanges(){
    
        return accountChangeRepository.findAll();
     }
}
