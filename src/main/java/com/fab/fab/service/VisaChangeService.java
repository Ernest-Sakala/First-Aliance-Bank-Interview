package com.fab.fab.service;

import java.time.LocalDateTime;
import java.util.List;
import com.fab.fab.model.VisaChangeModel;
import com.fab.fab.repository.VisaChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisaChangeService {
   
    @Autowired
    private VisaChangeRepository visaChangeRepository;


    public void addVisaChange(VisaChangeModel visaChangeModel){

        visaChangeModel.setCreatedAt(LocalDateTime.now());
       
     
        visaChangeRepository.save(visaChangeModel);
    }


    public List<VisaChangeModel> getVisaChanges(){
    
        return visaChangeRepository.findAll();
     }
}
