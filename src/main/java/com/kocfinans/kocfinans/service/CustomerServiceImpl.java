package com.kocfinans.kocfinans.service;

import com.kocfinans.kocfinans.command.CustomerCommand;
import com.kocfinans.kocfinans.converter.CustomerCommandToCustomerConverter;
import com.kocfinans.kocfinans.converter.CustomerToCustomerCommandConverter;
import com.kocfinans.kocfinans.domain.Customer;
import com.kocfinans.kocfinans.exception.ResourceNotFoundException;
import com.kocfinans.kocfinans.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerToCustomerCommandConverter customerToCustomerCommandConverter;

    @Autowired
    CustomerCommandToCustomerConverter customerCommandToCustomerConverter;

    @Override
    public List<CustomerCommand> findAll() throws ResourceNotFoundException {
        return customerRepository.findAll().stream().map(customer -> customerToCustomerCommandConverter.convert(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerCommand save(CustomerCommand customerCommand) throws ResourceNotFoundException {
        if(customerCommand == null)
            throw new  ResourceNotFoundException();

       Customer customer = customerRepository.save(customerCommandToCustomerConverter.convert(customerCommand));


       if(customer == null)
           throw new ResourceNotFoundException();
       return customerToCustomerCommandConverter.convert(customer);

    }

    @Override
    public CustomerCommand findByTc(Long tcno) throws ResourceNotFoundException {
        if(tcno == null)
            throw new ResourceNotFoundException();

      return customerRepository.findByTc(tcno).map(customer -> customerToCustomerCommandConverter.convert(customer)).orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public void delete(Long tc) throws ResourceNotFoundException {
        customerRepository.findByTc(tc).map(item -> {
            customerRepository.delete(item);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("Not Found Any Customer -> TC : "+ tc));
    }


}
