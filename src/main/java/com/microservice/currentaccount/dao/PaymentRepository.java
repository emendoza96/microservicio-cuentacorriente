package com.microservice.currentaccount.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.microservice.currentaccount.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query(value =
        """
            SELECT
                *
            FROM
                payment p
            JOIN
                customer c ON p.customer_id = c.id
            WHERE
                c.cuit = :cuit
        """,
        nativeQuery = true
    )
    public List<Payment> findByCustomerCuit(@Param(value = "cuit") String cuit);

}
