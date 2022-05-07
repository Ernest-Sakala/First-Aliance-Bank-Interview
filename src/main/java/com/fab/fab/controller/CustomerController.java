package com.fab.fab.controller;

import com.fab.fab.dto.MessageDto;
import com.fab.fab.model.CustomerModel;
import com.fab.fab.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody CustomerModel customerModel){
        
        try{

            customerService.addCustomer(customerModel);

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
