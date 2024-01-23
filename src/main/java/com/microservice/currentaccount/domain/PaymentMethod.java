package com.microservice.currentaccount.domain;

public abstract class PaymentMethod {

    private Integer id;
    private String observation;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getObservation() {
        return observation;
    }
    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "PaymentMethod [id=" + id + ", observation=" + observation + ", ";
    }

}
