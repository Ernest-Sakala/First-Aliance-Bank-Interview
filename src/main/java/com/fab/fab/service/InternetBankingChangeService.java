package com.fab.fab.service;

import java.time.LocalDateTime;
import java.util.List;
import com.fab.fab.model.InternetBankingChangeModel;
import com.fab.fab.repository.InternetBankingChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternetBankingChangeService {


    @Autowired
    private InternetBankingChangeRepository internetBankingChangeRepository;


    public void addInternetBankingChange(InternetBankingChangeModel internetBankingChangeModel){

        internetBankingChangeModel.setCreatedAt(LocalDateTime.now());
       
     
        internetBankingChangeRepository.save(internetBankingChangeModel);
    }


    public List<InternetBankingChangeModel> getInternetBankingChanges(){
    
        return internetBankingChangeRepository.findAll();
     }
    
}
