package com.kocfinans.kocfinans.repository;

import com.kocfinans.kocfinans.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByTc(Long tcno);
}
