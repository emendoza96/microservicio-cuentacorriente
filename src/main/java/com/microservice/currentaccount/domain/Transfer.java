package com.microservice.currentaccount.domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Transfer extends PaymentMethod {

    @NotNull
    @Size(min = 16, max = 32)
    private String originCBU;

    @NotNull
    @Size(min = 16, max = 32)
    private String destinyCBU;

    @NotNull
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
