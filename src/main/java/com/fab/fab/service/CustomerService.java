package com.fab.fab.service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import com.fab.fab.dto.CustomerDto;
import com.fab.fab.model.CustomerModel;
import com.fab.fab.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CustomerService {
    
    @Autowired
    private  CustomerRepository customerRepository;


    public void addCustomer(MultipartFile photo, String customer) throws JsonMappingException, JsonProcessingException{


        String customerPhoto = StringUtils.cleanPath(photo.getOriginalFilename());

        if(customerPhoto.contains("..")){
            throw new IllegalArgumentException("Invalid file");
        }


        CustomerDto customerDto = new ObjectMapper().readValue(customer, CustomerDto.class);


        CustomerModel customerModel = new CustomerModel();

        customerModel.setCustomerEmail(customerDto.getCustomerEmail());
        customerModel.setCustomerMobile(customerDto.getCustomerMobile());
        customerModel.setCustomerName(customerDto.getCustomerName());
        customerModel.setCreatedAt(LocalDateTime.now());
        customerModel.setCustomerPhoto(Base64.getEncoder().encodeToString(customerPhoto.getBytes()));

        System.out.print(customerModel.getCustomerName());
        
        customerRepository.save(customerModel);
    }


    
    public List<CustomerModel> getCustomers(){
    
       return customerRepository.findAll();
    }


}
