package com.kocfinans.kocfinans.controller;

import com.kocfinans.kocfinans.command.CustomerCommand;
import com.kocfinans.kocfinans.constant.Constant;
import com.kocfinans.kocfinans.model.ServiceResponse;
import com.kocfinans.kocfinans.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerCommand customerCommand){
        ServiceResponse<CustomerCommand> response = new ServiceResponse<>();
        response.setMessage(Constant.SUCCESS.toString());
        response.setResponseCode(HttpStatus.OK.value());
        response.setData(customerService.save(customerCommand));
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
        return  responseEntity;


    }

    @GetMapping("/customer")
    public ResponseEntity<Object> getCustomerAll(){
        ServiceResponse<List<CustomerCommand>> response = new ServiceResponse<>();
        response.setMessage(Constant.SUCCESS.toString());
        response.setResponseCode(HttpStatus.OK.value());
        response.setData(customerService.findAll());
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
        return  responseEntity;
    }

    @GetMapping("/customer/{tcno}")
    public ResponseEntity<Object> getCustomerByTc(@PathVariable Long tcno){
        ServiceResponse<CustomerCommand> response = new ServiceResponse<>();
        response.setMessage(Constant.SUCCESS.toString());
        response.setResponseCode(HttpStatus.OK.value());
        response.setData(customerService.findByTc(tcno));
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
        return  responseEntity;
    }

    @DeleteMapping("/customer/{tcno}")
    public ResponseEntity<Object> deleteCustomerByTc(@PathVariable Long tcno){
        ServiceResponse<CustomerCommand> response = new ServiceResponse<>();
        response.setMessage(Constant.SUCCESS.toString());
        response.setResponseCode(HttpStatus.OK.value());
        customerService.delete(tcno);
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
        return  responseEntity;
    }

}
