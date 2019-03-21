package com.kocfinans.kocfinans.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerCommand {

    private Long id;

    private Long tc;

    private String firstName;

    private String lastName;

    private Integer salary;

    private Integer creditScore;

    private Integer creditLimit;

    private Integer lastCreditStatus;

    public CustomerCommand(Long id, Long tc, String firstName, String lastName, Integer salary, Integer creditScore, Integer creditLimit, Integer lastCreditStatus) {
        this.id = id;
        this.tc = tc;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.creditScore = creditScore;
        this.creditLimit = creditLimit;
        this.lastCreditStatus = lastCreditStatus;
    }
}
