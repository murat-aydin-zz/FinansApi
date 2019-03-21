package com.kocfinans.kocfinans.converter;

import com.kocfinans.kocfinans.command.CustomerCommand;
import com.kocfinans.kocfinans.domain.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerCommandToCustomerConverter implements Converter<CustomerCommand, Customer> {

    @Override
    public Customer convert(CustomerCommand customerCommand) {
        if(customerCommand == null)
            return null;

        Customer customer = new Customer();
        customer.setId(customerCommand.getId());
        customer.setTc(customerCommand.getTc());
        customer.setFirstName(customerCommand.getFirstName());
        customer.setLastName(customerCommand.getLastName());
        customer.setSalary(customerCommand.getSalary());
        customer.setCreditScore(customerCommand.getCreditScore());
        customer.setCreditLimit(customerCommand.getId() == null ? 0 : customerCommand.getCreditLimit());
        customer.setLastCreditStatus(customerCommand.getId() == null ? 0 : customerCommand.getLastCreditStatus());




        return customer;
    }
}
