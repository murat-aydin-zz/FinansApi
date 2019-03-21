package com.kocfinans.kocfinans.service;

import com.kocfinans.kocfinans.command.CustomerCommand;
import com.kocfinans.kocfinans.exception.ResourceNotFoundException;

import java.util.List;

public interface CustomerService {

    List<CustomerCommand> findAll() throws ResourceNotFoundException;

    CustomerCommand save(CustomerCommand customerCommand) throws ResourceNotFoundException;

    CustomerCommand findByTc(Long tcno) throws ResourceNotFoundException;

    void delete(Long tc) throws ResourceNotFoundException;



}
