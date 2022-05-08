package com.fab.fab.controller;

import com.fab.fab.dto.MessageDto;
import com.fab.fab.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000", }, maxAge = 3600, allowedHeaders = "*")
@RestController
@RequestMapping("api/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestPart(value = "photo") MultipartFile photo, @RequestPart(value = "customerDto") String customerDto){
        
        try{

            customerService.addCustomer(photo, customerDto);

            return ResponseEntity.ok(new MessageDto("Customer Added Successfully"));

        }catch(Exception e){

            return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
        }

    }

    @GetMapping
    public ResponseEntity<?> getCustomers(){
        
        try{

            return ResponseEntity.ok(customerService.getCustomers());

        }catch(Exception e){

            return ResponseEntity.badRequest().body(new MessageDto(e.getMessage()));
        }

    }
}
