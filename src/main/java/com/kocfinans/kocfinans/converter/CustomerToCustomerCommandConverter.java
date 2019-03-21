package com.kocfinans.kocfinans.converter;

import com.kocfinans.kocfinans.command.CustomerCommand;
import com.kocfinans.kocfinans.domain.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerCommandConverter implements Converter<Customer, CustomerCommand> {
    @Override
    public CustomerCommand convert(Customer customer) {
        if(customer == null)
            return null;
        CustomerCommand customerCommand = new CustomerCommand();
        customerCommand.setId(customer.getId());
        customerCommand.setTc(customer.getTc());
        customerCommand.setFirstName(customer.getFirstName());
        customerCommand.setLastName(customer.getLastName());
        customerCommand.setSalary(customer.getSalary());
        customerCommand.setCreditScore(customer.getCreditScore());
        customerCommand.setCreditLimit(customer.getCreditLimit());
        customerCommand.setLastCreditStatus(customer.getLastCreditStatus());

        return customerCommand;
    }
}
