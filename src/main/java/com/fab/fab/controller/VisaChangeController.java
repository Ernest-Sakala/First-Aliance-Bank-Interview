package com.fab.fab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fab.fab.dto.MessageDto;
import com.fab.fab.model.VisaChangeModel;
import com.fab.fab.service.VisaChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/visa-changes")
public class VisaChangeController {
    
       
    @Autowired
    private VisaChangeService visaChangeService;

    @PostMapping
    public ResponseEntity<?> addVisaChange(@RequestBody VisaChangeModel visaChangeModel){
        
        try{

            visaChangeService.addVisaChange(visaChangeModel);

            return ResponseEntity.ok(new MessageDto("Account Added Successfully"));

        }catch(Exception e){

            return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
        }

    }

    @GetMapping
    public ResponseEntity<?> getVisaChanges(){
        
        try{

            return ResponseEntity.ok(visaChangeService.getVisaChanges());

        }catch(Exception e){

            return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
        }

    }
}
