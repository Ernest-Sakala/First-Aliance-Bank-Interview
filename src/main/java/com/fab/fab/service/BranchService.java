package com.fab.fab.service;

import java.time.LocalDateTime;
import java.util.List;

import com.fab.fab.model.BranchModel;
import com.fab.fab.repository.BranchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
    
    @Autowired
    private BranchRepository branchRepository;


    public void addBranch(BranchModel branchModel){

        branchModel.setCreatedAt(LocalDateTime.now());
        branchModel.setUpdatedAt(LocalDateTime.now());
        
        branchRepository.save(branchModel);
    }


    public List<BranchModel> getBranches(){
    
        return branchRepository.findAll();
     }


}
