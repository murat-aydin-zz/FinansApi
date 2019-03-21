package com.kocfinans.kocfinans.service;

import com.kocfinans.kocfinans.command.CustomerCommand;
import com.kocfinans.kocfinans.constant.CreditConstant;
import com.kocfinans.kocfinans.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    CustomerService customerService;

    private final static int MULTIPLE = 4;

    @Override
    public CustomerCommand creditApprovalByTc(Long tc) throws ResourceNotFoundException {
        CustomerCommand customerCommand = customerService.findByTc(tc);
        if(customerCommand == null)
            throw new ResourceNotFoundException();


        if(customerCommand.getCreditScore() < 500){
            customerCommand.setLastCreditStatus(0);
        }else if(customerCommand.getCreditScore() > 500 &&
                customerCommand.getCreditScore() < 1000 &&
                customerCommand.getSalary() < 5000
        ){
            customerCommand.setCreditLimit(10000);
            customerCommand.setLastCreditStatus(1);
        }else if (customerCommand.getCreditScore() >= 1000){
            customerCommand.setCreditLimit(customerCommand.getSalary() * MULTIPLE);
            customerCommand.setLastCreditStatus(1);
        }
        return customerService.save(customerCommand);

    }
}
