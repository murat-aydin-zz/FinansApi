package com.kocfinans.kocfinans.controller;

import com.kocfinans.kocfinans.command.CustomerCommand;
import com.kocfinans.kocfinans.constant.Constant;
import com.kocfinans.kocfinans.constant.CreditConstant;
import com.kocfinans.kocfinans.constant.CreditStatus;
import com.kocfinans.kocfinans.model.ServiceResponse;
import com.kocfinans.kocfinans.service.CreditService;
import com.kocfinans.kocfinans.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/creditapproval")
public class CustomerCreditApprovalRestController {

    @Autowired
    CreditService creditService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/apply/{tc}")
    public ResponseEntity<Object> approvalCredit(@PathVariable Long tc){
        ServiceResponse<String> response = new ServiceResponse<>();

        response.setResponseCode(HttpStatus.OK.value());

        CustomerCommand customerCommand = creditService.creditApprovalByTc(tc);
        if(customerCommand.getLastCreditStatus() == 1 ){
            response.setData("Kredi Talebiniz Onaylanmıştır limit : " + customerCommand.getCreditLimit());
            response.setMessage(CreditStatus.SUCCESS.toString());
        }
        else{
            response.setData("Kredi Talebiniz Reddedilmiştir ");
            response.setMessage(CreditStatus.DENIED.toString());
        }

        ResponseEntity<Object> responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
        return  responseEntity;

    }


    @GetMapping("/check/{tc}")
    public ResponseEntity<Object> checkCredit(@PathVariable Long tc){
        ServiceResponse<String> response = new ServiceResponse<>();
        CustomerCommand customerCommand  =customerService.findByTc(tc);
        response.setResponseCode(HttpStatus.OK.value());
        response.setMessage(customerCommand.getLastCreditStatus() == 1 ? CreditStatus.SUCCESS.toString() : CreditStatus.DENIED.toString());
        response.setData("Mevcut kredi limitiniz : " + customerCommand.getCreditLimit());
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
        return  responseEntity;

    }

}
