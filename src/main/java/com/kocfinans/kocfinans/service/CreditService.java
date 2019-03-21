package com.kocfinans.kocfinans.service;

import com.kocfinans.kocfinans.command.CustomerCommand;
import com.kocfinans.kocfinans.exception.ResourceNotFoundException;

public interface CreditService {

    CustomerCommand creditApprovalByTc(Long tc) throws ResourceNotFoundException;

}
