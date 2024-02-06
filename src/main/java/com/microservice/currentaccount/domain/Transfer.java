package com.microservice.currentaccount.domain;

import javax.persistence.Entity;

@Entity
public class Transfer extends PaymentMethod {

    private String originCBU;
    private String destinyCBU;
    private long transferCode;

    public Transfer() {}

    public String getOriginCBU() {
        return originCBU;
    }

    public void setOriginCBU(String originCBU) {
        this.originCBU = originCBU;
    }

    public String getDestinyCBU() {
        return destinyCBU;
    }

    public void setDestinyCBU(String destinyCBU) {
        this.destinyCBU = destinyCBU;
    }

    public long getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(long transferCode) {
        this.transferCode = transferCode;
    }

    @Override
    public String toString() {
        return "Transfer [id=" + this.getId() + ", observation=" + this.getObservation() +  ", originCBU=" + originCBU
                + ", destinyCBU=" + destinyCBU + ", transferCode=" + transferCode + "]";
    }

}
