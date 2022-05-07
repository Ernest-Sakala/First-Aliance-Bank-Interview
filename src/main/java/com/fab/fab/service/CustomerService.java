package com.fab.fab.service;

import java.time.LocalDateTime;
import java.util.List;
import com.fab.fab.model.CustomerModel;
import com.fab.fab.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    @Autowired
    private  CustomerRepository customerRepository;


    public void addCustomer(CustomerModel customerModel){

        customerModel.setCreatedAt(LocalDateTime.now());
        
        customerRepository.save(customerModel);
    }


    
    public List<CustomerModel> getCustomers(){
    
       return customerRepository.findAll();
    }


}
