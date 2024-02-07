package com.microservice.currentaccount.service;

import java.util.List;
import java.util.Optional;

import com.microservice.currentaccount.domain.Payment;

public interface PaymentService {

    public Optional<Payment> getPaymentById(Integer id);
    public List<Payment> getAllPayments();
    public List<Payment> getPaymentsByCustomerCuit(String cuit);
    public Payment createPayment(Payment payment);

}
