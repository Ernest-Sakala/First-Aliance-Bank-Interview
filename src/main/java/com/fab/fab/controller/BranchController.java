package com.fab.fab.controller;

import com.fab.fab.dto.MessageDto;
import com.fab.fab.model.BranchModel;
import com.fab.fab.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/branches")
public class BranchController {

    
    @Autowired
    private BranchService branchService;

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody BranchModel branchModel){
        
        try{

            branchService.addBranch(branchModel);

            return ResponseEntity.ok(new MessageDto("Customer Added Successfully"));

        }catch(Exception e){

            return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
        }

    }

    @GetMapping
    public ResponseEntity<?> getBranches(){
        
        try{

            return ResponseEntity.ok(branchService.getBranches());

        }catch(Exception e){

            return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
        }

    }
    
}
