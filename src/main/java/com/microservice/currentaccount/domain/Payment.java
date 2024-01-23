package com.microservice.currentaccount.domain;

import java.time.Instant;

public class Payment {

    private Integer id;
    private Instant paymentDate;

    private Customer customer;
    private PaymentMethod method;

    public Payment() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "Payment [id=" + id + ", paymentDate=" + paymentDate + ", customer=" + customer + ", method=" + method
                + "]";
    }

}
