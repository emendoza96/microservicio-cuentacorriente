package com.microservice.currentaccount.service.impl;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.currentaccount.dao.PaymentRepository;
import com.microservice.currentaccount.domain.Payment;
import com.microservice.currentaccount.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Optional<Payment> getPaymentById(Integer id) {
        return paymentRepository.findById(id);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> getPaymentsByCustomerCuit(String cuit) {
        return paymentRepository.findByCustomerCuit(cuit);
    }

    @Transactional
    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

}
