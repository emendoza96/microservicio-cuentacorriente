package com.microservice.currentaccount.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.currentaccount.domain.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {

}
