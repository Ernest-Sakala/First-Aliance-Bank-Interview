package com.fab.fab.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import com.fab.fab.model.AccountModel;
import com.fab.fab.model.BranchModel;
import com.fab.fab.repository.AccountRepository;
import com.fab.fab.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BranchRepository branchRepository;



    public void addAccount(AccountModel accountModel){

        accountModel.setCreatedAt(LocalDateTime.now());
      
        
        accountRepository.save(accountModel);
    }


    public List<AccountModel> getAccounts(){
    
        return accountRepository.findAll();
    }

    public List<AccountModel> getAccountByBranch(int branchId){

        Optional<BranchModel> branch = branchRepository.findById(branchId);

        if(branch.isEmpty()){
            throw new IllegalArgumentException("Branch is not available");
        }


        List<AccountModel> accounts = accountRepository.findByBranchOrderByCreatedAtDesc(branch.get());

        if(accounts.isEmpty()){
            throw new IllegalArgumentException("Accounts not available");
        }


        return accounts;

    } 

}
