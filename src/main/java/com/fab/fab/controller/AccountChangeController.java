package com.fab.fab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fab.fab.dto.MessageDto;
import com.fab.fab.model.AccountChangeModel;
import com.fab.fab.service.AccountChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000", }, maxAge = 3600, allowedHeaders = "*")
@RestController
@RequestMapping("api/account-changes")
public class AccountChangeController {
    

     
    @Autowired
    private AccountChangeService accountService;

    @PostMapping
    public ResponseEntity<?> addAccountChange(@RequestBody AccountChangeModel accountModel){
        
        try{

            accountService.addAccountChange(accountModel);

            return ResponseEntity.ok(new MessageDto("Account Added Successfully"));

        }catch(Exception e){

            return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
        }

    }

    @GetMapping( produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getAccountChanges(){
        
        try{

            return ResponseEntity.ok(accountService.getAccountchanges());

        }catch(Exception e){

            return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
        }

    }
    
}
