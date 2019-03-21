package com.kocfinans.kocfinans.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    private Long tc;

    private String firstName;

    private String lastName;

    private Integer salary;

    private Integer creditScore;

    private Integer creditLimit;

    private Integer lastCreditStatus;

    public Customer() {
    }
}
