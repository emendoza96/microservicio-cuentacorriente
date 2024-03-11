package com.microservice.currentaccount.domain;

import java.time.Instant;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Instant paymentDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "method_id")
    @NotNull
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
