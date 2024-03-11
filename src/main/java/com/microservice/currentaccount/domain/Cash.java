package com.microservice.currentaccount.domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cash extends PaymentMethod {

    @NotNull
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
