package com.microservice.currentaccount.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.currentaccount.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
