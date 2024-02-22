package com.microservice.currentaccount.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.currentaccount.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}