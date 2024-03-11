package com.microservice.currentaccount.domain;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Check extends PaymentMethod {

    @NotNull
    private Integer checkNumber;

    @NotNull
    private Instant paymentDate;

    @NotNull
    @Size(min = 2, max = 64)
    private String bankName;

    public Check() {}

    public Integer getCheckNumber() {
        return checkNumber;
    }
    public void setCheckNumber(Integer checkNumber) {
        this.checkNumber = checkNumber;
    }
    public Instant getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "Check [id=" + this.getId() + ", observation=" + this.getObservation() + ", checkNumber=" + checkNumber
                + ", paymentDate=" + paymentDate + ", bankName=" + bankName + "]";
    }

}
