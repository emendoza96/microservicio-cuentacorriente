package com.microservice.currentaccount.domain;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "check_entity")
public class Check extends PaymentMethod {

    private Integer checkNumber;
    private Instant paymentDate;
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
