package com.microservice.currentaccount.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.currentaccount.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
