package com.fab.fab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fab.fab.dto.MessageDto;
import com.fab.fab.model.InternetBankingChangeModel;
import com.fab.fab.service.InternetBankingChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000", }, maxAge = 3600, allowedHeaders = "*")
@RestController
@RequestMapping("api/internet-banking-changes")
public class InternetBankingChangeController {
    
    @Autowired
    private InternetBankingChangeService internetBankingChangeService;

    @PostMapping
    public ResponseEntity<?> addInternetBankingChange(@RequestBody InternetBankingChangeModel internetBankingChangeModel){
        
        try{

            internetBankingChangeService.addInternetBankingChange(internetBankingChangeModel);

            return ResponseEntity.ok(new MessageDto("Internet Banking Change Added Successfully"));

        }catch(Exception e){

            return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
        }

    }

    @GetMapping
    public ResponseEntity<?> getInternetBankingChanges(){
        
        try{

            return ResponseEntity.ok(internetBankingChangeService.getInternetBankingChanges());

        }catch(Exception e){

            return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
        }

    }

}
