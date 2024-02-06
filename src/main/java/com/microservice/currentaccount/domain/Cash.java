package com.microservice.currentaccount.domain;

import javax.persistence.Entity;

@Entity
public class Cash extends PaymentMethod {

    private Integer receiptNumber;

    public Cash() {}

    public Integer getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(Integer receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    @Override
    public String toString() {
        return "Cash [id=" + this.getId() + ", observation=" + this.getObservation() + ", receiptNumber=" + receiptNumber + "]";
    }

}
