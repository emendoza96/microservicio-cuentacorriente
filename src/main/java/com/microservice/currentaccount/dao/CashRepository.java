package com.microservice.currentaccount.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.currentaccount.domain.Cash;

public interface CashRepository extends JpaRepository<Cash, Integer> {

}
