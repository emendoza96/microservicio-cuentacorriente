package com.microservice.currentaccount.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.currentaccount.domain.Check;

public interface CheckRepository extends JpaRepository<Check, Integer> {

}
